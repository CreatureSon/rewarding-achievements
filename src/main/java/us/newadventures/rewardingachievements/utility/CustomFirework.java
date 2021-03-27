package us.newadventures.rewardingachievements.utility;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class CustomFirework {

	public CustomFirework() {
	}

	public void spawnFirework(Location location, int amount, Color color) {
		Location loc = location.add(0, 2, 0);
		Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		FireworkMeta fwm = fw.getFireworkMeta();

		fwm.setPower(1);
		fwm.addEffect(FireworkEffect.builder().withColor(color).flicker(true).trail(true).build());

		for (int i = 0; i < amount; i++) {
			fw.setFireworkMeta(fwm);
			fw.setCustomName("nodamage");
			fw.detonate();
		}
	}
}
