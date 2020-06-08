package user.nyoon.runnables;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.globaltimedevents.WorldBoss_AwakenedMechanism;
import user.nyoon.plugincore.PluginCore;

public class AutoEventTimer extends BukkitRunnable implements Runnable {
	//required num of people
	int requiredPlayers = 5;
	
	//max timers
	int wb_AwakenedMechanismTimerMax = 60;
	
	//current timers
	int wb_AwakenedMechanismTimer = 60;
	
	@Override
	public void run() {
		if (Bukkit.getServer().getOnlinePlayers().size() >= requiredPlayers) {
			System.out.println("Event Timer Ticked!");
			
			if (!(PluginCore.getSpawnedBosses().get("AncientProtector").isDead()) || PluginCore.getSpawnedBosses().get("AncientProtector") == null) {
				System.out.println("Awakened Mechanism is still Alive!");
				wb_AwakenedMechanismTimer--;
			}
			
			if (wb_AwakenedMechanismTimer == 5) {
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "A mysterious energy seems to surround 1060, 65, 2165.");
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "An event there seems to be eminent in 5 minutes.");
			}
			
			if (wb_AwakenedMechanismTimer == 0) {
				WorldBoss_AwakenedMechanism.StartEvent();
				wb_AwakenedMechanismTimer = wb_AwakenedMechanismTimerMax;
			}
		}
	}
}
