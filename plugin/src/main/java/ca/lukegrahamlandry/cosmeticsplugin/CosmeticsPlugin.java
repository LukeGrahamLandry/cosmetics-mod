package ca.lukegrahamlandry.cosmeticsplugin;

import ca.lukegrahamlandry.cosmeticsplugin.commands.SetModelCommand;
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

        this.getCommand("cosmetic").setExecutor(new SetModelCommand(this));
    }

    @Override
    public void onDisable(){
        // Fired when the server stops and disables all plugins
    }


    // it only sends a packet when someone first joins
    byte discriminator;
    public void onPluginMessageReceived(String channel, Player player, byte[] message){
        PacketBuffer packet;
        packet = new PacketBuffer(Unpooled.wrappedBuffer(message));
        discriminator = packet.readByte();

        syncAllToPlayer(player);
        syncPlayerToAll(player.getUniqueId());
    }

    // syncs the cosmetic changes of one player to all clients
    public void syncPlayerToAll(UUID playerToUpdate) {
        PacketBuffer packetData = new PacketBuffer(Unpooled.buffer());
        packetData.writeByte(discriminator);
        packetData.writeUniqueId(playerToUpdate);
        packetData.writeString(CosmeticsData.TO_DISPLAY.get(playerToUpdate).head);
        packetData.writeString(CosmeticsData.TO_DISPLAY.get(playerToUpdate).chest);
        packetData.writeString(CosmeticsData.TO_DISPLAY.get(playerToUpdate).legs);
        packetData.writeString(CosmeticsData.TO_DISPLAY.get(playerToUpdate).feet);

        for (Player player : this.getServer().getOnlinePlayers()){
            player.sendPluginMessage(this, "lukescosmetics", packetData.array());
        }
    }


    // to be used when a player joins. gets all the cosmetics to display for everyone
    public void syncAllToPlayer(Player playerToUpdate) {
        for (Player player : this.getServer().getOnlinePlayers()){
            UUID current = player.getUniqueId();
            PacketBuffer packetData = new PacketBuffer(Unpooled.buffer());
            packetData.writeByte(discriminator);
            packetData.writeUniqueId(current);
            packetData.writeString(CosmeticsData.TO_DISPLAY.get(current).head);
            packetData.writeString(CosmeticsData.TO_DISPLAY.get(current).chest);
            packetData.writeString(CosmeticsData.TO_DISPLAY.get(current).legs);
            packetData.writeString(CosmeticsData.TO_DISPLAY.get(current).feet);

            playerToUpdate.sendPluginMessage(this, "lukescosmetics", packetData.array());
        }
    }
}
