package user.nyoon.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.commonmethods.commonMethods;

public class CustomForgingRecipes {

	public static HashMap<String, ItemStack> popCustomForgingRecipes() {
		/* template:
		ItemStack result = new ItemStack(Material.itemType);
		ItemMeta resultMeta = result.getItemMeta();
		--manipulate item meta here
		result.setItemMeta(resultMeta);
		PluginCore.customRecipes.put("recipe in string format", ItemStack result);
		*/
		
		//Hashmap to return
		HashMap<String, ItemStack> returnMap = new HashMap<>();
		
		//Boots of the Fragile Traveler ===================================================================================================
		ItemStack custom1 = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta custom1Meta = custom1.getItemMeta();
		
		//configure meta
		custom1Meta.setDisplayName(ChatColor.GRAY + "Boots of the Fragile Traveler");
		ArrayList<String> custom1Lore = new ArrayList<>();
		custom1Lore.add("These boots seem to almost make you glide as you run.");
		custom1Lore.add("Unfortunately, they seem extremely fragile as well.");
		custom1Lore.add(ChatColor.GOLD + "Upgrades Left: 0");
		custom1Lore.add(ChatColor.GOLD + "Repair Cost Penalty: 100");
		custom1Meta.setLore(custom1Lore);
		AttributeModifier custom1AttributeMod = new AttributeModifier(UUID.randomUUID(), "hpDown", -4, 
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
		custom1Meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, custom1AttributeMod);
		AttributeModifier custom1AttributeMod2 = new AttributeModifier(UUID.randomUUID(), "hpDown", .5,
				AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
		custom1Meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, custom1AttributeMod2);
		
		//set durability
		Damageable custom1MetaD = (Damageable) custom1Meta;
		custom1MetaD.setDamage(45);
		
		//apply item meta
		custom1.setItemMeta(custom1Meta);
		
		//add item to recipes list
		returnMap.put("Boots of the Fragile Traveler Recipe LEATHER 10 FEATHER 2 STRING 4", custom1);
		
		//Regular Saddle====================================================================================================================
		ItemStack custom2 = new ItemStack(Material.SADDLE);
		
		//add item to recipes list
		returnMap.put("Saddle Recipe LEATHER 15 STRING 10 IRON_INGOT 2", custom2);
		
		//Regular Shield====================================================================================================================
		ItemStack custom3 = new ItemStack(Material.SHIELD);
		commonMethods.applyBasicStats(custom3, 0, 1);
		//add item to recipes list
		returnMap.put("Shield Recipe IRON_INGOT 4 STICK 16", custom3);
		
		//Shield +1 ========================================================================================================================
		ItemStack custom4 = new ItemStack(Material.SHIELD);
		ItemMeta custom4Meta = custom4.getItemMeta();
		custom4Meta.addEnchant(Enchantment.DURABILITY, 3, true);
		AttributeModifier custom4Mod = new AttributeModifier(UUID.randomUUID(), "toughup", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		custom4Meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, custom4Mod);
		custom4Meta.setDisplayName("Shield +1");
		custom4.setItemMeta(custom4Meta);
		commonMethods.applyBasicStats(custom4, 0, 1);
		returnMap.put("Shield +1 Recipe IRON_INGOT 20 STICK 40", custom4);
		
		//Shield +2 ========================================================================================================================
		ItemStack custom5 = new ItemStack(Material.SHIELD);
		ItemMeta custom5Meta = custom5.getItemMeta();
		custom5Meta.addEnchant(Enchantment.DURABILITY, 3, true);
		AttributeModifier custom5Mod = new AttributeModifier(UUID.randomUUID(), "toughup", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		custom5Meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, custom5Mod);
		custom5Meta.setDisplayName("Shield +2");
		custom5.setItemMeta(custom5Meta);
		commonMethods.applyBasicStats(custom5, 0, 1);
		returnMap.put("Shield +2 Recipe IRON_INGOT 50 STICK 64", custom5);
		
		//Shield +3 ========================================================================================================================
		ItemStack custom6 = new ItemStack(Material.SHIELD);
		ItemMeta custom6Meta = custom6.getItemMeta();
		custom6Meta.addEnchant(Enchantment.DURABILITY, 3, true);
		AttributeModifier custom6Mod = new AttributeModifier(UUID.randomUUID(), "toughup", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		custom6Meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, custom6Mod);
		custom6Meta.setDisplayName("Shield +3");
		custom6.setItemMeta(custom6Meta);
		commonMethods.applyBasicStats(custom6, 0, 1);
		returnMap.put("Shield +3 Recipe IRON_INGOT 64 STICK 64 DIAMOND 2", custom6);
		
		//Woodcutter's Axe ===================================================================================================
		ItemStack custom7 = new ItemStack(Material.GOLDEN_AXE);
		ItemMeta custom7Meta = custom7.getItemMeta();
		
		//configure meta
		custom7Meta.setDisplayName(ChatColor.GOLD + "Woodcutter's Axe");
		ArrayList<String> custom7Lore = new ArrayList<>();
		custom7Lore.add("A mysteriously enchanted axe that seems to glide through wood.");
		custom7Lore.add("Unfortunately, a method to repair it is unknown.");
		custom7Lore.add(ChatColor.GOLD + "Upgrades Left: 0");
		custom7Lore.add(ChatColor.GOLD + "Repair Cost Penalty: 100");
		custom7Meta.setLore(custom7Lore);
		
		//add enchants
		custom7Meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
		custom7Meta.addEnchant(Enchantment.DURABILITY, 8, true);
		
		//apply item meta
		custom7.setItemMeta(custom7Meta);
		
		//add item to recipes list
		returnMap.put("Woodcutter's Axe Recipe GOLD_INGOT 10 STICK 6 STRING 6", custom7);
		
		
		//Return hashmap
		return returnMap;
	}
	
}
