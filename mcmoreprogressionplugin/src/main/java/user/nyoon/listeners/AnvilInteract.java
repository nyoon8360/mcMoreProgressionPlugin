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

public class AnvilInteract implements Listener {
	private Plugin plugin = PluginCore.getPlugin(PluginCore.class);
	
	//prevents normal anvil gui from opening
	@EventHandler(priority = EventPriority.LOWEST)
	public void cancelAnvilInteract(PlayerInteractEvent event) {
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getPlayer() != null) {
			if ((event.getClickedBlock().getType() == Material.ANVIL || event.getClickedBlock().getType() == Material.CHIPPED_ANVIL
					|| event.getClickedBlock().getType() == Material.DAMAGED_ANVIL) && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				event.setCancelled(true);
			}
		}
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void onAnvilInteract(PlayerInteractEvent event) {
		
		if (event.getClickedBlock() == null) {
			return;
		}
		
		if (event.getPlayer() != null) {
			if ((event.getClickedBlock().getType() == Material.ANVIL || event.getClickedBlock().getType() == Material.CHIPPED_ANVIL
					|| event.getClickedBlock().getType() == Material.DAMAGED_ANVIL) && event.getAction() == Action.RIGHT_CLICK_BLOCK) {

				if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ENCHANTED_BOOK)) {
					//creates new inventory menu
					//note: chest inventory MUST be a multiple of 9 and less than or equal to 54
					Inventory inv = plugin.getServer().createInventory(null, 45, ChatColor.DARK_GREEN + "Enchanting");
					
					//moved item creation to core
					ArrayList<ItemStack> menuItems = PluginCore.getBlacklistedItems();
					
					//place blanks in inventory
					for (int x = 0; x < 45 ; x++) {
						inv.setItem(x, menuItems.get(0));
					}
					
					//place item slots in inventory
					inv.setItem(10, menuItems.get(22));
					inv.setItem(18, menuItems.get(22));
					inv.setItem(20, menuItems.get(22));
					inv.setItem(10, menuItems.get(22));
					inv.setItem(28, menuItems.get(22));
					
					//place book slots in inventory
					inv.setItem(16, menuItems.get(23));
					inv.setItem(24, menuItems.get(23));
					inv.setItem(26, menuItems.get(23));
					inv.setItem(34, menuItems.get(23));
					
					//place empty slots for actual items to be placed in
					inv.clear(19);
					inv.clear(25);
					
					//place enchant button
					inv.setItem(31, menuItems.get(24));
					
					//opens the custom inventory
					event.getPlayer().openInventory(inv);
				} else {
					//creates new inventory menu
					//note: chest inventory MUST be a multiple of 9 and less than or equal to 54
					Inventory inv = plugin.getServer().createInventory(null, 54, ChatColor.DARK_GREEN + "Forging");
					
					
					//item creation moved to core
					ArrayList<ItemStack> menuItems = PluginCore.getBlacklistedItems();
					
					//create gui using itemstacks
					for (int x = 0; x < 54; x++) {
						inv.setItem(x, menuItems.get(0));
					}
					
					inv.setItem(12, menuItems.get(1)); // base material marker
					inv.setItem(15, menuItems.get(5)); // recipe marker
					
					inv.setItem(29, menuItems.get(2)); // addon 1 marker
					inv.setItem(30, menuItems.get(3)); // addon 2 marker
					inv.setItem(31, menuItems.get(4)); // addon 3 marker
					
					inv.setItem(42, menuItems.get(6)); // forge button
					
					inv.clear(21);
					inv.clear(24);
					inv.clear(38);
					inv.clear(39);
					inv.clear(40);
					
					
					//opens the custom inventory
					event.getPlayer().openInventory(inv);
				}
				
				
			}
		}
		
	}
}
