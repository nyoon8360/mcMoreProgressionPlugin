package user.nyoon.recipes;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import user.nyoon.helperclasses.Upgrader;
import user.nyoon.plugincore.PluginCore;

public class UpgraderRecipes {
	public static HashMap<String, Upgrader> popUpgradeablesRecipes() {
		HashMap<String, Upgrader> returnMap = new HashMap<>();

		// result lists
		HashMap<String, ArrayList<ItemStack>> whetstones = PluginCore.getWhetstones();
		HashMap<String, ArrayList<ItemStack>> polishes = PluginCore.getPolishes();
		// TODO make skill gem object lists and add here

		// mold lists
		ArrayList<ItemStack> molds = PluginCore.getMolds();

		// catalyst lists
		ArrayList<ItemStack> atkdmgws = PluginCore.getCatalysts().get("atkdmgws");
		ArrayList<ItemStack> atkspdws = PluginCore.getCatalysts().get("atkspdws");
		ArrayList<ItemStack> hppolish = PluginCore.getCatalysts().get("hppolish");
		ArrayList<ItemStack> toughpolish = PluginCore.getCatalysts().get("toughpolish");

		// ============================================================
		// whetstones
		// ============================================================

		for (int x = 0; x < 5; x++) {
			ArrayList<ItemStack> materials = new ArrayList<>();
			
			switch(x) {
			
			//atkdmg whetstone costs
			
			case 0:
				materials.add(new ItemStack(Material.DIAMOND, 4));
				materials.add(new ItemStack(Material.FLINT, 8));
				break;
			
			case 1:
				materials.add(new ItemStack(Material.DIAMOND, 10));
				materials.add(new ItemStack(Material.FLINT, 10));
				materials.add(new ItemStack(Material.GOLD_INGOT, 8));
				break;
			
			case 2:
				materials.add(new ItemStack(Material.DIAMOND, 16));
				materials.add(new ItemStack(Material.FLINT, 20));
				materials.add(new ItemStack(Material.GOLD_INGOT, 20));
				break;
				
			case 3:
				materials.add(new ItemStack(Material.DIAMOND, 24));
				materials.add(new ItemStack(Material.FLINT, 30));
				materials.add(new ItemStack(Material.GOLD_INGOT, 30));
				break;
				
			case 4:
				materials.add(new ItemStack(Material.DIAMOND, 32));
				materials.add(new ItemStack(Material.FLINT, 38));
				materials.add(new ItemStack(Material.GOLD_INGOT, 40));
				break;
				
			case 5:
				materials.add(new ItemStack(Material.DIAMOND, 42));
				materials.add(new ItemStack(Material.FLINT, 48));
				materials.add(new ItemStack(Material.GOLD_INGOT, 64));
				break;
				
			}
			
			Upgrader atkdmgWS = new Upgrader(whetstones.get("atkdmg").get(x), molds.get(1), atkdmgws.get(x), materials);
			returnMap.put(molds.get(1).getItemMeta().getDisplayName() + atkdmgws.get(x).getItemMeta().getDisplayName(), atkdmgWS);
		}
		
		for (int x = 0; x < 5; x++) {
			ArrayList<ItemStack> materials = new ArrayList<>();
			
			switch(x) {
			//atkspd whetstone costs
			
			case 0:
				materials.add(new ItemStack(Material.NAUTILUS_SHELL, 1));
				materials.add(new ItemStack(Material.DIAMOND, 10));
				break;
				
			case 1:
				materials.add(new ItemStack(Material.NAUTILUS_SHELL, 2));
				materials.add(new ItemStack(Material.DIAMOND, 15));
				break;
				
			case 2:
				materials.add(new ItemStack(Material.NAUTILUS_SHELL, 3));
				materials.add(new ItemStack(Material.DIAMOND, 20));
				break;
				
			case 3:
				materials.add(new ItemStack(Material.NAUTILUS_SHELL, 5));
				materials.add(new ItemStack(Material.DIAMOND, 32));
				break;
				
			case 4:
				materials.add(new ItemStack(Material.NAUTILUS_SHELL, 8));
				materials.add(new ItemStack(Material.DIAMOND, 50));
				materials.add(new ItemStack(Material.BLAZE_ROD, 32));
				break;
			}
			
			Upgrader atkspdWS = new Upgrader(whetstones.get("atkspd").get(x), molds.get(1), atkspdws.get(x), materials);
			returnMap.put(molds.get(1).getItemMeta().getDisplayName() + atkspdws.get(x).getItemMeta().getDisplayName(), atkspdWS);
		}
		
		// ============================================================
		// polishes
		// ============================================================

		for (int x = 0; x < 6; x++) {
			ArrayList<ItemStack> materials = new ArrayList<>();
			
			switch(x) {
			
			//hp polish costs
			
			case 0:
				materials.add(new ItemStack(Material.GOLDEN_APPLE, 4));
				materials.add(new ItemStack(Material.IRON_INGOT, 20));
				break;
			
			case 1:
				materials.add(new ItemStack(Material.GOLDEN_APPLE, 8));
				materials.add(new ItemStack(Material.IRON_INGOT, 25));
				break;
			
			case 2:
				materials.add(new ItemStack(Material.GOLDEN_APPLE, 14));
				materials.add(new ItemStack(Material.IRON_INGOT, 30));
				break;
				
			case 3:
				materials.add(new ItemStack(Material.GOLDEN_APPLE, 20));
				materials.add(new ItemStack(Material.IRON_INGOT, 40));
				break;
				
			case 4:
				materials.add(new ItemStack(Material.GOLDEN_APPLE, 28));
				materials.add(new ItemStack(Material.IRON_INGOT, 64));
				break;
				
			case 5:
				materials.add(new ItemStack(Material.GOLDEN_APPLE, 38));
				materials.add(new ItemStack(Material.IRON_BLOCK, 9));
				break;
				
			}
			
			Upgrader hpPolish = new Upgrader(polishes.get("hp").get(x), molds.get(2), hppolish.get(x), materials);
			returnMap.put(molds.get(2).getItemMeta().getDisplayName() + hppolish.get(x).getItemMeta().getDisplayName(), hpPolish);
		}
		
		for (int x = 0; x < 6; x++) {
			ArrayList<ItemStack> materials = new ArrayList<>();
			
			switch(x) {
			//tough polish costs	
			
			case 0:
				materials.add(new ItemStack(Material.OBSIDIAN, 8));
				materials.add(new ItemStack(Material.DIAMOND, 5));
				break;
				
			case 1:
				materials.add(new ItemStack(Material.OBSIDIAN, 14));
				materials.add(new ItemStack(Material.DIAMOND, 10));
				break;
				
			case 2:
				materials.add(new ItemStack(Material.OBSIDIAN, 28));
				materials.add(new ItemStack(Material.DIAMOND, 15));
				break;
				
			case 3:
				materials.add(new ItemStack(Material.OBSIDIAN, 40));
				materials.add(new ItemStack(Material.DIAMOND, 20));
				break;
				
			case 4:
				materials.add(new ItemStack(Material.OBSIDIAN, 54));
				materials.add(new ItemStack(Material.DIAMOND, 30));
				break;
				
			case 5:
				materials.add(new ItemStack(Material.OBSIDIAN, 64));
				materials.add(new ItemStack(Material.DIAMOND, 40));
				break;
			}
			
			Upgrader toughPolish = new Upgrader(polishes.get("tough").get(x), molds.get(2), toughpolish.get(x), materials);
			returnMap.put(molds.get(2).getItemMeta().getDisplayName() + toughpolish.get(x).getItemMeta().getDisplayName(), toughPolish);
		}
		
		// ============================================================
		// skill jewels
		// ============================================================

		return returnMap;
	}
}
