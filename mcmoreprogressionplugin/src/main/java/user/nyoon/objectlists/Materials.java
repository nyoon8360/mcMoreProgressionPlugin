package user.nyoon.objectlists;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Materials {

	public static ArrayList<ItemStack> popMaterials() {
		
		ArrayList<ItemStack> returnList = new ArrayList<>();
		/*
		
		Sharp Arrowhead: 0
		Very Sharp Arrowhead: 1
		Extremely Sharp Arrowhead: 2
		Slow Poison: 3
		Stun Poison: 4
		Weakness Poison: 5
		Decay Poison: 6
		Cleansing Stone: 7
		
		 */
		
		
		// Sharp arrowhead
		ItemStack arrowHead1 = new ItemStack(Material.FLINT);
		ItemMeta arrowHead1Meta = arrowHead1.getItemMeta();
		arrowHead1Meta.setDisplayName("Sharp Arrowhead");
		arrowHead1Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		arrowHead1Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		arrowHead1.setItemMeta(arrowHead1Meta);
		returnList.add(arrowHead1);

		// Very sharp arrowhead
		ItemStack arrowHead2 = new ItemStack(Material.FLINT);
		ItemMeta arrowHead2Meta = arrowHead2.getItemMeta();
		arrowHead2Meta.setDisplayName("Very Sharp Arrowhead");
		arrowHead2Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		arrowHead2Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		arrowHead2.setItemMeta(arrowHead2Meta);
		returnList.add(arrowHead2);

		// Extremely sharp arrowhead
		ItemStack arrowHead3 = new ItemStack(Material.FLINT);
		ItemMeta arrowHead3Meta = arrowHead1.getItemMeta();
		arrowHead3Meta.setDisplayName("Extremely Sharp Arrowhead");
		arrowHead3Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		arrowHead3Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		arrowHead3.setItemMeta(arrowHead3Meta);
		returnList.add(arrowHead3);
		
		// slow poison
		ItemStack slowPoisonI = new ItemStack(Material.SUSPICIOUS_STEW);
		SuspiciousStewMeta slowPoisonIMeta = (SuspiciousStewMeta) slowPoisonI.getItemMeta();
		slowPoisonIMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1), true);
		slowPoisonIMeta.setDisplayName("Slow Poison I");
		slowPoisonIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		slowPoisonIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		slowPoisonI.setItemMeta(slowPoisonIMeta);
		returnList.add(slowPoisonI);

		// stun poison
		ItemStack stunPoison = new ItemStack(Material.SUSPICIOUS_STEW);
		SuspiciousStewMeta stunPoisonMeta = (SuspiciousStewMeta) stunPoison.getItemMeta();
		stunPoisonMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1), true);
		stunPoisonMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 1), true);
		stunPoisonMeta.setDisplayName("Stun Poison I");
		stunPoisonMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		stunPoisonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		stunPoison.setItemMeta(stunPoisonMeta);
		returnList.add(stunPoison);

		// weakness poison
		ItemStack weakPoisonI = new ItemStack(Material.SUSPICIOUS_STEW);
		SuspiciousStewMeta weakPoisonIMeta = (SuspiciousStewMeta) weakPoisonI.getItemMeta();
		weakPoisonIMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1), true);
		weakPoisonIMeta.setDisplayName("Weakness Poison I");
		weakPoisonIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		weakPoisonIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		weakPoisonI.setItemMeta(weakPoisonIMeta);
		returnList.add(weakPoisonI);

		// decay poison (poison)
		ItemStack decayPoison = new ItemStack(Material.SUSPICIOUS_STEW);
		SuspiciousStewMeta decayPoisonMeta = (SuspiciousStewMeta) decayPoison.getItemMeta();
		decayPoisonMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1), true);
		decayPoisonMeta.setDisplayName("Decay Poison I");
		decayPoisonMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		decayPoisonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		decayPoison.setItemMeta(decayPoisonMeta);
		returnList.add(decayPoison);

		// Cleansing Stone
		ItemStack cleansingStone = new ItemStack(Material.NETHER_STAR);
		ItemMeta cleansingStoneMeta = cleansingStone.getItemMeta();
		cleansingStoneMeta.setDisplayName("Cleansing Stone");
		cleansingStoneMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		cleansingStoneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> cleansingStoneLore = new ArrayList<>();
		cleansingStoneLore.add("Add this to a piece of non-custom equipment in a");
		cleansingStoneLore.add("grindstone to cleanse it of upgrades.");
		cleansingStone.setItemMeta(cleansingStoneMeta);
		returnList.add(cleansingStone);
		
		return returnList;
	}
	
}
