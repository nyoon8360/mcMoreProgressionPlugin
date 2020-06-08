package user.nyoon.mobdrops;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import user.nyoon.objectlists.Currency;
import user.nyoon.plugincore.PluginCore;

/*
 * Class that handles mob drops of custom mobs
 * KEEP IN MIND TO ENSURE ARRAYLIST.ADD(INDEX) IS CORRECT
 * 
 */

public class MobDrops implements Listener {
	
	@EventHandler
	public static void onDeath(EntityDeathEvent e) {
		ArrayList<EntityType> lv1wspolish = new ArrayList<>();
		ArrayList<EntityType> lv2wspolish = new ArrayList<>();
		ArrayList<EntityType> lv3wspolish = new ArrayList<>();
		ArrayList<EntityType> lv4wspolish = new ArrayList<>();
		ArrayList<EntityType> lv5wspolish = new ArrayList<>();
		
		//drop chances in %
		int lv1 = 3;
		int lv2 = 5;
		int lv3 = 4;
		int lv4 = 5;
		int lv5 = 50;
		
		EntityType deadEntityType = e.getEntityType();
		World entityWorld = e.getEntity().getWorld();
		Location entityLoc = e.getEntity().getLocation();
		
		//populate lv 1 drop mobs
		lv1wspolish.add(EntityType.ZOMBIE);
		lv1wspolish.add(EntityType.ZOMBIE_VILLAGER);
		lv1wspolish.add(EntityType.SKELETON);
		lv1wspolish.add(EntityType.SPIDER);
		lv1wspolish.add(EntityType.DROWNED);
		lv1wspolish.add(EntityType.HUSK);
		
		//populate lv 2 drop mobs
		lv2wspolish.add(EntityType.CREEPER);
		lv2wspolish.add(EntityType.PILLAGER);
		lv2wspolish.add(EntityType.STRAY);
		lv2wspolish.add(EntityType.VINDICATOR);
		lv2wspolish.add(EntityType.WITCH);
		
		//populate lv 3 drop mobs
		lv3wspolish.add(EntityType.PIG_ZOMBIE);
		lv3wspolish.add(EntityType.GHAST);
		lv3wspolish.add(EntityType.WITHER_SKELETON);
		lv3wspolish.add(EntityType.BLAZE);
		
		//populate lv 4 drop mobs
		lv4wspolish.add(EntityType.ENDERMAN);
		lv4wspolish.add(EntityType.RAVAGER);
		lv4wspolish.add(EntityType.SHULKER);
		
		//populate lv 5 drop mobs
		lv5wspolish.add(EntityType.EVOKER);
		lv5wspolish.add(EntityType.WITHER);
		
		
		
		if (lv1wspolish.contains(deadEntityType)) {
			
			//3 % chance
			if (PluginCore.randInt(100) >= (101 - lv1)) {
				int chooser = PluginCore.randInt(3);
				ItemStack item = PluginCore.getCatalysts().get("atkspdws").get(0);
				switch(chooser) {
				
				case 0:
					
					item = PluginCore.getCatalysts().get("atkspdws").get(0);
					
					break;
					
				case 1:
					
					item = PluginCore.getCatalysts().get("atkdmgws").get(0);
					
					break;
				
				case 2:
					
					item = PluginCore.getCatalysts().get("hppolish").get(0);
					
					break;
					
				case 3:
					
					item = PluginCore.getCatalysts().get("toughpolish").get(0);
					
					break;
					
				}
				entityWorld.dropItemNaturally(entityLoc, item);
			}
			
			//3% chance for traveler boots recipe
			if (PluginCore.randInt(100) >= 98) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(2));
			}
			
			//2% chance for saddle recipe
			if (PluginCore.randInt(100) >= 99) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(0));
			}
			
			//2% chance for shield+1 recipe
			if (PluginCore.randInt(100) >= 99) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(3));
			}
			
		} else if (lv2wspolish.contains(deadEntityType)) {
			//5 % chance
			if (PluginCore.randInt(100) >= (101 - lv2)) {
				int chooser = PluginCore.randInt(3);
				ItemStack item = PluginCore.getCatalysts().get("atkspdws").get(1);
				switch(chooser) {
				
				case 0:
					
					item = PluginCore.getCatalysts().get("atkspdws").get(1);
					
					break;
					
				case 1:
					
					item = PluginCore.getCatalysts().get("atkdmgws").get(1);
					
					break;
				
				case 2:
					
					item = PluginCore.getCatalysts().get("hppolish").get(1);
					
					break;
					
				case 3:
					
					item = PluginCore.getCatalysts().get("toughpolish").get(1);
					
					break;
					
				}
				entityWorld.dropItemNaturally(entityLoc, item);
				
			}
			
			//emerald drops
			if (deadEntityType.equals(EntityType.PILLAGER)) {
				//4% chance for woodcutter's axe
				if (PluginCore.randInt(100) >= 97) {
					entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(6));
				}
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(PluginCore.randInt(4)));
			} else if (deadEntityType.equals(EntityType.VINDICATOR)) {
				//4% chance for woodcutter's axe
				if (PluginCore.randInt(100) >= 97) {
					entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(6));
				}
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(PluginCore.randInt(4)));
			}
			
			//3% chance for traveler boots recipe
			if (PluginCore.randInt(100) >= 98) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(2));
			}
			
			//2% chance for saddle recipe
			if (PluginCore.randInt(100) >= 99) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(0));
			}
			
			//2% chance for shield+1 recipe
			if (PluginCore.randInt(100) >= 99) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(3));
			}
			
		} else if (lv3wspolish.contains(deadEntityType)) {
			//3 % chance
			if (PluginCore.randInt(100) >= (101 - lv3)) {
				int chooser = PluginCore.randInt(3);
				ItemStack item = PluginCore.getCatalysts().get("atkspdws").get(2);
				switch(chooser) {
				
				case 0:
					
					item = PluginCore.getCatalysts().get("atkspdws").get(2);
					
					break;
					
				case 1:
					
					item = PluginCore.getCatalysts().get("atkdmgws").get(2);
					
					break;
				
				case 2:
					
					item = PluginCore.getCatalysts().get("hppolish").get(2);
					
					break;
					
				case 3:
					
					item = PluginCore.getCatalysts().get("toughpolish").get(2);
					
					break;
					
				}
				entityWorld.dropItemNaturally(entityLoc, item);
				
			}
			
			if (deadEntityType.equals(EntityType.GHAST)) {
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(PluginCore.randInt(10)));
			} else if (deadEntityType.equals(EntityType.WITHER_SKELETON)) {
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(PluginCore.randInt(6)));
			}
			
			//2% chance for shield+2 recipe
			if (PluginCore.randInt(100) >= 99) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(4));
			}
		} else if (lv4wspolish.contains(deadEntityType)) {
			//3 % chance
			if (PluginCore.randInt(100) >= (101 - lv4)) {
				int chooser = PluginCore.randInt(3);
				ItemStack item = PluginCore.getCatalysts().get("atkspdws").get(3);
				switch(chooser) {
				
				case 0:
					
					item = PluginCore.getCatalysts().get("atkspdws").get(3);
					
					break;
					
				case 1:
					
					item = PluginCore.getCatalysts().get("atkdmgws").get(3);
					
					break;
				
				case 2:
					
					item = PluginCore.getCatalysts().get("hppolish").get(3);
					
					break;
					
				case 3:
					
					item = PluginCore.getCatalysts().get("toughpolish").get(3);
					
					break;
					
				}
				entityWorld.dropItemNaturally(entityLoc, item);
				

				
			}
			
			if (deadEntityType.equals(EntityType.RAVAGER)) {
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(PluginCore.randInt(18)));
			} else if (deadEntityType.equals(EntityType.SHULKER)) {
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(PluginCore.randInt(8)));
			}
			
			//2% chance for shield+3 recipe
			if (PluginCore.randInt(100) >= 99) {
				entityWorld.dropItemNaturally(entityLoc, PluginCore.getRecipes().get(5));
			}
		} else if (lv5wspolish.contains(deadEntityType)) {
			//3 % chance
			if (PluginCore.randInt(100) >= (101 - lv5)) {
				int chooser = PluginCore.randInt(3);
				ItemStack item = PluginCore.getCatalysts().get("atkspdws").get(4);
				switch(chooser) {
				
				case 0:
					
					item = PluginCore.getCatalysts().get("atkspdws").get(4);
					
					break;
					
				case 1:
					
					item = PluginCore.getCatalysts().get("atkdmgws").get(4);
					
					break;
				
				case 2:
					
					item = PluginCore.getCatalysts().get("hppolish").get(4);
					
					break;
					
				case 3:
					
					item = PluginCore.getCatalysts().get("toughpolish").get(4);
					
					break;
					
				}
				entityWorld.dropItemNaturally(entityLoc, item);
				

				
			}
			if (deadEntityType.equals(EntityType.WITHER)) {
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(40 + PluginCore.randInt(24)));
			} else if (deadEntityType.equals(EntityType.EVOKER)) {
				entityWorld.dropItemNaturally(entityLoc, Currency.newCurrencyStack(10 + PluginCore.randInt(20)));
			}
		}
		
	}
}
