package user.nyoon.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import user.nyoon.commonmethods.commonMethods;
import user.nyoon.plugincore.PluginCore;

/*
 * Command to give player custom items in a specified category (for admin use only). Hard coded my username in as requirement.
 */

public class CustomItemCmd implements CommandExecutor{
	
	//run when command is used
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (player.getDisplayName().equals("Inspirasian")) {
				
				if (args.length != 0) {
					
					ArrayList<ItemStack> giveItems = new ArrayList<>();
					
					
					switch (args[0]) {
					
					case "materials":
						giveItems = PluginCore.getMaterials();
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						break;
						
					case "whetstones":
						
						giveItems = PluginCore.getWhetstones().get("atkdmg");
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						giveItems = PluginCore.getWhetstones().get("atkspd");
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						break;
					
					case "polishes":
						giveItems = PluginCore.getPolishes().get("hp");
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						giveItems = PluginCore.getPolishes().get("tough");
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						break;
						
					case "recipes":
						giveItems = PluginCore.getRecipes();
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						break;
						
					case "usables":
						giveItems = PluginCore.getUsables();
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						break;
						
					case "molds":
						giveItems = PluginCore.getMolds();					
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						break;
						
					case "catalysts":
						HashMap<String, ArrayList<ItemStack>> giveMap = PluginCore.getCatalysts();
						for (String x : giveMap.keySet()) {
							giveItems = giveMap.get(x);
							
							for (ItemStack y : giveItems) {
								commonMethods.givePossibleOverflow(y, player);
							}
							
						}
						
						break;
						
					case "currency":
						
						giveItems = PluginCore.getCurrencies();
						for (ItemStack x : giveItems) {
							commonMethods.givePossibleOverflow(x, player);
						}
						break;
						
					default:
						player.sendMessage(ChatColor.RED + "That category does not exist!");
						break;
					}
				}
				
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "You do not have access to this command!");
			}
		}
		return false;
	}
	
}
