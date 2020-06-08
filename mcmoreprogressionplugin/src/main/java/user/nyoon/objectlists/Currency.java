package user.nyoon.objectlists;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Currency {
	
	//Display info for enchanted emeralds
	final static String emeraldDisplayName = ChatColor.GREEN + "Enchanted Emerald";
	@SuppressWarnings("serial")
	final static ArrayList<String> enchantedEmeraldLore = new ArrayList<String>() {
		{
			add("An emerald seemingly enchanted with a strange magic.");
			add("It is highly valued by those who seek to trade for it.");
			add("A stack of 64 seems to combine into a condensed block when commanded.");
		}
	};
	
	//display info for enchanted emerald blocks
	final static String emeraldBlockDisplayName = ChatColor.GREEN + "Enchanted Emerald Block";
	
	@SuppressWarnings("serial")
	final static ArrayList<String> enchantedEmeraldBlockLore = new ArrayList<String>() {
		{
			add("A condensed block of emeralds giving off an overwhelming");
			add("amount of strange magical energy.");
			add("It is extremely highly valued by those who seek to trade for it.");
		}
	};
	
	public static ArrayList<ItemStack> popCurrency() {
		ArrayList<ItemStack> returnList = new ArrayList<>();
		
		//0: Enchanted Emerald
		ItemStack enchantedEmerald = new ItemStack(Material.EMERALD);
		ItemMeta enchantedEmeraldMeta = enchantedEmerald.getItemMeta();
		
		enchantedEmeraldMeta.setDisplayName(emeraldDisplayName);
		enchantedEmeraldMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		enchantedEmeraldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		enchantedEmeraldMeta.setLore(enchantedEmeraldLore);
		
		enchantedEmerald.setItemMeta(enchantedEmeraldMeta);
		
		returnList.add(enchantedEmerald);
		
		//1: Enchanted Emerald Block
		ItemStack enchantedEmeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta enchantedEmeraldBlockMeta = enchantedEmeraldBlock.getItemMeta();
		
		enchantedEmeraldBlockMeta.setDisplayName(emeraldBlockDisplayName);
		enchantedEmeraldBlockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		enchantedEmeraldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		enchantedEmeraldBlockMeta.setLore(enchantedEmeraldBlockLore);
		
		enchantedEmeraldBlock.setItemMeta(enchantedEmeraldBlockMeta);
		
		returnList.add(enchantedEmeraldBlock);
		
		return returnList;
	}
	
	public static ItemStack newCurrencyStack(int amount) {
		ItemStack enchantedEmerald = new ItemStack(Material.EMERALD);
		ItemMeta enchantedEmeraldMeta = enchantedEmerald.getItemMeta();
		
		enchantedEmeraldMeta.setDisplayName(emeraldDisplayName);
		enchantedEmeraldMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		enchantedEmeraldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		enchantedEmeraldMeta.setLore(enchantedEmeraldLore);
		
		enchantedEmerald.setItemMeta(enchantedEmeraldMeta);
		enchantedEmerald.setAmount(amount);
		
		return enchantedEmerald;
	}
	
	public static ItemStack newCurrencyBlockStack(int amount) {
		ItemStack enchantedEmeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta enchantedEmeraldBlockMeta = enchantedEmeraldBlock.getItemMeta();
		
		enchantedEmeraldBlockMeta.setDisplayName(emeraldBlockDisplayName);
		enchantedEmeraldBlockMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		enchantedEmeraldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		enchantedEmeraldBlockMeta.setLore(enchantedEmeraldBlockLore);
		
		enchantedEmeraldBlock.setItemMeta(enchantedEmeraldBlockMeta);
		enchantedEmeraldBlock.setAmount(amount);
		
		return enchantedEmeraldBlock;
	}
}
