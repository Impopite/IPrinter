package it.impo.iprinter.utils;

import it.impo.iprinter.utils.internal.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

import static it.impo.iprinter.IPrinter.plugin;
public class Config {
    public static String PREFIX = Color.translateHexColorCodes(plugin.getConfig().getString("Settings.prefix"));
    public static String ITEM_NO_FOUND = Color.translateHexColorCodes(plugin.getConfig().getString("Messages.Errors.item-no-found").replace("%prefix%", PREFIX));
    public static String NO_PERMISSION = Color.translateHexColorCodes(plugin.getConfig().getString("Messages.Errors.no-permission").replace("%prefix%", PREFIX));
    public static String ON_PRINT = Color.translateHexColorCodes(plugin.getConfig().getString("Messages.on-print").replace("%prefix%", PREFIX));
    public static String PRINT_TRUE = Color.translateHexColorCodes(plugin.getConfig().getString("Messages.print-true").replace("%prefix%", PREFIX));
    public static String GIVE_TRUE = Color.translateHexColorCodes(plugin.getConfig().getString("Messages.give-true").replace("%prefix%", PREFIX));
    public static String RELOAD_TRUE = Color.translateHexColorCodes(plugin.getConfig().getString("Messages.reload-true").replace("%prefix%", PREFIX));
    public static void getHelpMessage(Player player) {
        FileConfiguration config = plugin.getConfig();
        if (config.contains("Messages.help-message")) {
            List<String> helpMessageList = config.getStringList("Messages.help-message");
            StringBuilder helpMessageBuilder = new StringBuilder();
            for (String line : helpMessageList) {
                String translatedLine = Color.translateHexColorCodes(line);
                helpMessageBuilder.append(translatedLine).append("\n");
            }
            String helpMessage = helpMessageBuilder.toString().trim();
            player.sendMessage(helpMessage);
        }
    }
}
