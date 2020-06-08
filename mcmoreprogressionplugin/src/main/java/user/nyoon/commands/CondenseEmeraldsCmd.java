package user.nyoon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import user.nyoon.commonmethods.commonMethods;
import user.nyoon.objectlists.Currency;
import user.nyoon.plugincore.PluginCore;

/*
 * Command to condense emeralds into emerald blocks
 */

public class CondenseEmeraldsCmd implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			return true;
		}
		
		ItemStack[] playerItems = player.getInventory().getContents();
		int numEmeralds = 0;
		
		for (ItemStack x : playerItems) {
			if (x == null) {
				continue;
			}
			if (x.getItemMeta().getDisplayName().equals(PluginCore.getCurrencies().get(0).getItemMeta().getDisplayName())) {
				numEmeralds += x.getAmount();
				x.setAmount(0);
			}
		}
		
		
		int emeraldBlocks = numEmeralds / 64;
		numEmeralds = numEmeralds % 64;
			
		commonMethods.givePossibleOverflow(Currency.newCurrencyBlockStack(emeraldBlocks), player);
			
		commonMethods.givePossibleOverflow(Currency.newCurrencyStack(numEmeralds), player);
		return true;
	}
	
}
