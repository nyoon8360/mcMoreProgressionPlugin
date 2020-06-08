package user.nyoon.objectlists;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UpgradeableEquips {
	public static HashMap<Material, ItemStack> popUpgradeables() {
		// hashmap to return
		HashMap<Material, ItemStack> returnMap = new HashMap<>();

		// Helmet Recipes
		// ==================================================================================
		ItemStack iHelm = new ItemStack(Material.IRON_HELMET);
		ItemMeta iHelmMeta = iHelm.getItemMeta();
		AttributeModifier iHelmMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 2,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		iHelmMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, iHelmMetaMod);
		iHelm.setItemMeta(iHelmMeta);
		returnMap.put(Material.IRON_HELMET, iHelm);

		ItemStack gHelm = new ItemStack(Material.GOLDEN_HELMET);
		ItemMeta gHelmMeta = gHelm.getItemMeta();
		AttributeModifier gHelmMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 2,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		gHelmMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, gHelmMetaMod);
		gHelm.setItemMeta(gHelmMeta);
		returnMap.put(Material.GOLDEN_HELMET, gHelm);

		ItemStack dHelm = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta dHelmMeta = dHelm.getItemMeta();
		AttributeModifier dHelmMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 3,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		AttributeModifier dHelmMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", 2,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		dHelmMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, dHelmMetaMod);
		dHelmMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, dHelmMetaMod2);
		dHelm.setItemMeta(dHelmMeta);
		returnMap.put(Material.DIAMOND_HELMET, dHelm);

		// Chestplate Recipes
		// ===============================================================================
		ItemStack iChestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta iChestplateMeta = iChestplate.getItemMeta();
		AttributeModifier iChestplateMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 6,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		iChestplateMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, iChestplateMetaMod);
		iChestplate.setItemMeta(iChestplateMeta);
		returnMap.put(Material.IRON_CHESTPLATE, iChestplate);

		ItemStack gChestplate = new ItemStack(Material.GOLDEN_CHESTPLATE);
		ItemMeta gChestplateMeta = gChestplate.getItemMeta();
		AttributeModifier gChestplateMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 5,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		gChestplateMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, gChestplateMetaMod);
		gChestplate.setItemMeta(gChestplateMeta);
		returnMap.put(Material.GOLDEN_CHESTPLATE, gChestplate);

		ItemStack dChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta dChestplateMeta = dChestplate.getItemMeta();
		AttributeModifier dChestplateMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 8,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		AttributeModifier dChestplateMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", 2,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		dChestplateMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, dChestplateMetaMod);
		dChestplateMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, dChestplateMetaMod2);
		dChestplate.setItemMeta(dChestplateMeta);
		returnMap.put(Material.DIAMOND_CHESTPLATE, dChestplate);

		// Legging Recipes
		// =================================================================================
		ItemStack iLeggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta iLeggingsMeta = iLeggings.getItemMeta();
		AttributeModifier iLeggingsMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 5,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		iLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, iLeggingsMetaMod);
		iLeggings.setItemMeta(iLeggingsMeta);
		returnMap.put(Material.IRON_LEGGINGS, iLeggings);

		ItemStack gLeggings = new ItemStack(Material.GOLDEN_LEGGINGS);
		ItemMeta gLeggingsMeta = gLeggings.getItemMeta();
		AttributeModifier gLeggingsMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 3,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		gLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, gLeggingsMetaMod);
		gLeggings.setItemMeta(gLeggingsMeta);
		returnMap.put(Material.GOLDEN_LEGGINGS, gLeggings);

		ItemStack dLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta dLeggingsMeta = dLeggings.getItemMeta();
		AttributeModifier dLeggingsMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 6,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		AttributeModifier dLeggingsMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", 2,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
		dLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, dLeggingsMetaMod);
		dLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, dLeggingsMetaMod2);
		dLeggings.setItemMeta(dLeggingsMeta);
		returnMap.put(Material.DIAMOND_LEGGINGS, dLeggings);

		// Boots Recipes
		// ===================================================================================
		ItemStack iBoots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta iBootsMeta = iBoots.getItemMeta();
		AttributeModifier iBootsMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 2,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
		iBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, iBootsMetaMod);
		iBoots.setItemMeta(iBootsMeta);
		returnMap.put(Material.IRON_BOOTS, iBoots);

		ItemStack gBoots = new ItemStack(Material.GOLDEN_BOOTS);
		ItemMeta gBootsMeta = gBoots.getItemMeta();
		AttributeModifier gBootsMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 1,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
		gBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, gBootsMetaMod);
		gBoots.setItemMeta(gBootsMeta);
		returnMap.put(Material.GOLDEN_BOOTS, gBoots);

		ItemStack dBoots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta dBootsMeta = dBoots.getItemMeta();
		AttributeModifier dBootsMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 3,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
		AttributeModifier dBootsMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", 2,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
		dBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, dBootsMetaMod);
		dBootsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, dBootsMetaMod2);
		dBoots.setItemMeta(dBootsMeta);
		returnMap.put(Material.DIAMOND_BOOTS, dBoots);

		// Sword Recipes
		// ==================================================================================
		ItemStack iSword = new ItemStack(Material.IRON_SWORD);
		ItemMeta iSwordMeta = iSword.getItemMeta();
		AttributeModifier iSwordMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 6,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier iSwordMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", -2.4,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		iSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iSwordMetaMod);
		iSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, iSwordMetaMod2);
		iSword.setItemMeta(iSwordMeta);
		returnMap.put(Material.IRON_SWORD, iSword);

		ItemStack gSword = new ItemStack(Material.GOLDEN_SWORD);
		ItemMeta gSwordMeta = gSword.getItemMeta();
		AttributeModifier gSwordMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 4,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier gSwordMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", -2.4,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		gSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, gSwordMetaMod);
		gSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, gSwordMetaMod2);
		gSword.setItemMeta(gSwordMeta);
		returnMap.put(Material.GOLDEN_SWORD, gSword);

		ItemStack dSword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta dSwordMeta = dSword.getItemMeta();
		AttributeModifier dSwordMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 7,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier dSwordMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", -2.4,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		dSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, dSwordMetaMod);
		dSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, dSwordMetaMod2);
		dSword.setItemMeta(dSwordMeta);
		returnMap.put(Material.DIAMOND_SWORD, dSword);
		
		// Axe Recipes
		// =================================================================================
		ItemStack iAxe = new ItemStack(Material.IRON_AXE);
		ItemMeta iAxeMeta = iAxe.getItemMeta();
		AttributeModifier iAxeMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 9,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier iAxeMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", -3.1,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		iAxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iAxeMetaMod);
		iAxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, iAxeMetaMod2);
		iAxe.setItemMeta(iAxeMeta);
		returnMap.put(Material.IRON_AXE, iAxe);

		ItemStack gAxe = new ItemStack(Material.GOLDEN_AXE);
		ItemMeta gAxeMeta = gAxe.getItemMeta();
		AttributeModifier gAxeMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 7,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier gAxeMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", -3.1,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		gAxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, gAxeMetaMod);
		gAxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, gAxeMetaMod2);
		gAxe.setItemMeta(gAxeMeta);
		returnMap.put(Material.GOLDEN_AXE, gAxe);
		
		ItemStack dAxe = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta dAxeMeta = dAxe.getItemMeta();
		AttributeModifier dAxeMetaMod = new AttributeModifier(UUID.randomUUID(), "test", 9,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier dAxeMetaMod2 = new AttributeModifier(UUID.randomUUID(), "test", -3.1,
				AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		dAxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, dAxeMetaMod);
		dAxeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, dAxeMetaMod2);
		dAxe.setItemMeta(dAxeMeta);
		returnMap.put(Material.DIAMOND_AXE, dAxe);

		return returnMap;
	}
}
