package user.nyoon.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.commonmethods.commonMethods;
import user.nyoon.helperclasses.Upgrader;
import user.nyoon.plugincore.PluginCore;

public class UpgradeCraftingMenu implements Listener {
	
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null || item == null) {
			return;
		}
		
		if (event.getView().getTitle().equals(ChatColor.DARK_GREEN + "Upgrade Crafting")) {
			
			if (item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Craft Upgradeable")) {
				//prevent taking out button
				event.setCancelled(true);
				
				//get mold and catalyst from slots
				ItemStack mold = open.getItem(20);
				ItemStack catalyst = open.getItem(15);
				
				//put materials in material slots in an arraylist
				ArrayList<ItemStack> materials = new ArrayList<>();
				for (int x = 24; x <= 42; x+= 9) {
					if (event.getInventory().getItem(x) != null) {
						materials.add(open.getItem(x));
					}
				}
				
				//makes sure mold and catalyst exists and they have custom names. if not return
				if (mold == null || catalyst == null || !mold.getItemMeta().hasDisplayName() || !catalyst.getItemMeta().hasDisplayName()) {
					player.sendMessage(ChatColor.RED + "Missing a valid mold or catalyst!");
					return;
				}
				
				String ingredientString = mold.getItemMeta().getDisplayName() + catalyst.getItemMeta().getDisplayName();
				
				HashMap<String, Upgrader> recipeList = PluginCore.getUpgraderRecipes();
				Upgrader upgrader = recipeList.get(ingredientString);
				
				if (upgrader == null) {
					
					//DEBUG
					player.sendMessage(ingredientString);
					
					for (String x : recipeList.keySet()) {
						player.sendMessage(x);
					}
					
					player.sendMessage(ChatColor.RED + "Invalid Mold + Catalyst Recipe!");
					return;
				}
				
				//check if enough materials and if so give resulting item
				ArrayList<ItemStack> neededMaterials = upgrader.getMaterials();
				
				if (materials.isEmpty()) {
					player.sendMessage(ChatColor.RED + "Insufficient materials!");
					return;
				}
				
				//loop through all combinations of needed materials and current materials. check if materials are sufficient.
				for (ItemStack x : neededMaterials) {
					
					boolean success = false;
					
					for (ItemStack y : materials) {
						
						if (x.getType().equals(y.getType())) {
							if (y.getAmount() >= x.getAmount()) {
								
								success = true;
								
								break;
							}
						}
					}
					
					if (!success) {
						player.sendMessage(ChatColor.RED + "Insufficient materials!");
						return;
					}
				}
				
				//consume materials and give item
				mold.setAmount(mold.getAmount() - 1);
				catalyst.setAmount(catalyst.getAmount() - 1);
				
				for (ItemStack x : neededMaterials) {
					
					for (ItemStack y : materials) {
						if (x.getType().equals(y.getType())) {
							if (y.getAmount() >= x.getAmount()) {
								y.setAmount(y.getAmount() - x.getAmount());
								
								break;
							}
						}
					}
				}
				
				
				
				//give resulting item and play sound
				player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
				commonMethods.givePossibleOverflow(upgrader.getResult(), player);
				
			} else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Place Catalyst Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Place Materials Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Place Mold Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "[]")) {
				event.setCancelled(true);
			}
		}
	}
}
