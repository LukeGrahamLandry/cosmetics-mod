package ca.lukegrahamlandry.cosmeticsplugin;

import ca.lukegrahamlandry.cosmeticsplugin.commands.SetModelCommand;
import com.google.gson.*;
import io.netty.buffer.Unpooled;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class CosmeticsPlugin extends JavaPlugin implements PluginMessageListener, Listener {
    public Permission permission;

    @Override
    public void onEnable(){
        // Fired when the server enables the plugin
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "lukescosmetics", this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "lukescosmetics");

        if (!this.setupPermissions()) System.out.println("cosmetics failed to setup permissions !!!! THIS IS A PROBLEM");
        this.getCommand("cosmetic").setExecutor(new SetModelCommand(this));

        getServer().getPluginManager().registerEvents(this, this);

        if (getDataFolder().exists()){
            File saved = new File(getDataFolder(), "cosmetics.json");
            if (saved.exists()){
                String data = readMultiline(saved);
                JsonObject obj = new JsonParser().parse(data).getAsJsonObject();

                obj.entrySet().forEach((entry) -> {
                    UUID id = UUID.fromString(entry.getKey());
                    CosmeticsData.Parts parts = new CosmeticsData.Parts();
                    JsonObject savedData = entry.getValue().getAsJsonObject();
                    parts.head = savedData.get("head").getAsString();
                    parts.chest = savedData.get("chest").getAsString();
                    parts.legs = savedData.get("legs").getAsString();
                    parts.feet = savedData.get("feet").getAsString();
                    CosmeticsData.TO_DISPLAY.put(id, parts);
                });
            }
        }
    }

    @Override
    public void onDisable(){
        JsonObject cosmeticsToSave = new JsonObject();

        CosmeticsData.TO_DISPLAY.forEach((uuid, parts) -> {
            JsonObject partsJson = new JsonObject();
            partsJson.addProperty("head", parts.head);
            partsJson.addProperty("chest", parts.chest);
            partsJson.addProperty("legs", parts.legs);
            partsJson.addProperty("feet", parts.feet);
            cosmeticsToSave.add(uuid.toString(), partsJson);
        });

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String stringToSave = gson.toJson(cosmeticsToSave);

        if (!getDataFolder().exists()) getDataFolder().mkdirs();
        File saved = new File(getDataFolder(), "cosmetics.json");
        try {
            FileWriter writer = new FileWriter(saved);
            writer.write(stringToSave);
            writer.close();
        } catch (IOException e){
            System.out.println("couldn't create file");
            e.printStackTrace();
        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // for testing. remember these are persistant so if you set them once, change the code but dont remove them, you'll still have them
        // this.permission.playerAdd(null, event.getPlayer(), "3darmor.head.demo");
        // this.permission.playerAdd(null, event.getPlayer(), "3darmor.head.potato");
        // this.permission.playerAdd(null, event.getPlayer(), "3darmor.feet.potato");
        // System.out.println("join" + this.permission.playerHas(null, event.getPlayer(), "3darmor.head.demo"));

        if (!CosmeticsData.TO_DISPLAY.containsKey(event.getPlayer().getUniqueId())) CosmeticsData.TO_DISPLAY.put(event.getPlayer().getUniqueId(), new CosmeticsData.Parts());

        getServer().broadcastMessage("player joined");
        new BukkitRunnable() {
            @Override
            public void run() {
                getServer().broadcastMessage("run sync cosmetics");

                Object[] players = getServer().getOnlinePlayers().toArray();
                for (Object player : players){
                    getServer().broadcastMessage(((Player)player).getDisplayName() + ": " + CosmeticsData.TO_DISPLAY.get(((Player)player).getUniqueId()));
                    syncPlayerToAll(((Player)player).getUniqueId());
                }
            }

        }.runTaskLater(this, 20);

        // syncAllToPlayer(event.getPlayer());
        // syncPlayerToAll(event.getPlayer().getUniqueId());
        //for (Player player : this.getServer().getOnlinePlayers()){
          //  syncPlayerToAll(player.getUniqueId());
        //}
    }

    // was supposed to be set by the commented code but its 0 so the lowest byte value is fine (as long as you dont change the value in the mod)
    byte discriminator;

    // it only sends a packet when someone first joins
    // now doesnt even do that, can remove

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


    private static String readMultiline(File dataLocation){
        StringBuilder data = new StringBuilder();

        try {
            Scanner reader = new Scanner(dataLocation);
            while (reader.hasNext()){
                data.append(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data.toString();
    }
}
