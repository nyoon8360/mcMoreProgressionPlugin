package user.nyoon.globaltimedevents;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.plugincore.PluginCore;
import user.nyoon.runnables.AwakenedMechanismAi;

public class WorldBoss_AwakenedMechanism {
	final static World world = Bukkit.getWorlds().get(0);
	final static Location location = new Location(world, 1060, 65, 2165);
	
	@SuppressWarnings("deprecation")
	public static void StartEvent() {
		//announcement
		Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "The ground shakes as an ancient entity rises from its slumber.");
		
		//construct entity
		IronGolem entity = (IronGolem) world.spawnEntity(location, EntityType.IRON_GOLEM);
		entity.setCustomName("Enraged Ancient Protector");
		entity.setCustomNameVisible(true);
		entity.setMaxHealth(6000);
		entity.setHealth(6000);
		
		entity.setPlayerCreated(false);
		entity.setGlowing(true);
		entity.setPersistent(true);
		
		PluginCore.getSpawnedBosses().put("AncientProtector", entity);
		
		AwakenedMechanismAi bossAI = new AwakenedMechanismAi();
		bossAI.runTaskTimer(PluginCore.getPlugin(PluginCore.class), 0, 20);
	}
	
	public static World getWorld() {
		return world;
	}
	
	public static Location getLocation() {
		return location;
	}
}
