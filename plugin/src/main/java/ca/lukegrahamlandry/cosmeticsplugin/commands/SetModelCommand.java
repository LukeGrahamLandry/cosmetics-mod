package ca.lukegrahamlandry.cosmeticsplugin.commands;

import ca.lukegrahamlandry.cosmeticsplugin.CosmeticsData;
import ca.lukegrahamlandry.cosmeticsplugin.CosmeticsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetModelCommand implements CommandExecutor {
    private final CosmeticsPlugin plugin;
    public SetModelCommand(CosmeticsPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length != 2) {
                // sender.sendMessage("/cosmetic <body part> <model name>");
                return false;
            }

            String part = args[0];
            String model = args[1];

            if (!CosmeticsData.TO_DISPLAY.containsKey(player.getUniqueId())){
                CosmeticsData.TO_DISPLAY.put(player.getUniqueId(), new CosmeticsData.Parts());
            }
            CosmeticsData.Parts toDisplay = CosmeticsData.TO_DISPLAY.get(player.getUniqueId());

            if (part.equals("head")){
                toDisplay.head = model;
            } else if (part.equals("chest")){
                toDisplay.chest = model;
            } else if (part.equals("legs")){
                toDisplay.legs = model;
            } else if (part == "feet"){
                toDisplay.feet = model;
            } else {
                sender.sendMessage("valid body parts: 'head', 'chest', 'legs', 'feet'");
            }

            System.out.println(toDisplay);

            this.plugin.syncPlayerToAll(player.getUniqueId());
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
