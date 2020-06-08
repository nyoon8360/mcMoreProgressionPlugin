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

public class SmithingTableInteract implements Listener {
	private Plugin plugin = PluginCore.getPlugin(PluginCore.class);
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void cancelEnchantTableInteract(PlayerInteractEvent event) {
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getPlayer() != null) {
			if (event.getClickedBlock().getType() == Material.SMITHING_TABLE && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
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
			if (event.getClickedBlock().getType() == Material.SMITHING_TABLE && event.getAction() == Action.RIGHT_CLICK_BLOCK) {

				//creates new inventory menu
				//note: chest inventory MUST be a multiple of 9 and less than or equal to 54
				Inventory inv = plugin.getServer().createInventory(null, 36, ChatColor.DARK_GREEN + "Repairing");
				
				//moved item creation to core
				ArrayList<ItemStack> menuItems = PluginCore.getBlacklistedItems();
				
				//place blanks in inventory
				for (int x = 0; x < 36 ; x++) {
					inv.setItem(x, menuItems.get(0));
				}
				
				//place menu items
				inv.setItem(20, menuItems.get(10));
				inv.setItem(24, menuItems.get(11));
				inv.setItem(22, menuItems.get(12));
				
				//clear spots for items
				inv.clear(11);
				inv.clear(15);
				
				//opens the custom inventory
				event.getPlayer().openInventory(inv);
			}
		}
		
	}
}
