package user.nyoon.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class InstantHealthPotion implements Listener {
	@EventHandler
	public void hpPots(PlayerInteractEvent e) {
		Action action = e.getAction();
		
		if (action.equals(Action.RIGHT_CLICK_AIR)) {
			ItemStack itemInHand = e.getPlayer().getInventory().getItemInMainHand();
			
			if (itemInHand.getType().equals(Material.POTION)) {
				PotionMeta pMeta = (PotionMeta) itemInHand.getItemMeta();
				if(pMeta.getBasePotionData().getType().equals(PotionType.INSTANT_HEAL)) {
					if (pMeta.getBasePotionData().isUpgraded()) {
						e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
						PotionEffect heal = new PotionEffect(PotionEffectType.HEAL, 1, 1);
						e.getPlayer().addPotionEffect(heal);
					} else {
						e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
						PotionEffect heal = new PotionEffect(PotionEffectType.HEAL, 1, 0);
						e.getPlayer().addPotionEffect(heal);
					}
					
				}
			} else {
				return;
			}
		}
	}
}
