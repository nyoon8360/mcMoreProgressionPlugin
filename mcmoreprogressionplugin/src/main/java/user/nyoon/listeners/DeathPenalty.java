package user.nyoon.listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class DeathPenalty implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Inventory inventory = event.getEntity().getInventory();
		event.setKeepInventory(true);
		event.setKeepLevel(false);
		
		//populte itemsToKeep
		
		
		for (ItemStack x : inventory) {
			if (x == null || x.getType().equals(Material.AIR)) {
				continue;
			}
			
			String type = x.getType().toString();
			
			if (type.contains("SWORD") || type.contains("AXE") || type.contains("HELMET") || type.contains("CHESTPLATE") || type.contains("LEGGINGS")
					 || type.contains("BOOTS") || type.contains("BOW")) {
				
			} else {
				event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), x);
				x.setAmount(0);
			}
		}
		
		ItemStack[] equips = event.getEntity().getInventory().getArmorContents();
		
		for (ItemStack item : equips) {
			if (item == null) {
				continue;
			}
			
			ItemMeta tempMeta = item.getItemMeta();
			Damageable tempDmgMeta = (Damageable) tempMeta;
			
			if (item.getType().getMaxDurability() > 1) {
				int max = item.getType().getMaxDurability();
				int dmgDone = max/8;
				
				if (item.getType().getMaxDurability() - (tempDmgMeta.getDamage() + dmgDone) < 1) {
					tempDmgMeta.setDamage(item.getType().getMaxDurability() - 1);
					item.setItemMeta(tempMeta);
				} else {
					tempDmgMeta.setDamage(tempDmgMeta.getDamage() + dmgDone);
					item.setItemMeta(tempMeta);
				}
			}
		}
	}
}
