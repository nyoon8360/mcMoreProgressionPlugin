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

public class DecondenseEmeraldsCmd implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			return true;
		}
		
		ItemStack itemInHand = player.getInventory().getItemInMainHand();
		
		if (itemInHand != null && itemInHand.hasItemMeta() && itemInHand.getItemMeta().getDisplayName().equals(PluginCore.getCurrencies().get(1).getItemMeta().getDisplayName())) {
			int numBlocks = itemInHand.getAmount();
			itemInHand.setAmount(0);
			
			for (int x = 0; x < numBlocks; x ++) {
				commonMethods.givePossibleOverflow(Currency.newCurrencyStack(64), player);
			}
		}
		
		return true;
	}
	
}
