package user.nyoon.objectlists;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Polishes {
	
	public static HashMap<String, ArrayList<ItemStack>> popPolishes() {
		HashMap<String, ArrayList<ItemStack>> returnMap = new HashMap<>();
		
		ArrayList<ItemStack> hpList = new ArrayList<>();
		ArrayList<ItemStack> toughList = new ArrayList<>();
		/*
		Health I: 0
		Health II: 1
		Health III: 2
		Health IV: 3
		Health V: 4
		Health VI: 5
		
		Toughness I: 0
		Toughness II: 1
		Toughness III: 2
		Toughness IV: 3
		Toughness V: 4
		Toughness VI: 5
		
		 */
		
		//Polish (health I) +2 health
		ItemStack hpPolishI = new ItemStack(Material.WHITE_DYE);
		ItemMeta hpPolishIMeta = hpPolishI.getItemMeta();
		hpPolishIMeta.setDisplayName("Polish (HP I)");
		hpPolishIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		hpPolishIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> hpPolishILore = new ArrayList<String>();
		hpPolishILore.add("MaxHP +2");
		hpPolishIMeta.setLore(hpPolishILore);
		hpPolishI.setItemMeta(hpPolishIMeta);
		hpList.add(hpPolishI);
		
		//Polish (health II) +4 health
		ItemStack hpPolishII = new ItemStack(Material.WHITE_DYE);
		ItemMeta hpPolishIIMeta = hpPolishII.getItemMeta();
		hpPolishIIMeta.setDisplayName("Polish (HP II)");
		hpPolishIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		hpPolishIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> hpPolishIILore = new ArrayList<String>();
		hpPolishIILore.add("MaxHP +4");
		hpPolishIIMeta.setLore(hpPolishIILore);
		hpPolishII.setItemMeta(hpPolishIIMeta);
		hpList.add(hpPolishII);
		
		//Polish (health III) +6 health
		ItemStack hpPolishIII = new ItemStack(Material.WHITE_DYE);
		ItemMeta hpPolishIIIMeta = hpPolishIII.getItemMeta();
		hpPolishIIIMeta.setDisplayName("Polish (HP III)");
		hpPolishIIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		hpPolishIIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> hpPolishIIILore = new ArrayList<String>();
		hpPolishIIILore.add("MaxHP +6");
		hpPolishIIIMeta.setLore(hpPolishIIILore);
		hpPolishIII.setItemMeta(hpPolishIIIMeta);
		hpList.add(hpPolishIII);
		
		//Polish (health IV) +8 health
		ItemStack hpPolishIV = new ItemStack(Material.WHITE_DYE);
		ItemMeta hpPolishIVMeta = hpPolishIV.getItemMeta();
		hpPolishIVMeta.setDisplayName("Polish (HP IV)");
		hpPolishIVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		hpPolishIVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> hpPolishIVLore = new ArrayList<String>();
		hpPolishIVLore.add("MaxHP +8");
		hpPolishIVMeta.setLore(hpPolishIVLore);
		hpPolishIV.setItemMeta(hpPolishIVMeta);
		hpList.add(hpPolishIV);
		
		//Polish (health V) +10 health
		ItemStack hpPolishV = new ItemStack(Material.WHITE_DYE);
		ItemMeta hpPolishVMeta = hpPolishV.getItemMeta();
		hpPolishVMeta.setDisplayName("Polish (HP V)");
		hpPolishVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		hpPolishVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> hpPolishVLore = new ArrayList<String>();
		hpPolishVLore.add("MaxHP +10");
		hpPolishVMeta.setLore(hpPolishVLore);
		hpPolishV.setItemMeta(hpPolishVMeta);
		hpList.add(hpPolishV);
		
		//Polish (health VI) +12 health
		ItemStack hpPolishVI = new ItemStack(Material.WHITE_DYE);
		ItemMeta hpPolishVIMeta = hpPolishVI.getItemMeta();
		hpPolishVIMeta.setDisplayName("Polish (HP VI)");
		hpPolishVIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		hpPolishVIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> hpPolishVILore = new ArrayList<String>();
		hpPolishVILore.add("MaxHP +12");
		hpPolishVIMeta.setLore(hpPolishVILore);
		hpPolishVI.setItemMeta(hpPolishVIMeta);
		hpList.add(hpPolishVI);
		
		//Polish (toughness I) +1 toughness
		ItemStack toughPolishI = new ItemStack(Material.WHITE_DYE);
		ItemMeta toughPolishIMeta = toughPolishI.getItemMeta();
		toughPolishIMeta.setDisplayName("Polish (TOUGHNESS I)");
		toughPolishIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		toughPolishIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> toughPolishILore = new ArrayList<String>();
		toughPolishILore.add("Toughness +1");
		toughPolishIMeta.setLore(toughPolishILore);
		toughPolishI.setItemMeta(toughPolishIMeta);
		toughList.add(toughPolishI);
		
		//Polish (toughness II) +2 toughness
		ItemStack toughPolishII = new ItemStack(Material.WHITE_DYE);
		ItemMeta toughPolishIIMeta = toughPolishII.getItemMeta();
		toughPolishIIMeta.setDisplayName("Polish (TOUGHNESS II)");
		toughPolishIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		toughPolishIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> toughPolishIILore = new ArrayList<String>();
		toughPolishIILore.add("Toughness +2");
		toughPolishIIMeta.setLore(toughPolishIILore);
		toughPolishII.setItemMeta(toughPolishIIMeta);
		toughList.add(toughPolishII);
		
		//Polish (toughness III) +3 toughness
		ItemStack toughPolishIII = new ItemStack(Material.WHITE_DYE);
		ItemMeta toughPolishIIIMeta = toughPolishIII.getItemMeta();
		toughPolishIIIMeta.setDisplayName("Polish (TOUGHNESS III)");
		toughPolishIIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		toughPolishIIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> toughPolishIIILore = new ArrayList<String>();
		toughPolishIIILore.add("Toughness +3");
		toughPolishIIIMeta.setLore(toughPolishIIILore);
		toughPolishIII.setItemMeta(toughPolishIIIMeta);
		toughList.add(toughPolishIII);
		
		//Polish (toughness IV) +4 toughness
		ItemStack toughPolishIV = new ItemStack(Material.WHITE_DYE);
		ItemMeta toughPolishIVMeta = toughPolishIV.getItemMeta();
		toughPolishIVMeta.setDisplayName("Polish (TOUGHNESS IV)");
		toughPolishIVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		toughPolishIVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> toughPolishIVLore = new ArrayList<String>();
		toughPolishIVLore.add("Toughness +4");
		toughPolishIVMeta.setLore(toughPolishIVLore);
		toughPolishIV.setItemMeta(toughPolishIVMeta);
		toughList.add(toughPolishIV);
		
		//Polish (toughness V) +5 toughness
		ItemStack toughPolishV = new ItemStack(Material.WHITE_DYE);
		ItemMeta toughPolishVMeta = toughPolishV.getItemMeta();
		toughPolishVMeta.setDisplayName("Polish (TOUGHNESS V)");
		toughPolishVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		toughPolishVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> toughPolishVLore = new ArrayList<String>();
		toughPolishVLore.add("Toughness +5");
		toughPolishVMeta.setLore(toughPolishVLore);
		toughPolishV.setItemMeta(toughPolishVMeta);
		toughList.add(toughPolishV);	
		
		//Polish (toughness VI) +6 toughness
		ItemStack toughPolishVI = new ItemStack(Material.WHITE_DYE);
		ItemMeta toughPolishVIMeta = toughPolishVI.getItemMeta();
		toughPolishVIMeta.setDisplayName("Polish (TOUGHNESS VI)");
		toughPolishVIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		toughPolishVIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> toughPolishVILore = new ArrayList<String>();
		toughPolishVILore.add("Toughness +6");
		toughPolishVIMeta.setLore(toughPolishVILore);
		toughPolishVI.setItemMeta(toughPolishVIMeta);
		toughList.add(toughPolishVI);
		
		returnMap.put("hp", hpList);
		returnMap.put("tough", toughList);
		
		return returnMap;
	}
}
