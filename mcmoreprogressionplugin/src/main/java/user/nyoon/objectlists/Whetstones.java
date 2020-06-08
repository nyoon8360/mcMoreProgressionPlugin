package user.nyoon.objectlists;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Whetstones {
	public static HashMap<String, ArrayList<ItemStack>> popWhetstones() {
		HashMap<String, ArrayList<ItemStack>> returnMap = new HashMap<>();
		ArrayList<ItemStack> atkdmgList = new ArrayList<>();
		ArrayList<ItemStack> atkspdList = new ArrayList<>();

		/*
		Dmg I: 0
		Dmg II: 1
		Dmg III: 2
		Dmg IV: 3
		Dmg V: 4
		Dmg VI: 5
		
		AtkSpd I: 0
		AtkSpd II: 1
		AtkSpd III: 2
		AtkSpd IV: 3
		AtkSpd V: 4
		
		 */
		
		// Whetstone (dmg I) +2dmg
		ItemStack dmgWhetstoneI = new ItemStack(Material.CLAY_BALL);
		ItemMeta dmgWhetstoneIMeta = dmgWhetstoneI.getItemMeta();
		dmgWhetstoneIMeta.setDisplayName("Whetstone (DMG I)");
		dmgWhetstoneIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		dmgWhetstoneIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> dmgWhetstoneILore = new ArrayList<String>();
		dmgWhetstoneILore.add("AttackDamage +2");
		dmgWhetstoneIMeta.setLore(dmgWhetstoneILore);
		dmgWhetstoneI.setItemMeta(dmgWhetstoneIMeta);
		atkdmgList.add(dmgWhetstoneI);

		// Whetstone (dmg II) +4dmg
		ItemStack dmgWhetstoneII = new ItemStack(Material.CLAY_BALL);
		ItemMeta dmgWhetstoneIIMeta = dmgWhetstoneII.getItemMeta();
		dmgWhetstoneIIMeta.setDisplayName("Whetstone (DMG II)");
		dmgWhetstoneIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		dmgWhetstoneIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> dmgWhetstoneIILore = new ArrayList<String>();
		dmgWhetstoneIILore.add("AttackDamage +4");
		dmgWhetstoneIIMeta.setLore(dmgWhetstoneIILore);
		dmgWhetstoneII.setItemMeta(dmgWhetstoneIIMeta);
		atkdmgList.add(dmgWhetstoneII);

		// Whetstone (dmg III) +6dmg
		ItemStack dmgWhetstoneIII = new ItemStack(Material.CLAY_BALL);
		ItemMeta dmgWhetstoneIIIMeta = dmgWhetstoneIII.getItemMeta();
		dmgWhetstoneIIIMeta.setDisplayName("Whetstone (DMG III)");
		dmgWhetstoneIIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		dmgWhetstoneIIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> dmgWhetstoneIIILore = new ArrayList<String>();
		dmgWhetstoneIIILore.add("AttackDamage +6");
		dmgWhetstoneIIIMeta.setLore(dmgWhetstoneIIILore);
		dmgWhetstoneIII.setItemMeta(dmgWhetstoneIIIMeta);
		atkdmgList.add(dmgWhetstoneIII);

		// Whetstone (dmg IV) +8dmg
		ItemStack dmgWhetstoneIV = new ItemStack(Material.CLAY_BALL);
		ItemMeta dmgWhetstoneIVMeta = dmgWhetstoneIV.getItemMeta();
		dmgWhetstoneIVMeta.setDisplayName("Whetstone (DMG IV)");
		dmgWhetstoneIVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		dmgWhetstoneIVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> dmgWhetstoneIVLore = new ArrayList<String>();
		dmgWhetstoneIVLore.add("AttackDamage +8");
		dmgWhetstoneIVMeta.setLore(dmgWhetstoneIVLore);
		dmgWhetstoneIV.setItemMeta(dmgWhetstoneIVMeta);
		atkdmgList.add(dmgWhetstoneIV);

		// Whetstone (dmg V) +10dmg
		ItemStack dmgWhetstoneV = new ItemStack(Material.CLAY_BALL);
		ItemMeta dmgWhetstoneVMeta = dmgWhetstoneV.getItemMeta();
		dmgWhetstoneVMeta.setDisplayName("Whetstone (DMG V)");
		dmgWhetstoneVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		dmgWhetstoneVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> dmgWhetstoneVLore = new ArrayList<String>();
		dmgWhetstoneVLore.add("AttackDamage +10");
		dmgWhetstoneVMeta.setLore(dmgWhetstoneVLore);
		dmgWhetstoneV.setItemMeta(dmgWhetstoneVMeta);
		atkdmgList.add(dmgWhetstoneV);
		
		// Whetstone (dmg VI) +12dmg
		ItemStack dmgWhetstoneVI = new ItemStack(Material.CLAY_BALL);
		ItemMeta dmgWhetstoneVIMeta = dmgWhetstoneVI.getItemMeta();
		dmgWhetstoneVIMeta.setDisplayName("Whetstone (DMG VI)");
		dmgWhetstoneVIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		dmgWhetstoneVIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> dmgWhetstoneVILore = new ArrayList<String>();
		dmgWhetstoneVILore.add("AttackDamage +12");
		dmgWhetstoneVIMeta.setLore(dmgWhetstoneVILore);
		dmgWhetstoneVI.setItemMeta(dmgWhetstoneVIMeta);
		atkdmgList.add(dmgWhetstoneVI);

		// Whetstone (atkspd I) +20% atkspd
		ItemStack atkspdWhetstoneI = new ItemStack(Material.CLAY_BALL);
		ItemMeta atkspdWhetstoneIMeta = atkspdWhetstoneI.getItemMeta();
		atkspdWhetstoneIMeta.setDisplayName("Whetstone (ATKSPD I)");
		atkspdWhetstoneIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		atkspdWhetstoneIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> atkspdWhetstoneILore = new ArrayList<String>();
		atkspdWhetstoneILore.add("AttackSpeed% +20");
		atkspdWhetstoneIMeta.setLore(atkspdWhetstoneILore);
		atkspdWhetstoneI.setItemMeta(atkspdWhetstoneIMeta);
		atkspdList.add(atkspdWhetstoneI);

		// Whetstone (atkspd II) +40% atkspd
		ItemStack atkspdWhetstoneII = new ItemStack(Material.CLAY_BALL);
		ItemMeta atkspdWhetstoneIIMeta = atkspdWhetstoneII.getItemMeta();
		atkspdWhetstoneIIMeta.setDisplayName("Whetstone (ATKSPD II)");
		atkspdWhetstoneIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		atkspdWhetstoneIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> atkspdWhetstoneIILore = new ArrayList<String>();
		atkspdWhetstoneIILore.add("AttackSpeed% +40");
		atkspdWhetstoneIIMeta.setLore(atkspdWhetstoneIILore);
		atkspdWhetstoneII.setItemMeta(atkspdWhetstoneIIMeta);
		atkspdList.add(atkspdWhetstoneII);

		// Whetstone (atkspd III) +60% atkspd
		ItemStack atkspdWhetstoneIII = new ItemStack(Material.CLAY_BALL);
		ItemMeta atkspdWhetstoneIIIMeta = atkspdWhetstoneIII.getItemMeta();
		atkspdWhetstoneIIIMeta.setDisplayName("Whetstone (ATKSPD III)");
		atkspdWhetstoneIIIMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		atkspdWhetstoneIIIMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> atkspdWhetstoneIIILore = new ArrayList<String>();
		atkspdWhetstoneIIILore.add("AttackSpeed% +60");
		atkspdWhetstoneIIIMeta.setLore(atkspdWhetstoneIIILore);
		atkspdWhetstoneIII.setItemMeta(atkspdWhetstoneIIIMeta);
		atkspdList.add(atkspdWhetstoneIII);

		// Whetstone (atkspd IV) +80% atkspd
		ItemStack atkspdWhetstoneIV = new ItemStack(Material.CLAY_BALL);
		ItemMeta atkspdWhetstoneIVMeta = atkspdWhetstoneIV.getItemMeta();
		atkspdWhetstoneIVMeta.setDisplayName("Whetstone (ATKSPD IV)");
		atkspdWhetstoneIVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		atkspdWhetstoneIVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> atkspdWhetstoneIVLore = new ArrayList<String>();
		atkspdWhetstoneIVLore.add("AttackSpeed% +80");
		atkspdWhetstoneIVMeta.setLore(atkspdWhetstoneIVLore);
		atkspdWhetstoneIV.setItemMeta(atkspdWhetstoneIVMeta);
		atkspdList.add(atkspdWhetstoneIV);

		// Whetstone (atkspd V) +100% atkspd
		ItemStack atkspdWhetstoneV = new ItemStack(Material.CLAY_BALL);
		ItemMeta atkspdWhetstoneVMeta = atkspdWhetstoneV.getItemMeta();
		atkspdWhetstoneVMeta.setDisplayName("Whetstone (ATKSPD V)");
		atkspdWhetstoneVMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		atkspdWhetstoneVMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ArrayList<String> atkspdWhetstoneVLore = new ArrayList<String>();
		atkspdWhetstoneVLore.add("AttackSpeed% +100");
		atkspdWhetstoneVMeta.setLore(atkspdWhetstoneVLore);
		atkspdWhetstoneV.setItemMeta(atkspdWhetstoneVMeta);
		atkspdList.add(atkspdWhetstoneV);
		
		returnMap.put("atkdmg", atkdmgList);
		returnMap.put("atkspd", atkspdList);
		
		return returnMap;
	}
}
