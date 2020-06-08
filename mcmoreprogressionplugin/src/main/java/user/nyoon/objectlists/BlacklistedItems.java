package user.nyoon.objectlists;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class BlacklistedItems {

	public static ArrayList<ItemStack> popBlacklist() {

		ArrayList<ItemStack> returnList = new ArrayList<ItemStack>();

		// 0: []
		ItemStack blank = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta blankMeta = blank.getItemMeta();
		blankMeta.setDisplayName(ChatColor.BLACK + "[]");
		blank.setItemMeta(blankMeta);
		returnList.add(blank);

		// 1: Base Material
		ItemStack baseMaterial = new ItemStack(Material.HOPPER);
		ItemMeta baseMaterialtMeta = baseMaterial.getItemMeta();
		baseMaterialtMeta.setDisplayName(ChatColor.GRAY + "Base Material");
		baseMaterial.setItemMeta(baseMaterialtMeta);
		returnList.add(baseMaterial);

		// 2: Add-on 1
		ItemStack addon1 = new ItemStack(Material.HOPPER);
		ItemMeta addon1Meta = addon1.getItemMeta();
		addon1Meta.setDisplayName(ChatColor.BLUE + "Add-on 1");
		addon1.setItemMeta(addon1Meta);
		returnList.add(addon1);

		// 3: Add-on 2
		ItemStack addon2 = new ItemStack(Material.HOPPER);
		ItemMeta addon2Meta = addon2.getItemMeta();
		addon2Meta.setDisplayName(ChatColor.BLUE + "Add-on 2");
		addon2.setItemMeta(addon2Meta);
		returnList.add(addon2);

		// 4: Add-on 3
		ItemStack addon3 = new ItemStack(Material.HOPPER);
		ItemMeta addon3Meta = addon3.getItemMeta();
		addon3Meta.setDisplayName(ChatColor.BLUE + "Add-on 3");
		addon3.setItemMeta(addon3Meta);
		returnList.add(addon3);

		// 5: Recipe marker
		ItemStack recipeButton = new ItemStack(Material.WRITABLE_BOOK);
		ItemMeta recipeButtonMeta = recipeButton.getItemMeta();
		recipeButtonMeta.setDisplayName(ChatColor.RED + "Forge Item");
		recipeButton.setItemMeta(recipeButtonMeta);
		returnList.add(recipeButton);

		// 6: Forge Button
		ItemStack forgeButton = new ItemStack(Material.ANVIL);
		ItemMeta forgeButtonMeta = forgeButton.getItemMeta();
		forgeButtonMeta.setDisplayName(ChatColor.RED + "Forge Item");
		forgeButton.setItemMeta(forgeButtonMeta);
		returnList.add(forgeButton);

		// 7: Place Equipment
		ItemStack equipButton = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
		ItemMeta equipButtonMeta = equipButton.getItemMeta();
		equipButtonMeta.setDisplayName(ChatColor.AQUA + "Place Equipment Here");
		equipButton.setItemMeta(equipButtonMeta);
		returnList.add(equipButton);

		// 8: Place Whetstone / Polish
		ItemStack whetpolishButton = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
		ItemMeta whetpolishButtonMeta = whetpolishButton.getItemMeta();
		whetpolishButtonMeta.setDisplayName(ChatColor.YELLOW + "Place Whetstone/Polish Here");
		whetpolishButton.setItemMeta(whetpolishButtonMeta);
		returnList.add(whetpolishButton);

		// 9: apply whetstone/polish
		ItemStack applyButton = new ItemStack(Material.GRINDSTONE);
		ItemMeta applyButtonMeta = applyButton.getItemMeta();
		applyButtonMeta.setDisplayName(ChatColor.GREEN + "Apply");
		applyButton.setItemMeta(applyButtonMeta);
		returnList.add(applyButton);

		// 10: repairing item
		ItemStack itemToRepairButton = new ItemStack(Material.IRON_BLOCK);
		ItemMeta itemToRepairButtonMeta = itemToRepairButton.getItemMeta();
		itemToRepairButtonMeta.setDisplayName(ChatColor.GRAY + "Place Equipment Here");
		itemToRepairButton.setItemMeta(itemToRepairButtonMeta);
		returnList.add(itemToRepairButton);

		// 11: repairing material
		ItemStack materialToUseButton = new ItemStack(Material.IRON_BLOCK);
		ItemMeta materialToUseButtonMeta = materialToUseButton.getItemMeta();
		materialToUseButtonMeta.setDisplayName(ChatColor.GRAY + "Place Materials Here");
		materialToUseButton.setItemMeta(materialToUseButtonMeta);
		returnList.add(materialToUseButton);

		// 12: repair button
		ItemStack repairButton = new ItemStack(Material.SMITHING_TABLE);
		ItemMeta repairButtonMeta = repairButton.getItemMeta();
		repairButtonMeta.setDisplayName(ChatColor.GREEN + "Repair");

		ArrayList<String> repairButtonLore = new ArrayList<>();
		repairButtonLore.add(ChatColor.WHITE + "Base Repair Costs");
		repairButtonLore.add(ChatColor.WHITE + "===================================");
		repairButtonLore.add(ChatColor.WHITE + "-Helmet: 4 ???          -Sword: 2 ???");
		repairButtonLore.add(ChatColor.WHITE + "-Chestplate: 7  ???     -Pickaxe: 2 ???");
		repairButtonLore.add(ChatColor.WHITE + "-Leggings: 6 ???        -Axe: 2 ???");
		repairButtonLore.add(ChatColor.WHITE + "-Boots: 3 ???           -Shovel: 1 ???");
		repairButtonLore.add(ChatColor.WHITE + "-Hoe: 1 ???             -Shield: 2 Iron");
		repairButtonLore.add(ChatColor.WHITE + "-Bow: 6 String          -Crossbow: 2 Iron");
		repairButtonLore.add(ChatColor.WHITE + "-Fishing Rod: 4 String");
		repairButtonMeta.setLore(repairButtonLore);

		repairButton.setItemMeta(repairButtonMeta);
		returnList.add(repairButton);

		// 13: fletching button
		ItemStack fletchButton = new ItemStack(Material.FLETCHING_TABLE);
		ItemMeta fletchButtonMeta = fletchButton.getItemMeta();
		fletchButtonMeta.setDisplayName(ChatColor.GREEN + "Craft Arrows");
		fletchButton.setItemMeta(fletchButtonMeta);
		returnList.add(fletchButton);

		// 14: arrow head slot
		ItemStack arrowHeadSlot = new ItemStack(Material.IRON_BARS);
		ItemMeta arrowHeadSlotMeta = arrowHeadSlot.getItemMeta();
		arrowHeadSlotMeta.setDisplayName(ChatColor.BLUE + "Place Arrow Head Here");
		arrowHeadSlot.setItemMeta(arrowHeadSlotMeta);
		returnList.add(arrowHeadSlot);

		// 15: arrow shaft slot
		ItemStack arrowShaftSlot = new ItemStack(Material.IRON_BARS);
		ItemMeta arrowShaftSlotMeta = arrowShaftSlot.getItemMeta();
		arrowShaftSlotMeta.setDisplayName(ChatColor.BLUE + "Place Stick Here");
		arrowShaftSlot.setItemMeta(arrowShaftSlotMeta);
		returnList.add(arrowShaftSlot);

		// 16: arrow feather slot
		ItemStack arrowFeatherSlot = new ItemStack(Material.IRON_BARS);
		ItemMeta arrowFeatherSlotMeta = arrowFeatherSlot.getItemMeta();
		arrowFeatherSlotMeta.setDisplayName(ChatColor.BLUE + "Place Feather Here");
		arrowFeatherSlot.setItemMeta(arrowFeatherSlotMeta);
		returnList.add(arrowFeatherSlot);

		// 17: arrow poison
		ItemStack poisonSlot = new ItemStack(Material.BOWL);
		ItemMeta poisonSlotMeta = poisonSlot.getItemMeta();
		poisonSlotMeta.setDisplayName(ChatColor.DARK_GREEN + "Place Poison Here");
		poisonSlot.setItemMeta(poisonSlotMeta);
		returnList.add(poisonSlot);

		// 18: place catalyst marker
		ItemStack catalystSlot = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
		ItemMeta catalystSlotMeta = catalystSlot.getItemMeta();
		catalystSlotMeta.setDisplayName(ChatColor.DARK_PURPLE + "Place Catalyst Here");
		catalystSlot.setItemMeta(catalystSlotMeta);
		returnList.add(catalystSlot);

		// 19: place material marker
		ItemStack materialSlot = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
		ItemMeta materialSlotMeta = materialSlot.getItemMeta();
		materialSlotMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Place Materials Here");
		materialSlot.setItemMeta(materialSlotMeta);
		returnList.add(materialSlot);

		// 20: craft upgradeable button
		ItemStack craftUpgradeButton = new ItemStack(Material.BEACON);
		ItemMeta craftUpgradeButtonMeta = craftUpgradeButton.getItemMeta();
		craftUpgradeButtonMeta.setDisplayName(ChatColor.AQUA + "Craft Upgradeable");
		craftUpgradeButton.setItemMeta(craftUpgradeButtonMeta);
		returnList.add(craftUpgradeButton);

		// 21: place mold marker
		ItemStack moldSlot = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
		ItemMeta moldSlotMeta = moldSlot.getItemMeta();
		moldSlotMeta.setDisplayName(ChatColor.BLUE + "Place Mold Here");
		moldSlot.setItemMeta(moldSlotMeta);
		returnList.add(moldSlot);

		// 22: Place Item Here
		ItemStack itemSlot = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta itemSlotMeta = itemSlot.getItemMeta();
		itemSlotMeta.setDisplayName(ChatColor.RED + "Place Item Here");
		itemSlot.setItemMeta(itemSlotMeta);
		returnList.add(itemSlot);

		// 23: Place Book Here
		ItemStack bookSlot = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
		ItemMeta bookSlotMeta = bookSlot.getItemMeta();
		bookSlotMeta.setDisplayName(ChatColor.BLUE + "Place Book Here");
		bookSlot.setItemMeta(bookSlotMeta);
		returnList.add(bookSlot);

		// 24: Enchant
		ItemStack enchantButton = new ItemStack(Material.ENCHANTING_TABLE);
		ItemMeta enchantButtonMeta = enchantButton.getItemMeta();
		enchantButtonMeta.setDisplayName(ChatColor.GREEN + "Enchant");
		enchantButton.setItemMeta(enchantButtonMeta);
		returnList.add(enchantButton);

		return returnList;
	}

}
