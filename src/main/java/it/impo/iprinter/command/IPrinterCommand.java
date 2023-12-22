package it.impo.iprinter.command;

import it.impo.iprinter.utils.Config;
import it.impo.iprinter.utils.internal.ItemStack;
import it.impo.iprinter.utils.object.PrinterUtils;
import org.apache.commons.io.FileUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import static it.impo.iprinter.IPrinter.plugin;

public class IPrinterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("printer.give")){
            player.sendMessage(Config.NO_PERMISSION);
            return true;
        }
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("reload")){
                reloadConfig();
                player.sendMessage(Config.RELOAD_TRUE);
                return true;
            }
            if (args[0].equalsIgnoreCase("give")){
                player.getInventory().addItem(ItemStack.createItemStack(PrinterUtils.getMaterial(),
                        PrinterUtils.getName(), PrinterUtils.getCustomModelData(), PrinterUtils.getLore()));
                player.sendMessage(Config.GIVE_TRUE);
                return true;
            }
        }
        Config.getHelpMessage(player);
        return true;
    }
    static void reloadConfig(){
        try {
            File originalConfig = new File(plugin.getDataFolder(), "config.yml");
            File backupConfig = new File(plugin.getDataFolder(), "config_backup.yml");
            FileUtils.copyFile(originalConfig, backupConfig);
            FileUtils.copyFile(backupConfig, originalConfig);
            plugin.reloadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
