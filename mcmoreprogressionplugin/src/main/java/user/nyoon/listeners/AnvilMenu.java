package user.nyoon.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import user.nyoon.commonmethods.commonMethods;
import user.nyoon.recipes.AnvilRecipe;

public class AnvilMenu implements Listener {
	
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null || item == null) {
			return;
		}
		
		if (event.getView().getTitle().equals(ChatColor.DARK_GREEN + "Forging")) {
			
			//get items in the slots
			ItemStack base = event.getView().getItem(21);
			ItemStack addon1 = event.getView().getItem(38);
			ItemStack addon2 = event.getView().getItem(39);
			ItemStack addon3 = event.getView().getItem(40);
			ItemStack recipe = event.getView().getItem(24);
			
			ItemStack air = new ItemStack(Material.AIR);
			
			//arraylist containing names of all ui items to restrict from being taken out
			ArrayList<String> uiItems = new ArrayList<>();
			uiItems.add(ChatColor.BLACK + "[]");
			uiItems.add(ChatColor.GRAY + "Base Material");
			uiItems.add(ChatColor.BLUE + "Add-on 1");
			uiItems.add(ChatColor.BLUE + "Add-on 2");
			uiItems.add(ChatColor.BLUE + "Add-on 3");
			
			//code to handle on player clicking forge button
			if (item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Forge Item")) {
				
				//disallow taking out button
				event.setCancelled(true);
				
				//check if recipe is in slot
				if (recipe == null) {
					return;
				}
				
				//check if item in recipe slot is paper
				if (!recipe.getType().equals(Material.PAPER)) {
					return;
				}
				
				if (base == null) {
					return;
				} else if (addon1 == null) {
					ItemStack result = AnvilRecipe.forgeRecipe(recipe, base, base.getAmount());
					if (result != null) {
						event.getView().setItem(21, air);
						event.getView().setItem(24, air);
						commonMethods.givePossibleOverflow(result, player);
						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
					}
				} else if (addon2 == null) {
					ItemStack result = AnvilRecipe.forgeRecipe(recipe, base, base.getAmount(), addon1, addon1.getAmount());
					if (result != null) {
						event.getView().setItem(21, air);
						event.getView().setItem(38, air);
						event.getView().setItem(24, air);
						commonMethods.givePossibleOverflow(result, player);
						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
					}
				} else if (addon3 == null) {
					ItemStack result = AnvilRecipe.forgeRecipe(recipe, base, base.getAmount(), addon1, addon1.getAmount(), addon2, addon2.getAmount());
					if (result != null) {
						event.getView().setItem(21, air);
						event.getView().setItem(38, air);
						event.getView().setItem(39, air);
						event.getView().setItem(24, air);
						commonMethods.givePossibleOverflow(result, player);
						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
					}
				} else {
					ItemStack result = AnvilRecipe.forgeRecipe(recipe, base, base.getAmount(), addon1, addon1.getAmount(), addon2, addon2.getAmount()
							, addon3, addon3.getAmount());
					if (result != null) {
						event.getView().setItem(21, air);
						event.getView().setItem(38, air);
						event.getView().setItem(39, air);
						event.getView().setItem(40, air);
						event.getView().setItem(24, air);
						commonMethods.givePossibleOverflow(result, player);
						player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
					}
				}
				

			//restrict taking out other ui items
			} else if (uiItems.contains(item.getItemMeta().getDisplayName())) {
				event.setCancelled(true);
			}
			
		}
	}
}
