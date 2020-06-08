package user.nyoon.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Survival implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				player.setGameMode(GameMode.SURVIVAL);
			}
			
			
		return true;
	}

}
