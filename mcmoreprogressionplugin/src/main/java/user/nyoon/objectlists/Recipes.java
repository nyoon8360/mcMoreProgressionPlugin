package user.nyoon.objectlists;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Recipes {

	public static ArrayList<ItemStack> popRecipes() {
		
		ArrayList<ItemStack> returnList = new ArrayList<ItemStack>();
		
		/*
		
		Saddle Recipe: 0
		Shield Recipe: 1
		Boots of the Fragile Traveler Recipe: 2
		
		
		 */
		
		//Saddle Recipe
		ItemStack recipe2 = new ItemStack(Material.PAPER);
		ItemMeta recipe2Meta = recipe2.getItemMeta();
		recipe2Meta.setDisplayName("Saddle Recipe");
		ArrayList<String> recipe2Lore = new ArrayList<>();
		recipe2Lore.add("Base: 15 Leather");
		recipe2Lore.add("Addon1: 10 String");
		recipe2Lore.add("Addon2: 2 Iron Ingot");
		recipe2Meta.setLore(recipe2Lore);
		recipe2Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		recipe2Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipe2.setItemMeta(recipe2Meta);
		returnList.add(recipe2);
		
		//Shield Recipe
		ItemStack recipe3 = new ItemStack(Material.PAPER);
		ItemMeta recipe3Meta = recipe3.getItemMeta();
		recipe3Meta.setDisplayName("Shield Recipe");
		ArrayList<String> recipe3Lore = new ArrayList<>();
		recipe3Lore.add("Base: 4 Iron Ingots");
		recipe3Lore.add("Addon1: 16 Sticks");
		recipe3Meta.setLore(recipe3Lore);
		recipe3Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		recipe3Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipe3.setItemMeta(recipe3Meta);
		returnList.add(recipe3);
		
		//Boots of the Fragile Traveler (recipe)
		ItemStack recipe1 = new ItemStack(Material.PAPER);
		ItemMeta recipe1Meta = recipe1.getItemMeta();
		recipe1Meta.setDisplayName("Boots of the Fragile Traveler Recipe");
		ArrayList<String> recipe1Lore = new ArrayList<>();
		recipe1Lore.add("Base: 10 Leather");
		recipe1Lore.add("Addon1: 2 Feathers");
		recipe1Lore.add("Addon2: 4 String");
		recipe1Meta.setLore(recipe1Lore);
		recipe1Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		recipe1Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipe1.setItemMeta(recipe1Meta);
		returnList.add(recipe1);
		
		//Shield +1 Recipe
		ItemStack recipe4 = new ItemStack(Material.PAPER);
		ItemMeta recipe4Meta = recipe4.getItemMeta();
		recipe4Meta.setDisplayName("Shield +1 Recipe");
		ArrayList<String> recipe4Lore = new ArrayList<>();
		recipe4Lore.add("Base: 20 Iron Ingots");
		recipe4Lore.add("Addon1: 40 Sticks");
		recipe4Meta.setLore(recipe4Lore);
		recipe4Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		recipe4Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipe4.setItemMeta(recipe4Meta);
		returnList.add(recipe4);
		
		//Shield +2 Recipe
		ItemStack recipe5 = new ItemStack(Material.PAPER);
		ItemMeta recipe5Meta = recipe5.getItemMeta();
		recipe5Meta.setDisplayName("Shield +2 Recipe");
		ArrayList<String> recipe5Lore = new ArrayList<>();
		recipe5Lore.add("Base: 50 Iron Ingots");
		recipe5Lore.add("Addon1: 64 Sticks");
		recipe5Meta.setLore(recipe5Lore);
		recipe5Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		recipe5Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipe5.setItemMeta(recipe5Meta);
		returnList.add(recipe5);
		
		//Shield +3 Recipe
		ItemStack recipe6 = new ItemStack(Material.PAPER);
		ItemMeta recipe6Meta = recipe6.getItemMeta();
		recipe6Meta.setDisplayName("Shield +3 Recipe");
		ArrayList<String> recipe6Lore = new ArrayList<>();
		recipe6Lore.add("Base: 64 Iron Ingots");
		recipe6Lore.add("Addon1: 64 Sticks");
		recipe6Lore.add("Addon2: 2 Diamonds");
		recipe6Meta.setLore(recipe6Lore);
		recipe6Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		recipe6Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipe6.setItemMeta(recipe6Meta);
		returnList.add(recipe6);
		
		//Woodcutter's Axe Recipe
		ItemStack recipe7 = new ItemStack(Material.PAPER);
		ItemMeta recipe7Meta = recipe7.getItemMeta();
		recipe7Meta.setDisplayName("Woodcutter's Axe Recipe");
		ArrayList<String> recipe7Lore = new ArrayList<>();
		recipe7Lore.add("Base: 10 Gold Ingots");
		recipe7Lore.add("Addon1: 6 Sticks");
		recipe7Lore.add("Addon2: 6 String");
		recipe7Meta.setLore(recipe7Lore);
		recipe7Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		recipe7Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipe7.setItemMeta(recipe7Meta);
		returnList.add(recipe7);
		
		return returnList;
	}
	
}
