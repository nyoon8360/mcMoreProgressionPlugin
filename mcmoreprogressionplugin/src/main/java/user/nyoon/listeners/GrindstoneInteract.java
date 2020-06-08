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

public class GrindstoneInteract implements Listener {
	private Plugin plugin = PluginCore.getPlugin(PluginCore.class);
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void cancelEnchantTableInteract(PlayerInteractEvent event) {
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getPlayer() != null) {
			if (event.getClickedBlock().getType() == Material.GRINDSTONE && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
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
			if (event.getClickedBlock().getType() == Material.GRINDSTONE && event.getAction() == Action.RIGHT_CLICK_BLOCK) {

				//creates new inventory menu
				//note: chest inventory MUST be a multiple of 9 and less than or equal to 54
				Inventory inv = plugin.getServer().createInventory(null, 45, ChatColor.DARK_GREEN + "Sharpening and Polishing");
				
				//moved item creation to core
				ArrayList<ItemStack> menuItems = PluginCore.getBlacklistedItems();
				
				//place blanks in inventory
				for (int x = 0; x < 45 ; x++) {
					inv.setItem(x, menuItems.get(0));
				}
				
				//place equipment
				inv.setItem(11, menuItems.get(7));
				inv.setItem(29, menuItems.get(7));
				inv.setItem(21, menuItems.get(7));
				inv.setItem(19, menuItems.get(7));
				
				//place whetstone/polish
				inv.setItem(15, menuItems.get(8));
				inv.setItem(33, menuItems.get(8));
				inv.setItem(25, menuItems.get(8));
				inv.setItem(23, menuItems.get(8));
				
				//place apply button
				inv.setItem(31, menuItems.get(9));
				
				//empty slots for items
				inv.clear(20);
				inv.clear(24);
				
				//opens the custom inventory
				event.getPlayer().openInventory(inv);
			}
		}
		
	}
}
