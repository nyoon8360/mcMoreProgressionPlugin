package user.nyoon.recipes;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import user.nyoon.plugincore.PluginCore;

public class ArrowRecipes {
	
	public static ItemStack craftArrow(ItemStack arrowHead, ItemStack poison) {
		String recipeString;
		if (arrowHead.getItemMeta().hasDisplayName()) {
			recipeString = arrowHead.getItemMeta().getDisplayName();
		} else {
			recipeString = arrowHead.getType().toString();
		}
		
		if (poison != null && poison.getItemMeta().hasDisplayName()) {
			recipeString += " " + poison.getItemMeta().getDisplayName();
		}
		
		return PluginCore.arrowRecipes.get(recipeString);
	}
	
	public static void popArrowRecipes() {
		//basic arrow
		ItemStack arrow1 = new ItemStack(Material.ARROW);
		arrow1.setAmount(4);
		PluginCore.arrowRecipes.put("FLINT", arrow1);
		
		//sharp arrow
		ItemStack arrow2 = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta arrow2Meta = (PotionMeta) arrow2.getItemMeta();
		arrow2Meta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 1, 0), true);
		ArrayList<String> arrow2Lore = new ArrayList<>();
		arrow2Lore.add("+2 Damage");
		arrow2Meta.setLore(arrow2Lore);
		arrow2Meta.setDisplayName("Sharp Arrow");
		arrow2.setItemMeta(arrow2Meta);
		arrow2.setAmount(4);
		PluginCore.arrowRecipes.put("Sharp Arrowhead", arrow2);
		
		//very sharp arrow
		ItemStack arrow3 = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta arrow3Meta = (PotionMeta) arrow3.getItemMeta();
		arrow3Meta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 1, 1), true);
		ArrayList<String> arrow3Lore = new ArrayList<>();
		arrow3Lore.add("+4 Damage");
		arrow3Meta.setLore(arrow3Lore);
		arrow3Meta.setDisplayName("Very Sharp Arrow");
		arrow3.setItemMeta(arrow3Meta);
		arrow3.setAmount(4);
		PluginCore.arrowRecipes.put("Very Sharp Arrowhead", arrow3);
		
		//extremely sharp arrow
		ItemStack arrow4 = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta arrow4Meta = (PotionMeta) arrow4.getItemMeta();
		arrow4Meta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 1, 3), true);
		ArrayList<String> arrow4Lore = new ArrayList<>();
		arrow4Lore.add("+8 Damage");
		arrow4Meta.setLore(arrow4Lore);
		arrow4Meta.setDisplayName("Extremely Sharp Arrow");
		arrow4.setItemMeta(arrow4Meta);
		arrow4.setAmount(4);
		PluginCore.arrowRecipes.put("Extremely Sharp Arrowhead", arrow4);
		
		//slow arrow
		ItemStack arrow5 = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta arrow5Meta = (PotionMeta) arrow5.getItemMeta();
		arrow5Meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1), true);
		arrow5Meta.setDisplayName("Slow I Arrrow");
		arrow5.setItemMeta(arrow5Meta);
		arrow5.setAmount(4);
		PluginCore.arrowRecipes.put("FLINT Slow Poison I", arrow5);
		
		//stun arrow
		ItemStack arrow6 = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta arrow6Meta = (PotionMeta) arrow6.getItemMeta();
		arrow6Meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 60, 7), true);
		arrow6Meta.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 60, -3), true);
		arrow6Meta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 30), true);
		arrow6Meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 60, 10), true);
		arrow6Meta.setDisplayName("Stun I Arrow");
		arrow6.setItemMeta(arrow6Meta);
		arrow6.setAmount(4);
		PluginCore.arrowRecipes.put("FLINT Stun Poison I", arrow6);
		
		//weakness arrow
		ItemStack arrow7 = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta arrow7Meta = (PotionMeta) arrow7.getItemMeta();
		arrow7Meta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 1), true);
		arrow7Meta.setDisplayName("Weakness I Arrow");
		arrow7.setItemMeta(arrow7Meta);
		arrow7.setAmount(4);
		PluginCore.arrowRecipes.put("FLINT Weakness Poison I", arrow7);
		
		//decay arrow
		ItemStack arrow8 = new ItemStack(Material.TIPPED_ARROW);
		PotionMeta arrow8Meta = (PotionMeta) arrow8.getItemMeta();
		arrow8Meta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 100, 4), true);
		arrow8Meta.setDisplayName("Decay I Arrow");
		arrow8.setItemMeta(arrow8Meta);
		arrow8.setAmount(4);
		PluginCore.arrowRecipes.put("FLINT Decay Poison I", arrow8);
	}
}
