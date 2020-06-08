package user.nyoon.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.commonmethods.commonMethods;
import user.nyoon.recipes.ArrowRecipes;

public class FletchingTableMenu implements Listener {
	
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null || item == null) {
			return;
		}
		
		if (event.getView().getTitle().equals(ChatColor.DARK_GREEN + "Fletching")) {
			
			if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Craft Arrows")) {
				
				//disallow taking out enchant button
				event.setCancelled(true);
				
				//get items in slots
				ItemStack arrowHead = event.getView().getItem(13);
				ItemStack arrowShaft = event.getView().getItem(22);
				ItemStack arrowFeather = event.getView().getItem(31);
				ItemStack arrowPoison = event.getView().getItem(16);
				
				//return if any core slots are empty
				if (arrowHead == null || arrowShaft == null || arrowFeather == null) {
					return;
				}
				
				//make sure arrowhead is flint type, stick is stick and feather is feather
				if (arrowHead.getType() != Material.FLINT || arrowShaft.getType() != Material.STICK || arrowFeather.getType() != Material.FEATHER) {
					return;
				}
				
				ItemStack result = ArrowRecipes.craftArrow(arrowHead, arrowPoison);
				
				if (result != null) {
					event.getView().getItem(13).setAmount(event.getView().getItem(13).getAmount() - 1);
					event.getView().getItem(22).setAmount(event.getView().getItem(22).getAmount() - 1);
					event.getView().getItem(31).setAmount(event.getView().getItem(31).getAmount() - 1);
					
					if (event.getView().getItem(16) != null) {
						event.getView().getItem(16).setAmount(event.getView().getItem(16).getAmount() - 1);
					}
					
					commonMethods.givePossibleOverflow(result, player);
					
					player.playSound(player.getLocation(), Sound.BLOCK_BAMBOO_HIT, 1, 1);
				} else {
					player.sendMessage(ChatColor.RED + "Invalid Recipe!");
				}
				
			} else if (item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Place Arrow Head Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Place Stick Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Place Feather Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Place Poison Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "[]")) {
				
				//disallow taking out slot items
				event.setCancelled(true);
			}
			
		}
	}
}
