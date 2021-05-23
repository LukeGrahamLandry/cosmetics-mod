package ca.lukegrahamlandry.cosmeticsplugin;

import io.netty.buffer.Unpooled;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.UUID;

public class CosmeticsPlugin extends JavaPlugin implements PluginMessageListener {
    @Override
    public void onEnable(){
        // Fired when the server enables the plugin
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "lukescosmetics", this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "lukescosmetics");
    }

    @Override
    public void onDisable(){
        // Fired when the server stops and disables all plugins
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] message){
        PacketBuffer packet;
        packet = new PacketBuffer(Unpooled.wrappedBuffer(message));
        byte discriminator = packet.readByte();
        UUID playerID = packet.readUniqueId();

        int state = player.getTicksLived() % 20;
        String toDisplay = state >= 10 ? "demo" : "shadow";

        System.out.println(playerID + " vs " + player.getUniqueId() + " " + (player.getUniqueId().equals(playerID)));

        PacketBuffer response = new PacketBuffer(Unpooled.buffer());
        response.writeByte(discriminator);
        response.writeUniqueId(playerID);
        for (int i=0;i<4;i++){
            response.writeString(toDisplay);
        }

        player.sendPluginMessage(this, "lukescosmetics", response.array());

    }
}
