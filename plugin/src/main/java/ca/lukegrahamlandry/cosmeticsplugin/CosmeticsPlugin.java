package ca.lukegrahamlandry.cosmeticsplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class CosmeticsPlugin extends JavaPlugin implements PluginMessageListener {
    @Override
    public void onEnable(){
        // Fired when the server enables the plugin
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "lukescosmetics", this);
    }

    @Override
    public void onDisable(){
        // Fired when the server stops and disables all plugins
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] message){
        System.out.println(player.getName() + " " + message);
    }
}
