package us.newadventures.rewardingachievements.events;

import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.mineacademy.fo.Common;

public class FireworkListener implements Listener {

	@EventHandler
	public void negateFireworkDamage(EntityDamageByEntityEvent event) {
		Firework fw = (Firework) event.getDamager();
		if (fw.getCustomName().equals("nodamage")) {
			Common.log(fw.getCustomName());
			event.setCancelled(true);
		}
	}
}
