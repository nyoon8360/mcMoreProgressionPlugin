package user.nyoon.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EnderPearlCooldown implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void ExtendCooldown(PlayerTeleportEvent event) {
		
		Player player = event.getPlayer();
		
		//assumes that enderpearls can only be thrown by players which is true unless through plugins
		//we dont have to check if player has cd since the launch event cant be fired if pearls are on cd
		if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
			player.setCooldown(Material.ENDER_PEARL, 800);
		}
	}
	
}
