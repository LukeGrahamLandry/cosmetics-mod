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
        PacketBuffer packet = new PacketBuffer(Unpooled.wrappedBuffer(message));
        byte discriminator = packet.readByte();
        UUID playerID = packet.readUniqueId();
        String model = packet.readString(999);

        System.out.println(playerID + " vs " + player.getUniqueId() + " " + (player.getUniqueId().equals(playerID) + " said " + model));

        PacketBuffer response = new PacketBuffer(Unpooled.buffer());
        response.writeByte(discriminator);
        response.writeUniqueId(playerID);
        response.writeString("plugin says hi");
        player.sendPluginMessage(this, "lukescosmetics", response.array());

    }
}
