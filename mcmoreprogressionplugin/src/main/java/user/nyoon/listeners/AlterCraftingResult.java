package user.nyoon.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import user.nyoon.commonmethods.commonMethods;
import user.nyoon.plugincore.PluginCore;

public class AlterCraftingResult implements Listener {
	
    @EventHandler
    public void craftItem(PrepareItemCraftEvent e) throws NullPointerException, EventException {
    	//null check
    	if (e.getRecipe() == null || e.getRecipe().getResult() == null) {
    		return;
    	}
    	
    	//get result of craft
        Material itemType = e.getRecipe().getResult().getType();
        
        //check hashmap for result of craft
        ItemStack newResult = PluginCore.getUpgradeables().get(itemType);
        //if result is in hashmap, convert it to upgradeable type
        if (newResult != null) {
        	
        	if (newResult.getType().toString().contains("SWORD") || newResult.getType().toString().contains("AXE")) {
        		commonMethods.applyBasicStatsAndGem(newResult, 3, 0);
        	} else {
        		commonMethods.applyBasicStats(newResult, 3, 0);
        	}
        	
        	e.getInventory().setResult(newResult);
        } else if (itemType.equals(Material.BOW) || itemType.equals(Material.CROSSBOW)){
        	ItemStack newRangedResult = new ItemStack(itemType);
        	ItemMeta tempMeta = newRangedResult.getItemMeta();
    		ArrayList<String> tempLore = new ArrayList<>();
    		tempLore.add(ChatColor.GOLD + "Gem Slot: (empty)");
    		tempMeta.setLore(tempLore);
    		newRangedResult.setItemMeta(tempMeta);
    		
    		e.getInventory().setResult(newRangedResult);
        } else if (itemType.equals(Material.CARTOGRAPHY_TABLE)) {
        	e.getView().getPlayer().sendMessage(ChatColor.RED + "Cartography tables are disabled!");
        	
        	e.getInventory().setResult(new ItemStack(Material.DIRT));
        }
        
        ItemStack[] ingredients = e.getInventory().getMatrix();
        
        if (ingredients.length == 0 || ingredients == null) {
        	return;
        }
        
        
        for (ItemStack x : ingredients) {
        	if (x != null) {
        		if (x.hasItemMeta()) {
            		if (x.getItemMeta().hasDisplayName()) {
                		e.getInventory().setResult(new ItemStack(Material.AIR));
                		e.getView().getPlayer().sendMessage(ChatColor.RED + "You can't craft with custom named items!");
                		break;
                	}
            	}
        	}
        }
        
    }
}
