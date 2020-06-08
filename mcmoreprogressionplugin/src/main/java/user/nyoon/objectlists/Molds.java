package user.nyoon.objectlists;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Molds {
	public static ArrayList<ItemStack> popMolds() {
		ArrayList<ItemStack> returnList = new ArrayList<>();
		
		//0: Gem Mold
		ItemStack gemMold = new ItemStack(Material.BRICK);
		ItemMeta gemMoldMeta = gemMold.getItemMeta();
		gemMoldMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Gem Mold");
		gemMoldMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		gemMoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> gemMoldLore = new ArrayList<String>();
		gemMoldLore.add("Used to create skill gems.");
		gemMoldMeta.setLore(gemMoldLore);
		gemMold.setItemMeta(gemMoldMeta);
		returnList.add(gemMold);
		
		//1: Whetstone Mold
		ItemStack whetstoneMold = new ItemStack(Material.BRICK);
		ItemMeta whetstoneMoldMeta = whetstoneMold.getItemMeta();
		whetstoneMoldMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Whetstone Mold");
		whetstoneMoldMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		whetstoneMoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> whetstoneMoldLore = new ArrayList<String>();
		whetstoneMoldLore.add("Used to create whetstones.");
		whetstoneMoldMeta.setLore(whetstoneMoldLore);
		whetstoneMold.setItemMeta(whetstoneMoldMeta);
		returnList.add(whetstoneMold);
		
		//2: Polish Mold
		ItemStack polishMold = new ItemStack(Material.BRICK);
		ItemMeta polishMoldMeta = polishMold.getItemMeta();
		polishMoldMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Polish Mold");
		polishMoldMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		polishMoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> polishMoldLore = new ArrayList<String>();
		polishMoldLore.add("Used to create polishes.");
		polishMoldMeta.setLore(polishMoldLore);
		polishMold.setItemMeta(polishMoldMeta);
		returnList.add(polishMold);
		
		return returnList;
	}
}
