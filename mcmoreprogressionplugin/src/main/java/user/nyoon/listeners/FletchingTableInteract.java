package user.nyoon.listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.plugincore.PluginCore;

public class FletchingTableInteract implements Listener {
	private Plugin plugin = PluginCore.getPlugin(PluginCore.class);
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void cancelEnchantTableInteract(PlayerInteractEvent event) {
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getPlayer() != null) {
			if (event.getClickedBlock().getType() == Material.FLETCHING_TABLE && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				event.setCancelled(true);
			}
		}
		
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void onEnchantmentTableInteract(PlayerInteractEvent event) {
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getPlayer() != null) {
			if (event.getClickedBlock().getType() == Material.FLETCHING_TABLE && event.getAction() == Action.RIGHT_CLICK_BLOCK) {

				//creates new inventory menu
				//note: chest inventory MUST be a multiple of 9 and less than or equal to 54
				Inventory inv = plugin.getServer().createInventory(null, 45, ChatColor.DARK_GREEN + "Fletching");
				
				//moved item creation to core
				ArrayList<ItemStack> menuItems = PluginCore.getBlacklistedItems();
				
				//place blanks in inventory
				for (int x = 0; x < 45 ; x++) {
					inv.setItem(x, menuItems.get(0));
				}
				
				//place fletching button
				inv.setItem(19, menuItems.get(13));
				
				//place arrow slots
				inv.setItem(12, menuItems.get(14));
				inv.setItem(14, menuItems.get(14));
				
				inv.setItem(21, menuItems.get(15));
				inv.setItem(23, menuItems.get(15));
				
				inv.setItem(30, menuItems.get(16));
				inv.setItem(32, menuItems.get(16));
				
				//place poison slot
				inv.setItem(25, menuItems.get(17));
				
				//clear slots for items
				inv.clear(13);
				inv.clear(22);
				inv.clear(31);
				
				inv.clear(16);
				
				//opens the custom inventory
				event.getPlayer().openInventory(inv);
			}
		}
		
	}
}
