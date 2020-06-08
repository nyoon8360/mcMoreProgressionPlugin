package user.nyoon.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;

public class KillCartographers implements Listener {
	
    @EventHandler
    public void craftItem(VillagerAcquireTradeEvent event) throws NullPointerException, EventException {
    	if (((Villager)event.getEntity()).getProfession().equals(Villager.Profession.CARTOGRAPHER)) {
    		event.getEntity().remove();
    		Bukkit.broadcastMessage("A cartographer villager tried leveling up and was immediately killed. Don't level cartographers >:(");
    	}
    }
}
