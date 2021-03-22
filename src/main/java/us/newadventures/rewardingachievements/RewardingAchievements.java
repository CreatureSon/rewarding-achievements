package us.newadventures.rewardingachievements;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import us.newadventures.rewardingachievements.commands.ExchangeCommand;
import us.newadventures.rewardingachievements.events.FireworkListener;

public final class RewardingAchievements extends SimplePlugin {

	@Override
	protected void onPluginStart() {

		registerEvents(new FireworkListener());
		registerCommand(new ExchangeCommand());
	}

	@EventHandler
	public void onJoin(final PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Common.tell(player, "Hello, " + player.getName());
	}

}
