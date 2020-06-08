package user.nyoon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import user.nyoon.globaltimedevents.WorldBoss_AwakenedMechanism;

public class TestCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				if(player.getDisplayName().equals("Inspirasian")) {
					WorldBoss_AwakenedMechanism.StartEvent();
				} else {
					player.sendMessage("You don't have permission to use this command!");
				}
				
			}
			
			
		return true;
	}

}
