package ca.lukegrahamlandry.cosmeticsplugin;

import ca.lukegrahamlandry.cosmeticsplugin.commands.SetModelCommand;
import io.netty.buffer.Unpooled;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.UUID;

public class CosmeticsPlugin extends JavaPlugin implements PluginMessageListener, Listener {
    public Permission permission;

    @Override
    public void onEnable(){
        // Fired when the server enables the plugin
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "lukescosmetics", this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "lukescosmetics");

        if (!this.setupPermissions()) System.out.println("failed to setup permissions !!!! THIS IS A PROBLEM");
        this.getCommand("cosmetic").setExecutor(new SetModelCommand(this));

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){
        // Fired when the server stops and disables all plugins
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // for testing. remember these are persistant so if you set them once, change the code but dont remove them, you'll still have them
        // this.permission.playerAdd(null, event.getPlayer(), "3darmor.head.demo");
        // this.permission.playerAdd(null, event.getPlayer(), "3darmor.head.potato");
        // this.permission.playerAdd(null, event.getPlayer(), "3darmor.feet.potato");
        // System.out.println("join" + this.permission.playerHas(null, event.getPlayer(), "3darmor.head.demo"));

        if (!CosmeticsData.TO_DISPLAY.containsKey(event.getPlayer().getUniqueId())) CosmeticsData.TO_DISPLAY.put(event.getPlayer().getUniqueId(), new CosmeticsData.Parts());
        syncAllToPlayer(event.getPlayer());
        syncPlayerToAll(event.getPlayer().getUniqueId());
    }


    // was supposed to be set by the commented code but its 0 so the lowest byte value is fine
    byte discriminator;

    // it only sends a packet when someone first joins

    public void onPluginMessageReceived(String channel, Player player, byte[] message){
        /* client isnt actually senidng the packet so dont need this
        PacketBuffer packet;
        packet = new PacketBuffer(Unpooled.wrappedBuffer(message));
        discriminator = packet.readByte();

        this.permission.playerAdd(null, player, "3darmor.head.demo");
        this.permission.playerAdd(null, player, "3darmor.head.potato");
        this.permission.playerAdd(null, player, "3darmor.feet.potato");
        System.out.println("join packet");

        System.out.println(this.permission.playerHas(null, player, "3darmor.head.demo"));


        CosmeticsData.TO_DISPLAY.put(player.getUniqueId(), new CosmeticsData.Parts());
        syncAllToPlayer(player);
        syncPlayerToAll(player.getUniqueId());

         */
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
            // System.out.println(player.getName());
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

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(Permission.class);
        if (permissionProvider != null) {
            this.permission = ((Permission)permissionProvider.getProvider());
        }
        return this.permission != null;
    }
}
