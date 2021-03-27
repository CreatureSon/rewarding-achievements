package us.newadventures.rewardingachievements.quests;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Quest {

	private static final Map<String, Quest> byName = new HashMap<>();

	private final String name;

	protected Quest(String name) {
		this.name = name;
		byName.put(name, this);
	}

	public abstract Quest getNext();

	public abstract CompMaterial getIcon();

	public abstract String[] getMenuLore();

	public abstract String getCompletion(Object completionData);

	public void onKill(final Player attacker, final LivingEntity target, final EntityDeathEvent event) {

	}

	public void onAttack(final Player attacker, final LivingEntity target, final EntityDamageByEntityEvent event) {

	}

	public void onDamaged(final LivingEntity attacker, final Player defender, final EntityDamageByEntityEvent event) {
		
	}

	public static Quest getByName(final String name) {
		return byName.get(name);
	}

	public static Collection<Quest> getQuests() {
		return Collections.unmodifiableCollection(byName.values());
	}

	public static Collection<String> getQuestNames() {
		return Collections.unmodifiableCollection(byName.keySet());
	}
}
