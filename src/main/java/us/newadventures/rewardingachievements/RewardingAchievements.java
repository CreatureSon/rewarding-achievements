package us.newadventures.rewardingachievements;

import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.debug.LagCatcher;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;
import us.newadventures.rewardingachievements.commands.CommandGroup;
import us.newadventures.rewardingachievements.database.RADatabases;
import us.newadventures.rewardingachievements.events.DatabaseListener;
import us.newadventures.rewardingachievements.events.FireworkListener;
import us.newadventures.rewardingachievements.settings.Configuration;

import java.util.Arrays;
import java.util.List;

public final class RewardingAchievements extends SimplePlugin {

	private final SimpleCommandGroup mainCommandGroup = new CommandGroup();

	@Override
	protected void onPluginStart() {

		LagCatcher.start("mysql");
		RADatabases.getInstance().connect("na02-db.cus.mc-panel.net", 3306, "db_74440", "db_74440", "5b067ec644", "RADatabase");
		LagCatcher.end("mysql", 0, "Connected to MySQL database.  Took {time} ms.");

		registerEvents(new FireworkListener());
		registerEvents(new DatabaseListener());
	}

	@Override
	public List<Class<? extends YamlStaticConfig>> getSettings() {
		return Arrays.asList(Configuration.class);
	}

	@Override
	public SimpleCommandGroup getMainCommand() {
		return mainCommandGroup;
	}
}
