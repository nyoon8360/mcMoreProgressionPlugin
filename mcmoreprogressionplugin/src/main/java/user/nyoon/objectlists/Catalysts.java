package user.nyoon.objectlists;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.plugincore.PluginCore;

public class Catalysts {
	public static HashMap<String, ArrayList<ItemStack>> popCatalysts() {
		HashMap<String, ArrayList<ItemStack>> returnMap = new HashMap<>();
		ArrayList<ItemStack> atkDmgWSList = new ArrayList<>();
		ArrayList<ItemStack> atkSpdWSList = new ArrayList<>();
		ArrayList<ItemStack> hpPolishList = new ArrayList<>();
		ArrayList<ItemStack> toughPolishList = new ArrayList<>();

		// assassin gems
		ArrayList<ItemStack> backstabGemList = new ArrayList<>();
		ArrayList<ItemStack> smokeScreenGemList = new ArrayList<>();
		ArrayList<ItemStack> hasteGemList = new ArrayList<>();

		// Warrior Gems
		ArrayList<ItemStack> immobilizeGemList = new ArrayList<>();
		ArrayList<ItemStack> ironSkinGemList = new ArrayList<>();
		ArrayList<ItemStack> interventionGemList = new ArrayList<>();

		// Archer Gems
		ArrayList<ItemStack> enderShotGemList = new ArrayList<>();
		ArrayList<ItemStack> whirlwindGemList = new ArrayList<>();
		ArrayList<ItemStack> cripplingArrowGemList = new ArrayList<>();

		// Hemomancer Gems
		ArrayList<ItemStack> famineGemList = new ArrayList<>();
		ArrayList<ItemStack> sacrificialRegenerationGemList = new ArrayList<>();
		ArrayList<ItemStack> siphonGemList = new ArrayList<>();

		// catalyst sprites list
		/*
		 * atkdmg whetstones = red dye atkspd whetstones = green dye hp polishes = white
		 * dye tough polishes = light gray dye
		 * 
		 * Assassin Gem: black dye Warrior Gem: yellow dye Archer Gem: cyan dye
		 * Hemomancer Gem: orange dye
		 * 
		 */

		/*=========================================================================================================================
		 * WHETSTONES/POLISHES
		 *=========================================================================================================================
		 */
		
		// 6 levels of atk dmg whetstones
		for (int x = 1; x <= 6; x++) {
			ItemStack catalyst = new ItemStack(Material.RED_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "Attack Damage " + x + " Whetstone Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			ArrayList<String> Lore = new ArrayList<>();
			Lore.add("Mold: Whetstone Mold");
			switch(x) {
			
			case 1:
				Lore.add("Material: 4 Diamonds");
				Lore.add("Material: 8 Flint");
				break;
				
			case 2:
				Lore.add("Material: 10 Diamonds");
				Lore.add("Material: 10 Flint");
				Lore.add("Material: 8 Gold");
				break;
				
			case 3:
				Lore.add("Material: 16 Diamonds");
				Lore.add("Material: 20 Flint");
				Lore.add("Material: 20 Gold");
				break;
				
			case 4:
				Lore.add("Material: 24 Diamonds");
				Lore.add("Material: 30 Flint");
				Lore.add("Material: 30 Gold");
				break;
				
			case 5:
				Lore.add("Material: 32 Diamonds");
				Lore.add("Material: 38 Flint");
				Lore.add("Material: 40 Gold");
				break;
				
			case 6:
				Lore.add("Material: 42 Diamonds");
				Lore.add("Material: 48 Flint");
				Lore.add("Material: 64 Gold");
				break;
			}
			catalystMeta.setLore(Lore);
			
			catalyst.setItemMeta(catalystMeta);
			atkDmgWSList.add(catalyst);
		}

		// 5 levels of atk spd whetstones
		for (int x = 1; x <= 5; x++) {
			ItemStack catalyst = new ItemStack(Material.GREEN_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "Attack Speed " + x + " Whetstone Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			ArrayList<String> Lore = new ArrayList<>();
			Lore.add("Mold: Whetstone Mold");
			switch(x) {
			
			case 1:
				Lore.add("Material: 1 Nautilus Shell");
				Lore.add("Material: 10 Diamonds");
				break;
				
			case 2:
				Lore.add("Material: 2 Nautilus Shell");
				Lore.add("Material: 15 Diamonds");
				break;
				
			case 3:
				Lore.add("Material: 3 Nautilus Shell");
				Lore.add("Material: 20 Diamonds");
				break;
				
			case 4:
				Lore.add("Material: 5 Nautilus Shell");
				Lore.add("Material: 32 Diamonds");
				break;
				
			case 5:
				Lore.add("Material: 8 Nautilus Shell");
				Lore.add("Material: 50 Diamonds");
				Lore.add("Material: 32 Blaze Rods");
				break;
			}
			catalystMeta.setLore(Lore);
			
			catalyst.setItemMeta(catalystMeta);
			atkSpdWSList.add(catalyst);
		}

		// 6 levels of hp polishes
		for (int x = 1; x <= 6; x++) {
			ItemStack catalyst = new ItemStack(Material.WHITE_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "Health Polish " + x + " Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			ArrayList<String> Lore = new ArrayList<>();
			Lore.add("Mold: Polish Mold");
			switch(x) {
			
			case 1:
				Lore.add("Material: 4 Golden Apples");
				Lore.add("Material: 20 Iron Ingots");
				break;
				
			case 2:
				Lore.add("Material: 8 Golden Apples");
				Lore.add("Material: 25 Iron Ingots");
				break;
				
			case 3:
				Lore.add("Material: 14 Golden Apples");
				Lore.add("Material: 30 Iron Ingots");
				break;
				
			case 4:
				Lore.add("Material: 20 Golden Apples");
				Lore.add("Material: 40 Iron Ingots");
				break;
				
			case 5:
				Lore.add("Material: 28 Golden Apples");
				Lore.add("Material: 64 Iron Ingots");
				break;
				
			case 6:
				Lore.add("Material: 38 Golden Apples");
				Lore.add("Material: 9 Iron Blocks");
				break;
			}
			catalystMeta.setLore(Lore);
			
			catalyst.setItemMeta(catalystMeta);
			hpPolishList.add(catalyst);
		}

		// 6 levels of toughness polishes
		for (int x = 1; x <= 6; x++) {
			ItemStack catalyst = new ItemStack(Material.LIGHT_GRAY_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "Armor Toughness " + x + " Polish Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			ArrayList<String> Lore = new ArrayList<>();
			Lore.add("Mold: Polish Mold");
			switch(x) {
			
			case 1:
				Lore.add("Material: 8 Obsidian");
				Lore.add("Material: 5 Diamonds");
				break;
				
			case 2:
				Lore.add("Material: 14 Obsidian");
				Lore.add("Material: 10 Diamonds");
				break;
				
			case 3:
				Lore.add("Material: 28 Obsidian");
				Lore.add("Material: 15 Diamonds");
				break;
				
			case 4:
				Lore.add("Material: 40 Obsidian");
				Lore.add("Material: 20 Diamonds");
				break;
				
			case 5:
				Lore.add("Material: 54 Obsidian");
				Lore.add("Material: 30 Diamonds");
				break;
				
			case 6:
				Lore.add("Material: 64 Obsidian");
				Lore.add("Material: 40 Diamonds");
				break;
			}
			catalystMeta.setLore(Lore);
			
			catalyst.setItemMeta(catalystMeta);
			toughPolishList.add(catalyst);
		}

		/*=========================================================================================================================
		 * ASSASSIN SKILL GEMS
		 *=========================================================================================================================
		 */
		
		// 3 levels of Assassin Backstab Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Assassin) Backstab " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			backstabGemList.add(catalyst);
		}

		// 3 levels of Assassin Smoke Screen Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Assassin) Smoke Screen " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			smokeScreenGemList.add(catalyst);
		}

		// 3 levels of Assassin Haste Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Assassin) Haste " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			hasteGemList.add(catalyst);
		}

		/*=========================================================================================================================
		 * WARRIOR SKILL GEMS
		 *=========================================================================================================================
		 */
		
		// 3 levels of Warrior Immobilize Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Warrior) Immobilize " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			immobilizeGemList.add(catalyst);
		}
		
		// 3 levels of Warrior Iron Skin Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Warrior) Iron Skin " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			ironSkinGemList.add(catalyst);
		}
		
		// 3 levels of Warrior Intervention Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Warrior) Intervention " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			interventionGemList.add(catalyst);
		}
		
		/*=========================================================================================================================
		 * ARCHER SKILL GEMS
		 *=========================================================================================================================
		 */
		
		// 3 levels of Archer Ender Shot Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Archer) Ender Shot " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			enderShotGemList.add(catalyst);
		}
		
		// 3 levels of Archer Whirlwind Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Archer) Whirlwind " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			whirlwindGemList.add(catalyst);
		}
		
		// 3 levels of Crippling Arrow Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Archer) Crippling Arrow " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			cripplingArrowGemList.add(catalyst);
		}
		
		/*=========================================================================================================================
		 * HEMOMANCER SKILL GEMS
		 *=========================================================================================================================
		 */
		
		// 3 levels of Famine Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Hemomancer) Famine " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			famineGemList.add(catalyst);
		}
		
		// 3 levels of Sacrificial Regeneration Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Hemomancer) Sacrificial Regeneration " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			sacrificialRegenerationGemList.add(catalyst);
		}
		
		// 3 levels of Siphon Gems
		for (int x = 1; x <= 3; x++) {
			ItemStack catalyst = new ItemStack(Material.BLACK_DYE);
			ItemMeta catalystMeta = catalyst.getItemMeta();
			catalystMeta.setDisplayName(ChatColor.DARK_PURPLE + "(Hemomancer) Siphon " + x + " Skill Gem Catalyst");
			catalystMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			catalystMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			catalyst.setItemMeta(catalystMeta);
			siphonGemList.add(catalyst);
		}
		
		//add all catalyst arraylists to hashmap
		returnMap.put("atkdmgws",atkDmgWSList);
		returnMap.put("atkspdws",atkSpdWSList);
		returnMap.put("hppolish",hpPolishList);
		returnMap.put("toughpolish",toughPolishList);
		returnMap.put("backstabgem",backstabGemList);
		returnMap.put("smokescreengem",smokeScreenGemList);
		returnMap.put("hastegem",hasteGemList);
		returnMap.put("immobilizegem",immobilizeGemList);
		returnMap.put("ironskingem",ironSkinGemList);
		returnMap.put("interventiongem",interventionGemList);
		returnMap.put("endershotgem",enderShotGemList);
		returnMap.put("whirlwindgem",whirlwindGemList);
		returnMap.put("cripplingarrowgem",cripplingArrowGemList);
		returnMap.put("faminegem",famineGemList);
		returnMap.put("sacrificialregenerationgem",sacrificialRegenerationGemList);
		returnMap.put("siphongem",siphonGemList);
		
		return returnMap;
	}
	
	public static ItemStack getRandomSkillGemCatalyst(int level) {
		ArrayList<String> skillGemKeys = new ArrayList<>();
		for (String x : PluginCore.getCatalysts().keySet()) {
			if (x.contains("gem")) {
				skillGemKeys.add(x);
			}
		}
		
		int rand = PluginCore.randInt(skillGemKeys.size() - 1);
		
		return PluginCore.getCatalysts().get(skillGemKeys.get(rand)).get(level - 1);
	}
}
