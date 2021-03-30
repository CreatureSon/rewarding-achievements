package us.newadventures.rewardingachievements.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.Common;
import us.newadventures.rewardingachievements.database.PlayerData;
import us.newadventures.rewardingachievements.database.RADatabases;

import java.util.UUID;

public class DatabaseListener implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onJoin(final AsyncPlayerPreLoginEvent event) {
		final UUID uuid = event.getUniqueId();

		if (event.getLoginResult() == AsyncPlayerPreLoginEvent.Result.ALLOWED) {
			final PlayerData playerData = PlayerData.getData(uuid);

			RADatabases.getInstance().load(uuid, playerData);
		}

	}

	@EventHandler
	public void onLeave(final PlayerQuitEvent event) {
		final Player player = event.getPlayer();
		final PlayerData playerData = PlayerData.getData(player);

		Common.runLaterAsync(() -> RADatabases.getInstance().save(player.getName(), player.getUniqueId(), playerData));
	}
}
