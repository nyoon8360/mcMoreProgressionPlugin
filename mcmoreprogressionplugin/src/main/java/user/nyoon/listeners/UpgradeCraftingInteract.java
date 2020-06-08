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

public class UpgradeCraftingInteract implements Listener {
	private Plugin plugin = PluginCore.getPlugin(PluginCore.class);
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void cancelBeaconInteract(PlayerInteractEvent event) {
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getPlayer() != null) {
			if (event.getClickedBlock().getType() == Material.BEACON && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
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
			if (event.getClickedBlock().getType() == Material.BEACON && event.getAction() == Action.RIGHT_CLICK_BLOCK) {

				//creates new inventory menu
				//note: chest inventory MUST be a multiple of 9 and less than or equal to 54
				Inventory inv = plugin.getServer().createInventory(null, 54, ChatColor.DARK_GREEN + "Upgrade Crafting");
				
				//moved item creation to core
				ArrayList<ItemStack> menuItems = PluginCore.getBlacklistedItems();
				
				//place blanks in inventory
				for (int x = 0; x < 54 ; x++) {
					inv.setItem(x, menuItems.get(0));
				}
				
				//place mold
				inv.setItem(11, menuItems.get(21));
				inv.setItem(29, menuItems.get(21));
				inv.setItem(21, menuItems.get(21));
				inv.setItem(19, menuItems.get(21));
				
				//place catalyst
				inv.setItem(14, menuItems.get(18));
				inv.setItem(16, menuItems.get(18));
				
				//place materials
				inv.setItem(23, menuItems.get(19));
				inv.setItem(32, menuItems.get(19));
				inv.setItem(41, menuItems.get(19));
				
				inv.setItem(25, menuItems.get(19));
				inv.setItem(34, menuItems.get(19));
				inv.setItem(43, menuItems.get(19));
				
				//craft button
				inv.setItem(37, menuItems.get(20));
				
				//empty slots for items
				inv.clear(20);
				inv.clear(15);
				inv.clear(24);
				inv.clear(33);
				inv.clear(42);
				
				//opens the custom inventory
				event.getPlayer().openInventory(inv);
			}
		}
		
	}
}
