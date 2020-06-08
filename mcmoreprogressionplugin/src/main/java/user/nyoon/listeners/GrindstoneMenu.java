package user.nyoon.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.commonmethods.commonMethods;
import user.nyoon.plugincore.PluginCore;

public class GrindstoneMenu implements Listener {
	
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null || item == null) {
			return;
		}
		
		if (event.getView().getTitle().equals(ChatColor.DARK_GREEN + "Sharpening and Polishing")) {
			
			if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Apply")) {
				
				//disallow taking out apply
				event.setCancelled(true);
				
				//get items in slots
				ItemStack equipment = event.getView().getItem(20);
				ItemStack upgrade = event.getView().getItem(24);
				
				//check if either slot is empty
				if (equipment == null || upgrade == null) {
					return;
				}
				
				//variables to hold data
				int upgradesLeft = 0;
				String upgradeType;
				int upgradeAmount;
				
				//check if equipment is upgradeable
				if (equipment.getItemMeta().hasLore()) {
					for (String x : equipment.getItemMeta().getLore()) {
						if (x.contains("Upgrades Left")) {
							upgradesLeft = Integer.parseInt(x.substring(x.indexOf(':') + 2));
						}
					}
				} else {
					player.sendMessage(ChatColor.RED + "Equipment is not upgradeable!");
					return;
				}
				
				//check if upgrade item has custom name
				if (!upgrade.getItemMeta().hasDisplayName()) {
					player.sendMessage(ChatColor.RED + "Invalid upgrade item!");
					return;
				}
				
				//check if cleanse stone
				if (upgrade.getItemMeta().getDisplayName().equals("Cleansing Stone")) {
					if (equipment.getItemMeta().hasDisplayName()) {
						player.sendMessage("This item can't be cleansed!");
						return;
					}
					ItemStack newItem = applyCleanse(equipment, player);
					
					if (newItem != null) {
						commonMethods.applyBasicStats(newItem, 3, 1);
						event.getView().setItem(20, newItem);
						event.getView().setItem(24, new ItemStack(Material.AIR));
						player.playSound(player.getLocation(), Sound.BLOCK_END_PORTAL_FRAME_FILL, 1, 1);
						player.sendMessage(ChatColor.GREEN + "Item Cleansed.");
					}
					
					return;
				}
				
				//check if any upgrades left
				if (upgradesLeft == 0) {
					player.sendMessage(ChatColor.RED + "No upgrades left!");
					return;
				}
				
				
				//check if upgrade item is a polish/whetstone
				if (!upgrade.getItemMeta().getDisplayName().contains("Polish") && !upgrade.getItemMeta().getDisplayName().contains("Whetstone")) {
					player.sendMessage(ChatColor.RED + "Invalid upgrade item!");
					return;
				}
				
				//get upgrade type
				upgradeType = upgrade.getItemMeta().getLore().get(0).substring(0, upgrade.getItemMeta().getLore().get(0).indexOf(' '));
				//get upgrade amount
				upgradeAmount = Integer.parseInt(upgrade.getItemMeta().getLore().get(0).substring(upgrade.getItemMeta().getLore().get(0).indexOf('+') + 1));
				
				//boolean to track success or failure of application of upgrades
				boolean success = false;
				
				//TODO can be rewritten for efficiency
				//apply upgrades
				if (equipment.getType().toString().contains("HELMET")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "head", player, upgradesLeft);
				} else if (equipment.getType().toString().contains("CHESTPLATE")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "chest", player, upgradesLeft);
				} else if (equipment.getType().toString().contains("LEGGINGS")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "legs", player, upgradesLeft);
				} else if (equipment.getType().toString().contains("BOOTS")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "feet", player, upgradesLeft);
				} else if (equipment.getType().toString().contains("SWORD")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "mainhand", player, upgradesLeft);
				} else if (equipment.getType().toString().contains("AXE")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "mainhand", player, upgradesLeft);
				} else if (equipment.getType().toString().contains("PICKAXE")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "mainhand", player, upgradesLeft);
				} else if (equipment.getType().toString().contains("SHOVEL")) {
					success = GrindstoneMenu.applyUpgrade(equipment, upgrade, upgradeType, upgradeAmount, "mainhand", player, upgradesLeft);
				}
				
				if (success) {
					if (event.getView().getItem(24).getAmount() == 1) {
						event.getView().setItem(24, new ItemStack(Material.AIR));
					} else {
						event.getView().getItem(24).setAmount(event.getView().getItem(24).getAmount() - 1);
					}
					
					player.playSound(player.getLocation(), Sound.BLOCK_END_PORTAL_FRAME_FILL, 1, 1);
				}
				
			} else if (item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Place Equipment Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Place Whetstone/Polish Here") ||
					item.getItemMeta().getDisplayName().equals(ChatColor.BLACK + "[]")) {
				
				//disallow taking out slot items
				event.setCancelled(true);
			}
			
		}
	}
	
	public static boolean applyUpgrade(ItemStack equipment, ItemStack upgrade, String upgradeType, int upgradeAmount, String slot, Player player, int upgradesLeft) {
		if (upgrade.getItemMeta().getDisplayName().contains("Polish")) {
			
			if (!slot.equals("head") && !slot.equals("chest") && !slot.equals("legs") && !slot.equals("feet")) {
				player.sendMessage("Upgrade and Equipment mismatch!");
				return false;
			}
			
			if (upgradeType.equals("MaxHP")) {
				
				AttributeModifier tempMod;
				
				switch(slot) {
				
				case "head":
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
					break;
					
				case "chest":
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
					break;
					
				case "legs":
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
					break;
					
				case "feet":
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
					break;
					
				default:
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
					break;
				}
				
				ItemMeta tempItemMeta = equipment.getItemMeta();
				tempItemMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, tempMod);
				
				//update remaining upgrades
				ArrayList<String> newLore = (ArrayList<String>) equipment.getItemMeta().getLore();
				
				String s = ChatColor.GOLD + "Upgrades Left: " + (upgradesLeft - 1);
				
				player.sendMessage(s);
				
				for (String x : newLore) {
					if (x.contains("Upgrades Left")) {
						newLore.set(newLore.indexOf(x), s);
					}
				}
				
				tempItemMeta.setLore(newLore);
				
				equipment.setItemMeta(tempItemMeta);
				
				return true;
			} else if (upgradeType.equals("Toughness")) {
				
				AttributeModifier tempMod;
				
				if (slot.equals("head")) {
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
				} else if (slot.equals("chest")) {
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
				} else if (slot.equals("legs")) {
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
				} else if (slot.equals("feet")) {
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
				} else {
					tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
				}
					
				ItemMeta tempItemMeta = equipment.getItemMeta();
				tempItemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, tempMod);
				
				//update remaining upgrades
				ArrayList<String> newLore = (ArrayList<String>) equipment.getItemMeta().getLore();
				
				String s = ChatColor.GOLD + "Upgrades Left: " + (upgradesLeft - 1);
				
				player.sendMessage(s);
				
				for (String x : newLore) {
					if (x.contains("Upgrades Left")) {
						newLore.set(newLore.indexOf(x), s);
					}
				}
				
				tempItemMeta.setLore(newLore);
				
				equipment.setItemMeta(tempItemMeta);
				
				return true;
			}
		} else if (upgrade.getItemMeta().getDisplayName().contains("Whetstone")) {
			
			if (!slot.equals("mainhand")) {
				player.sendMessage("Upgrade and Equipment mismatch!");
				return false;
			}
			
			if (upgradeType.equals("AttackSpeed%")) {
				AttributeModifier tempMod;
				
				tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount * .01, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
					
				ItemMeta tempItemMeta = equipment.getItemMeta();
				tempItemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, tempMod);
				
				//update remaining upgrades
				ArrayList<String> newLore = (ArrayList<String>) equipment.getItemMeta().getLore();
				
				String s = ChatColor.GOLD + "Upgrades Left: " + (upgradesLeft - 1);
				
				player.sendMessage(s);
				
				for (String x : newLore) {
					if (x.contains("Upgrades Left")) {
						newLore.set(newLore.indexOf(x), s);
					}
				}
				
				tempItemMeta.setLore(newLore);
				
				equipment.setItemMeta(tempItemMeta);
				
				return true;
			} else if (upgradeType.equals("AttackDamage")) {
				AttributeModifier tempMod;
				
				tempMod = new AttributeModifier(UUID.randomUUID(), "test", upgradeAmount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
				
				ItemMeta tempItemMeta = equipment.getItemMeta();
				tempItemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, tempMod);
				
				//update remaining upgrades
				ArrayList<String> newLore = (ArrayList<String>) equipment.getItemMeta().getLore();
				
				String s = ChatColor.GOLD + "Upgrades Left: " + (upgradesLeft - 1);
				
				player.sendMessage(s);
				
				for (String x : newLore) {
					if (x.contains("Upgrades Left")) {
						newLore.set(newLore.indexOf(x), s);
					}
				}
				
				tempItemMeta.setLore(newLore);
				
				equipment.setItemMeta(tempItemMeta);
				
				return true;
			}
		}
		return false;
	}
	
	public ItemStack applyCleanse(ItemStack equipment, Player player) {
		int damage = 0;
		Map<Enchantment, Integer> equipEnchants = new HashMap<>();
		
		if (equipment instanceof Damageable) {
			damage = ((Damageable) equipment.getItemMeta()).getDamage();
		}
		
		//check if item is damaged
		if (damage != 0) {
			player.sendMessage("Equipment must have 100% durability to cleanse!");
			return null;
		}
		
		//check for and save enchants
		if (equipment.getItemMeta().hasEnchants()) {
			equipEnchants = equipment.getItemMeta().getEnchants();
		}
		
		//check if item is an upgradeable item through lore check. may need to rework later
		if (!equipment.getItemMeta().hasLore()) {
			player.sendMessage("This item can't be cleansed!");
			return null;
		}
		
		//get returnItem from upgradeables map based on what material the equipment is
		ItemStack returnItem = PluginCore.getUpgradeables().get(equipment.getType());
		
		//check if we got a match from the hashmap and if so apply the cleanse.
		if (returnItem != null) {
			//apply all enchants that were on the initial equipment.
			ItemMeta returnItemMeta = returnItem.getItemMeta();
			if (!equipEnchants.isEmpty()) {
				for (Enchantment x : equipEnchants.keySet()) {
					returnItemMeta.addEnchant(x, equipEnchants.get(x), true);
				}
			}
			returnItem.setItemMeta(returnItemMeta);
			//return the newly cleansed item
			return returnItem;
		} else {
			player.sendMessage(ChatColor.RED + "This item can't be cleansed!");
			return null;
		}
	}
}
