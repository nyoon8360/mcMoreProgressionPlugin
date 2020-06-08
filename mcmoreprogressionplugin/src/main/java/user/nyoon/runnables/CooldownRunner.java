package user.nyoon.runnables;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.scheduler.BukkitRunnable;

import user.nyoon.plugincore.PluginCore;

public class CooldownRunner extends BukkitRunnable implements Runnable {
	
	@Override
	public void run() {
		//go through all cd hashmaps and reduce cds by 1 second
		for (HashMap<UUID, Integer> cdMap : PluginCore.getCDMaps()) {
			//if hashmap is empty then return
			if (cdMap.isEmpty()) {
				return;
			}
			
			//go through all cds and subtract cooldown by 1 or remove completely if no cd left.
			for (UUID uuid : cdMap.keySet()) {
				
				int cooldown = cdMap.get(uuid);
				if (cooldown > 1) {
					cdMap.remove(uuid);
					cdMap.put(uuid, cooldown - 1);
				} else {
					cdMap.remove(uuid);
				}
			}
		}
	}
}
