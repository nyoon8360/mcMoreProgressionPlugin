package user.nyoon.commonmethods;

import java.util.ArrayList;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
 * collection of command methods to use in multiple different classes
 */

public class commonMethods {
	
	//applies repair and slots lore to item
	public static ItemStack applyBasicStats(ItemStack item, int slots, int repairPen) {
		ItemMeta tempMeta = item.getItemMeta();
		ArrayList<String> tempLore = new ArrayList<>();
		tempLore.add(ChatColor.GOLD + "Upgrades Left: " + slots);
		tempLore.add(ChatColor.GOLD + "Repair Cost Penalty: " + repairPen);
		tempMeta.setLore(tempLore);
		item.setItemMeta(tempMeta);
		
		return item;
	}
	
	//applies repair, slots, and gem slot lore to item
	public static ItemStack applyBasicStatsAndGem(ItemStack item, int slots, int repairPen) {
		ItemMeta tempMeta = item.getItemMeta();
		ArrayList<String> tempLore = new ArrayList<>();
		tempLore.add(ChatColor.GOLD + "Upgrades Left: " + slots);
		tempLore.add(ChatColor.GOLD + "Gem Slot: (empty)");
		tempLore.add(ChatColor.GOLD + "Repair Cost Penalty: " + repairPen);
		tempMeta.setLore(tempLore);
		item.setItemMeta(tempMeta);
		
		return item;
	}
	
	//return items from an inventory with possible inventory overflow and dropping overflowed items onto ground
	public static void returnItems(int[] slots, InventoryCloseEvent event) {
		//arraylist to populate with items to return
		ArrayList<ItemStack> returnItems = new ArrayList<>();
		
		//check if item slots are empty and if not then add item to arraylist
		for (int x : slots) {
			if (event.getView().getItem(x) != null) {
				returnItems.add(event.getView().getItem(x));
			}
		}
		
		//if arraylist is empty then exit method execution
		if (returnItems.isEmpty()) {
			return;
		}
		
		//cast arraylist to array to use in addItem method
		ItemStack[] rItems = new ItemStack[returnItems.size()];
		returnItems.toArray(rItems);
		
		//add items to players inventory and store any leftovers in map
		Map<Integer, ItemStack> map = event.getPlayer().getInventory().addItem(rItems);
		
		//drop items in map onto player's location
		for (ItemStack item : map.values()) {
			event.getPlayer().getWorld().dropItemNaturally(event.getPlayer().getLocation(), item);
		}
	}
	
	//give item to player with possible no space for item and dropping overflowed items onto groundd
	public static void givePossibleOverflow(ItemStack item, Player player) {
		Map<Integer, ItemStack> map = player.getInventory().addItem(item);
		
		if (!map.isEmpty()) {
			for (ItemStack tempItem : map.values()) {
				if (tempItem.getType() != Material.AIR) {
					player.getWorld().dropItemNaturally(player.getLocation(), tempItem);
				}
			}
		}
	}
	
	//command to get ItemStack of error item used only for error testing purposes
	public static ItemStack getErrorItem() {
		ItemStack errorItem = new ItemStack(Material.PAPER);
		ItemMeta errorItemMeta = errorItem.getItemMeta();
		errorItemMeta.setDisplayName("ERROR!!!");
		ArrayList<String> errorItemLore = new ArrayList<String>();
		errorItemLore.add("If you got this then something is very wrong :(");
		errorItemMeta.setLore(errorItemLore);
		errorItem.setItemMeta(errorItemMeta);
		
		return errorItem;
	}
}
