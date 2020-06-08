package user.nyoon.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class SmithingTableMenu implements Listener {
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null || item == null) {
			return;
		}
		
		if (event.getView().getTitle().equals(ChatColor.DARK_GREEN + "Repairing")) {
			
			if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Repair")) {
				
				//disallow taking out repair button
				event.setCancelled(true);
				
				//item in repair slot
				ItemStack toRepair = event.getView().getItem(11);
				//material in material slot
				ItemStack material = event.getView().getItem(15);
				//material needed to repair item
				Material neededMat = null;
				//amount of materials needed
				int neededMatAmount = 100;
				
				//check if either slot is empty
				if (toRepair == null || material == null) {
					player.sendMessage(ChatColor.RED + "You need an item to repair and material to repair it!");
					return;
				}
				
				//check if tool or armor check1
				if (toRepair.getType().toString().contains("_")) {
					
					int indexOf_ = toRepair.getType().toString().indexOf('_');
					String stringMat = toRepair.getType().toString().substring(0, indexOf_);
					
					//check what material is needed to repair
					if (stringMat.equals("IRON") || stringMat.equals("CHAINMAIL")) {
						neededMat = Material.IRON_INGOT;
					} else if (stringMat.equals("GOLDEN")) {
						neededMat = Material.GOLD_INGOT;
					} else if (stringMat.equals("DIAMOND")) {
						neededMat = Material.DIAMOND;
					} else if (stringMat.equals("LEATHER")) {
						neededMat = Material.LEATHER;
					} else {
						//return if item is not armor/tool final check
						player.sendMessage(ChatColor.RED + "You can't repair this item!");
						return;
					}
					
					//check equipment type and set base cost
					if (toRepair.getType().toString().contains("HELMET")) {
						neededMatAmount = 4;
					} else if (toRepair.getType().toString().contains("CHESTPLATE")) {
						neededMatAmount = 7;
					} else if (toRepair.getType().toString().contains("LEGGINGS")) {
						neededMatAmount = 6;
					} else if (toRepair.getType().toString().contains("BOOTS")) {
						neededMatAmount = 3;
					} else if (toRepair.getType().toString().contains("SWORD")) {
						neededMatAmount = 2;
					} else if (toRepair.getType().toString().contains("PICKAXE")) {
						neededMatAmount = 2;
					} else if (toRepair.getType().toString().contains("AXE")) {
						neededMatAmount = 2;
					} else if (toRepair.getType().toString().contains("SHOVEL")) {
						neededMatAmount = 1;
					} else if (toRepair.getType().toString().contains("HOE")) {
						neededMatAmount = 1;
					}
					

				} else if (toRepair.getType().equals(Material.BOW)) {
					//if bow then set material and base cost
					neededMat = Material.STRING;
					neededMatAmount = 6;
				} else if (toRepair.getType().equals(Material.CROSSBOW)) {
					//if crossbow then set material and base cost
					neededMat = Material.IRON_INGOT;
					neededMatAmount = 2;
				} else if (toRepair.getType().equals(Material.SHIELD)) {
					//if shield then set material and base cost
					neededMat = Material.IRON_INGOT;
					neededMatAmount = 2;
				}  else if (toRepair.getType().equals(Material.FISHING_ROD)) {
					//if fishing rod then set material and base cost
					neededMat = Material.STRING;
					neededMatAmount = 4;
				}   else {
					//if item is not equipment then return;
					return;
				}
				
				if (toRepair.getItemMeta().hasLore()) {
					//calculate total cost
					for (String x : toRepair.getItemMeta().getLore()) {
						if (x.contains("Repair Cost")) {
							neededMatAmount += Integer.parseInt(x.substring(23));
						}
					}
				}
				
				//check if correct material and amount is in slot and if so fix equipment
				if (material.getType().equals(neededMat)) {
					if (material.getAmount() > neededMatAmount) {
						//if more than required material in material slot, decrement it
						ItemMeta temp = toRepair.getItemMeta();
						Damageable tempD = (Damageable) temp;
						if (tempD.hasDamage()) {
							tempD.setDamage(0);
							toRepair.setItemMeta(temp);
							player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
						} else {
							player.sendMessage(ChatColor.RED + "This equipment has no damage to fix.");
							return;
						}
						
						material.setAmount(material.getAmount() - neededMatAmount);
					} else if (material.getAmount() == neededMatAmount) {
						//if exact amount of material required in material slot, delete it
						ItemMeta temp = toRepair.getItemMeta();
						Damageable tempD = (Damageable) temp;
						if (tempD.hasDamage()) {
							tempD.setDamage(0);
							toRepair.setItemMeta(temp);
							player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
						} else {
							player.sendMessage(ChatColor.RED + "This equipment has no damage to fix.");
							return;
						}
						
						event.getView().setItem(15, new ItemStack(Material.AIR));
					} else {
						//if not enough materials notify player
						player.sendMessage(ChatColor.RED + "Need more materials for this repair!");
						return;
					}
				} else {
					//if incorrect material notify player
					player.sendMessage(ChatColor.RED + "Incorrect material for this repair!");
					return;
				}
				

				
			} else if (item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Place Equipment Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Place Materials Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "[]")) {
				
				//disallow taking out slot items
				event.setCancelled(true);
			}
			
		}
	}
}
