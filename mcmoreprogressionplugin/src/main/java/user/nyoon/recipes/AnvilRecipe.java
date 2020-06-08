package user.nyoon.recipes;

import org.bukkit.inventory.ItemStack;

import user.nyoon.plugincore.PluginCore;

public class AnvilRecipe {
	
	public static ItemStack forgeRecipe(ItemStack recipe, ItemStack suppliedBase, int suppliedBaseNum) {
		String result = recipe.getItemMeta().getDisplayName() + " ";
		result += AnvilRecipe.constructIngredientString(suppliedBase, suppliedBaseNum);
		
		return PluginCore.customForgingRecipes.get(result);
	}
	
	public static ItemStack forgeRecipe(ItemStack recipe, ItemStack suppliedBase, int suppliedBaseNum, ItemStack sAddon1, int sAddon1Num) {
		String result = recipe.getItemMeta().getDisplayName() + " ";
		result += AnvilRecipe.constructIngredientString(suppliedBase, suppliedBaseNum, sAddon1, sAddon1Num);
		
		return PluginCore.customForgingRecipes.get(result);
	}
	
	public static ItemStack forgeRecipe(ItemStack recipe, ItemStack suppliedBase, int suppliedBaseNum, ItemStack sAddon1, int sAddon1Num
			, ItemStack sAddon2, int sAddon2Num) {
		String result = recipe.getItemMeta().getDisplayName() + " ";
		result += AnvilRecipe.constructIngredientString(suppliedBase, suppliedBaseNum, sAddon1, sAddon1Num, sAddon2, sAddon2Num);
		
		return PluginCore.customForgingRecipes.get(result);
	}
	
	public static ItemStack forgeRecipe(ItemStack recipe, ItemStack suppliedBase, int suppliedBaseNum, ItemStack sAddon1, int sAddon1Num
			, ItemStack sAddon2, int sAddon2Num, ItemStack sAddon3, int sAddon3Num) {
		String result = recipe.getItemMeta().getDisplayName() + " ";
		result += AnvilRecipe.constructIngredientString(suppliedBase, suppliedBaseNum, sAddon1, sAddon1Num, sAddon2, sAddon2Num, sAddon3, sAddon3Num);
		
		return PluginCore.customForgingRecipes.get(result);
	}
	
	public static String constructIngredientString(ItemStack item, int num) {
		String returnString;
		if (item.getItemMeta().hasDisplayName()) {
			returnString = item.getItemMeta().getDisplayName();
		} else {
			returnString = item.getType().toString();
		}
		
		returnString += " " + num;
		return returnString;
	}
	
	public static String constructIngredientString(ItemStack item, int num, ItemStack item2, int num2) {
		String returnString;
		if (item.getItemMeta().hasDisplayName()) {
			returnString = item.getItemMeta().getDisplayName();
		} else {
			returnString = item.getType().toString();
		}
		
		returnString += " " + num + " ";
		
		if (item2.getItemMeta().hasDisplayName()) {
			returnString += item2.getItemMeta().getDisplayName();
		} else {
			returnString += item2.getType().toString();
		}
		
		returnString += " " + num2;
		
		return returnString;
	}
	
	public static String constructIngredientString(ItemStack item, int num, ItemStack item2, int num2, ItemStack item3, int num3) {
		String returnString;
		if (item.getItemMeta().hasDisplayName()) {
			returnString = item.getItemMeta().getDisplayName();
		} else {
			returnString = item.getType().toString();
		}
		
		returnString += " " + num + " ";
		
		if (item2.getItemMeta().hasDisplayName()) {
			returnString += item2.getItemMeta().getDisplayName();
		} else {
			returnString += item2.getType().toString();
		}
		
		returnString += " " + num2 + " ";
		
		if (item.getItemMeta().hasDisplayName()) {
			returnString += item3.getItemMeta().getDisplayName();
		} else {
			returnString += item3.getType().toString();
		}
		
		returnString += " " + num3;
		
		return returnString;
	}
	
	public static String constructIngredientString(ItemStack item, int num, ItemStack item2, int num2, ItemStack item3, int num3, ItemStack item4, int num4) {
		String returnString;
		if (item.getItemMeta().hasDisplayName()) {
			returnString = item.getItemMeta().getDisplayName();
		} else {
			returnString = item.getType().toString();
		}
		
		returnString += " " + num + " ";
		
		if (item2.getItemMeta().hasDisplayName()) {
			returnString += item2.getItemMeta().getDisplayName();
		} else {
			returnString += item2.getType().toString();
		}
		
		returnString += " " + num2 + " ";
		
		if (item.getItemMeta().hasDisplayName()) {
			returnString += item3.getItemMeta().getDisplayName();
		} else {
			returnString += item3.getType().toString();
		}
		
		returnString += " " + num3 + " ";
		
		if (item4.getItemMeta().hasDisplayName()) {
			returnString += item4.getItemMeta().getDisplayName();
		} else {
			returnString += item4.getType().toString();
		}
		
		returnString += " " + num4;
		
		return returnString;
	}
}
