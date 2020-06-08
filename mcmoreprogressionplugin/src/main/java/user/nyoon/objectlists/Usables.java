package user.nyoon.objectlists;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Usables {

	public static ArrayList<ItemStack> popUsables() {
		
		ArrayList<ItemStack> returnList = new ArrayList<>();
		
		/*
		
		stun bomb: 0
		slow bomb: 1
		weaken bomb: 2
		
		 */
		
		//stun bomb
		ItemStack stunBomb = new ItemStack(Material.FIREWORK_STAR);
		ItemMeta stunBombMeta = stunBomb.getItemMeta();
		stunBombMeta.setDisplayName("Stun Bomb");
		stunBombMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		stunBombMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> stunBombLore = new ArrayList<>();
		stunBombLore.add("Use this to stun all mobs and players in a 5 block radius of you for 3 seconds!");
		stunBombLore.add("Only has a 3 block vertical radius.");
		stunBombMeta.setLore(stunBombLore);
		stunBomb.setItemMeta(stunBombMeta);
		returnList.add(stunBomb);
		
		//slow bomb
		ItemStack slowBomb = new ItemStack(Material.FIREWORK_STAR);
		ItemMeta slowBombMeta = slowBomb.getItemMeta();
		slowBombMeta.setDisplayName("Slow Bomb");
		slowBombMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		slowBombMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> slowBombLore = new ArrayList<>();
		slowBombLore.add("Use this to slow all mobs and players in a 5 block radius of you for 5 seconds!");
		slowBombLore.add("Only has a 3 block vertical radius.");
		slowBombMeta.setLore(slowBombLore);
		slowBomb.setItemMeta(slowBombMeta);
		returnList.add(slowBomb);
		
		//weaken bomb
		ItemStack weakenBomb = new ItemStack(Material.FIREWORK_STAR);
		ItemMeta weakenBombMeta = weakenBomb.getItemMeta();
		weakenBombMeta.setDisplayName("Weaken Bomb");
		weakenBombMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		weakenBombMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> weakenBombLore = new ArrayList<>();
		weakenBombLore.add("Use this to weaken all mobs and players in a 5 block radius of you for 5 seconds!");
		weakenBombLore.add("Only has a 3 block vertical radius.");
		weakenBombMeta.setLore(weakenBombLore);
		weakenBomb.setItemMeta(weakenBombMeta);
		returnList.add(weakenBomb);
		
		return returnList;
	}

}
