package user.nyoon.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.plugincore.PluginCore;

/*
 * Class that handles what happens when player uses a custom usable item and prevents users from placing custom blocks that shouldnt be placeable.
 */

public class UsablesEvent implements Listener {
	
	@EventHandler
	public static void onUse(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			Player player = e.getPlayer();
			
			//if nothing in hand, return and exit execution
			if (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() == Material.AIR) {
				return;
			}
			
			//if item doesnt have a custom display name, return and exit execution
			if (!player.getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
				return;
			}
			
			//get display name of item
			String itemString = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
			
			//cancel placement of enchanted emerald blocks
			if (itemString.contains("Enchanted Emerald Bl")) {
				e.setCancelled(true);
			}
			
			//switch statement handling execution of code depending on custom item used.
			switch(itemString) {
			
			case "Stun Bomb":
				
				//check if bombs on cooldown and if so, send message and end code execution.
				if (PluginCore.bombCds.keySet().contains(player.getUniqueId())) {
					player.sendMessage(ChatColor.RED + "Bombs are on cooldown for another " + PluginCore.bombCds.get(player.getUniqueId()) + " seconds!");
					break;
				}
				
				//remove 1 bomb from hand
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				
				//play sound effect
				player.playSound(player.getLocation(), Sound.BLOCK_BARREL_OPEN, 1, 1);
				
				//apply effects to all entities around player
				for (Entity x : player.getNearbyEntities(10, 6, 10)) {
					if (x instanceof LivingEntity) {
						LivingEntity enemy = (LivingEntity) x;
						enemy.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 5));
						enemy.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 5));
					}
				}
				
				//apply cooldown to bombs
				PluginCore.bombCds.put(player.getUniqueId(), PluginCore.bombCDTime);
				
				break;
				
			case "Slow Bomb":
				
				//check if bombs on cooldown and if so, send message and end code execution.
				if (PluginCore.bombCds.keySet().contains(player.getUniqueId())) {
					player.sendMessage(ChatColor.RED + "Bombs are on cooldown for another " + PluginCore.bombCds.get(player.getUniqueId()) + " seconds!");
					break;
				}
				
				//remove 1 bomb from hand
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				
				//play sound effect
				player.playSound(player.getLocation(), Sound.BLOCK_BARREL_OPEN, 1, 1);
				
				//apply effects to all nearby entities
				for (Entity x : player.getNearbyEntities(10, 6, 10)) {
					if (x instanceof LivingEntity) {
						LivingEntity enemy = (LivingEntity) x;
						enemy.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
					}
				}
				
				//apply cooldown to bombs
				PluginCore.bombCds.put(player.getUniqueId(), PluginCore.bombCDTime);
				
				break;
				
			case "Weaken Bomb":
				
				//check if bombs on cooldown and if so, send message and end code execution.
				if (PluginCore.bombCds.keySet().contains(player.getUniqueId())) {
					player.sendMessage(ChatColor.RED + "Bombs are on cooldown for another " + PluginCore.bombCds.get(player.getUniqueId()) + " seconds!");
					break;
				}
				
				//remove 1 bomb from hand
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				
				//play sound effect
				player.playSound(player.getLocation(), Sound.BLOCK_BARREL_OPEN, 1, 1);
				
				//apply effects to all nearby entities
				for (Entity x : player.getNearbyEntities(10, 6, 10)) {
					if (x instanceof LivingEntity) {
						LivingEntity enemy = (LivingEntity) x;
						enemy.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 1));
					}
				}
				
				//apply cooldown to bombs
				PluginCore.bombCds.put(player.getUniqueId(), PluginCore.bombCDTime);
				
				break;
			}
			
			
		}
	}
}
