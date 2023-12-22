package it.impo.iprinter.utils.object;

import it.impo.iprinter.utils.internal.Color;
import org.bukkit.Material;

import java.util.List;

import static it.impo.iprinter.IPrinter.plugin;

public class PrinterUtils {

    public static Material getMaterial(){
        return Material.valueOf(plugin.getConfig().getString("Settings.Item.type"));
    }
    public static String getName(){
        return Color.translateHexColorCodes(plugin.getConfig().getString("Settings.Item.name"));
    }
    public static int getCustomModelData(){
        return plugin.getConfig().getInt("Settings.Item.custom-model-data");
    }
    public static List<String> getLore() {
        List<String> lore = plugin.getConfig().getStringList("Settings.Item.Lore");
        for (int i = 0; i < lore.size(); i++) {
            String translated = Color.translateHexColorCodes(lore.get(i));
            lore.set(i, translated);
        }
        return lore;
    }
}
