package it.impo.iprinter.utils.internal;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemStack {
    public static org.bukkit.inventory.ItemStack createItemStack(Material material, String name, int model, List<String> lore){
        org.bukkit.inventory.ItemStack itemStack = new org.bukkit.inventory.ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Color.translateHexColorCodes(name));
        itemMeta.setCustomModelData(model);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static org.bukkit.inventory.ItemStack createItemStack(Material material, String name, int model, int amount, List<String> lore){
        org.bukkit.inventory.ItemStack itemStack = new org.bukkit.inventory.ItemStack(material);
        itemStack.setAmount(amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Color.translateHexColorCodes(name));
        itemMeta.setCustomModelData(model);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
