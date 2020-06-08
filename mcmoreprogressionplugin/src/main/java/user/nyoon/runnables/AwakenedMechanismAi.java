package user.nyoon.runnables;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.globaltimedevents.WorldBoss_AwakenedMechanism;
import user.nyoon.objectlists.Catalysts;
import user.nyoon.plugincore.PluginCore;

public class AwakenedMechanismAi extends BukkitRunnable implements Runnable {
	private int bossDropCountdown = 30;
	private int hpStage = 4;
	
	private final int stunAttackMaxCd = 15;
	private final int groundSlamMaxCd = 35;
	private final int shieldShatterMaxCd = 50;
	
	private int stunAttackCd = 15;
	private int groundSlamCd = 35;
	private int shieldShatterCd = 50;
	
	@Override
	public void run() {
		
		IronGolem boss = (IronGolem) PluginCore.getSpawnedBosses().get("AncientProtector");
		
		if (boss.isDead()) {
			
			if (bossDropCountdown == 0) {
				//Boss Drops
				
				//40% chance to drop either a power 6 or sharp 6 book
				if (PluginCore.randInt(100) > 60) {
					if (PluginCore.randInt(1) == 0) {
						ItemStack drop1 = new ItemStack(Material.ENCHANTED_BOOK);
						EnchantmentStorageMeta drop1Meta = (EnchantmentStorageMeta) drop1.getItemMeta();
						drop1Meta.addStoredEnchant(Enchantment.ARROW_DAMAGE, 6, true);
						drop1.setItemMeta(drop1Meta);
						
						WorldBoss_AwakenedMechanism.getWorld().dropItemNaturally(WorldBoss_AwakenedMechanism.getLocation(), drop1);
					} else {
						ItemStack drop1 = new ItemStack(Material.ENCHANTED_BOOK);
						EnchantmentStorageMeta drop1Meta = (EnchantmentStorageMeta) drop1.getItemMeta();
						drop1Meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 6, true);
						drop1.setItemMeta(drop1Meta);
						WorldBoss_AwakenedMechanism.getWorld().dropItemNaturally(WorldBoss_AwakenedMechanism.getLocation(), drop1);
					}
				}
				
				//50% chance to drop lv 6 atkdmg whetstone catalyst.
				if (PluginCore.randInt(1) == 0) {
					WorldBoss_AwakenedMechanism.getWorld().dropItemNaturally(WorldBoss_AwakenedMechanism.getLocation(), 
							PluginCore.getCatalysts().get("atkdmgws").get(5));
				}
				
				//drops 2 lv 6 defense whetstone catalysts.
				for (int x = 0; x < 2; x++) {
					if (PluginCore.randInt(1) == 0) {
						WorldBoss_AwakenedMechanism.getWorld().dropItemNaturally(WorldBoss_AwakenedMechanism.getLocation(), 
								PluginCore.getCatalysts().get("hppolish").get(5));
					} else {
						WorldBoss_AwakenedMechanism.getWorld().dropItemNaturally(WorldBoss_AwakenedMechanism.getLocation(), 
								PluginCore.getCatalysts().get("toughpolish").get(5));
					}
				}
				
				//drops 1 lv 1 skill gem catalyst.
				WorldBoss_AwakenedMechanism.getWorld().dropItemNaturally(WorldBoss_AwakenedMechanism.getLocation(), Catalysts.getRandomSkillGemCatalyst(1));
				
				this.cancel();
				return;
			} else if (bossDropCountdown == 30) {
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "The Ancient Protector has returned to his slumber and the spoils of"
						+ " his demise have started to materialize.");
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Boss Drops Falling On Boss' Spawn Platform In 30 Seconds.");
				bossDropCountdown--;
			} else {
				bossDropCountdown--;
				if (bossDropCountdown % 5 == 0) {
					Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Boss Drops Falling On Boss' Spawn Platform In " + bossDropCountdown + " Seconds.");
				} else if (bossDropCountdown < 5) {
					Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "" + bossDropCountdown);
				}
			}
		} else {

			List<Entity> nearby = boss.getNearbyEntities(6, 6, 6);
			if(!nearby.isEmpty()) {
				
				
				//execute ranged attack on closest player
				for (Entity x : nearby) {
					if (x instanceof Player) {
						boss.attack(x);
						break;
					}
				}
				
				if (stunAttackCd == 0) {
					//execute stun attack
					for (Entity x : nearby) {
						if (x instanceof Player) {
							Player enemy = (Player) x;
							enemy.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 5));
							enemy.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 5));
							enemy.sendMessage(ChatColor.DARK_RED + "You've been stunned!");
						}
					}
					stunAttackCd = stunAttackMaxCd;
				} else {
					stunAttackCd--;
				}
				
				if (groundSlamCd == 0) {
					for (Entity x : nearby) {
						if (x instanceof LivingEntity) {
							LivingEntity enemy = (LivingEntity) x;
							
							Location diff = enemy.getLocation().subtract(boss.getLocation());
							Vector normDiff = diff.toVector().normalize();
							Vector vectorVel = normDiff.multiply(1.5);
							enemy.setVelocity(vectorVel);
							enemy.sendMessage(ChatColor.DARK_RED + "Ancient Mechanism casted Groundslam!");
						}
					}
					
					groundSlamCd = groundSlamMaxCd;
				} else {
					groundSlamCd--;
				}
				
				if (shieldShatterCd == 0) {
					for (Entity x : nearby) {
						if (x instanceof Player) {
							Player enemy = (Player) x;
							
							enemy.setCooldown(Material.SHIELD, 200);
							enemy.sendMessage(ChatColor.DARK_RED + "Your shield has been temporarily broken!");
						}
					}
					
					shieldShatterCd = shieldShatterMaxCd;
				} else {
					shieldShatterCd--;
				}
			}
			
			if (boss.getHealth() < 5000 && hpStage == 4)  {
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Enraged Ancient Mechanism HP: 5000");
				hpStage--;
			} else if (boss.getHealth() < 4000 && hpStage == 3)  {
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Enraged Ancient Mechanism HP: 4000");
				hpStage--;
			} else if (boss.getHealth() < 3000 && hpStage == 2)  {
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Enraged Ancient Mechanism HP: 3000");
				hpStage--;
			} else if (boss.getHealth() < 2000 && hpStage == 1)  {
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Enraged Ancient Mechanism HP: 2000");
				hpStage--;
			} else if (boss.getHealth() < 1000 && hpStage == 1)  {
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Enraged Ancient Mechanism HP: 1000");
				hpStage--;
			}
		}
	}
}
