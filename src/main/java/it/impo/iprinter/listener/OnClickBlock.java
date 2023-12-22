package it.impo.iprinter.listener;

import it.impo.iprinter.utils.Config;
import it.impo.iprinter.utils.internal.TickCalc;
import it.impo.iprinter.utils.object.PrinterUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

import static it.impo.iprinter.IPrinter.plugin;

public class OnClickBlock implements Listener {
    HashMap<Player, ItemStack> itemStackHashMap = new HashMap<>();
    @EventHandler
    public void onClickBlock(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (e.getHand() != EquipmentSlot.HAND) return;
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (e.getClickedBlock().getType() != PrinterUtils.getMaterial()) return;
        e.setCancelled(true);
        if (!player.hasPermission("printer.use")){
            player.sendMessage(Config.NO_PERMISSION);
            return;
        }
        if (player.getInventory().getItemInMainHand().getType() != Material.WRITABLE_BOOK && player.getInventory().getItemInMainHand().getType() != Material.WRITTEN_BOOK){
            player.sendMessage(Config.ITEM_NO_FOUND);
            return;
        }
        if (itemStackHashMap.containsKey(player)) return;
        player.closeInventory();
        itemStackHashMap.put(player, player.getInventory().getItemInMainHand());
        player.sendMessage(Config.ON_PRINT);
        plugin.getServer().getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                player.sendMessage(Config.PRINT_TRUE);
                player.getInventory().addItem(itemStackHashMap.get(player));
                itemStackHashMap.remove(player);
            }
        }, TickCalc.onTick());
    }
}
