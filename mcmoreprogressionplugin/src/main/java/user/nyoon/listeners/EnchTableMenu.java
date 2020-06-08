package user.nyoon.listeners;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import net.md_5.bungee.api.ChatColor;

public class EnchTableMenu implements Listener {
	
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null || item == null) {
			return;
		}
		
		if (event.getView().getTitle().equals(ChatColor.DARK_GREEN + "Enchanting")) {
			
			if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Enchant")) {
				
				//disallow taking out enchant button
				event.setCancelled(true);
				
				//get book from book slot and check enchants
				ItemStack book = event.getView().getItem(25);
				if (book == null) {
					//checks if theres nothing in book slot and notifies if such
					player.sendMessage(ChatColor.RED + "There's nothing in the book slot.");
					return;
				} else {
					
					//checks if item is enchanted book.
					if (book.getType() != Material.ENCHANTED_BOOK) {
						return;
					}
					
					//get enchants off of enchanted book
					EnchantmentStorageMeta enchantMeta = (EnchantmentStorageMeta) book.getItemMeta();
					
					Map<Enchantment, Integer> enchants = enchantMeta.getStoredEnchants();
					
					//check if an item is in the item slot
					ItemStack itemToEnchant = event.getView().getItem(19);
					if (itemToEnchant == null) {
						return;
					}
					
					boolean success = false;
					for (Enchantment x : enchants.keySet()) {
						//check if enchant is applicable to item and applies if so
						if (x.canEnchantItem(itemToEnchant)) {
							
							//enchants item
							itemToEnchant.addEnchantment(x, enchants.get(x));
							
							success = true;
						}
					}
					
					if (success) {
						//consumes enchanted book
						event.getView().setItem(25, new ItemStack(Material.AIR));
						player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
					} else {
						player.sendMessage(ChatColor.RED + "Enchantment is not applicable to this item!");
					}
					
				}
				
				
			} else if (item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Place Book Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Place Item Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "[]")) {
				
				//disallow taking out slot items
				event.setCancelled(true);
			}
			
		}
	}
}
