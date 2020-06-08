package user.nyoon.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.commonmethods.commonMethods;
import user.nyoon.plugincore.PluginCore;

public class CloseInventory implements Listener {
	
	@EventHandler
	public void onInvenClose(InventoryCloseEvent event) {
		
		//remove blacklisted items from player inventory tree
		Inventory playerInven = event.getPlayer().getInventory();
		
		for (ItemStack x : PluginCore.getBlacklistedItems()) {
			if (playerInven.contains(x)) {
				playerInven.remove(x);
			}
		}
		
		String invenTitle = event.getView().getTitle();
		
		//return items tree
		if (invenTitle.equals(ChatColor.DARK_GREEN + "Forging")) {
			
			int[] slots = new int[] {21, 24, 38, 39, 40};
			commonMethods.returnItems(slots, event);
		} else if (invenTitle.equals(ChatColor.DARK_GREEN + "Fletching")) {
			
			int[] slots = new int[] {13, 22, 31, 16};
			commonMethods.returnItems(slots, event);
		} else if (invenTitle.equals(ChatColor.DARK_GREEN + "Sharpening and Polishing")) {
			
			int[] slots = new int[] {20, 24};
			commonMethods.returnItems(slots, event);
		} else if (invenTitle.equals(ChatColor.DARK_GREEN + "Repairing")) {
			
			int[] slots = new int[] {11, 15};
			commonMethods.returnItems(slots, event);
		} else if (invenTitle.equals(ChatColor.DARK_GREEN + "Upgrade Crafting")) {
			
			int[] slots = new int[] {20, 15, 24, 33, 42};
			commonMethods.returnItems(slots, event);
		} else if (invenTitle.equals(ChatColor.DARK_GREEN + "Enchanting")) {
			
			int[] slots = new int[] {25, 19};
			commonMethods.returnItems(slots, event);
		}
	}
	
}
