package us.newadventures.rewardingachievements;

import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;
import us.newadventures.rewardingachievements.commands.ExchangeCommand;
import us.newadventures.rewardingachievements.events.FireworkListener;
import us.newadventures.rewardingachievements.settings.Configuration;

import java.util.Arrays;
import java.util.List;

public final class RewardingAchievements extends SimplePlugin {

	@Override
	protected void onPluginStart() {

		registerEvents(new FireworkListener());
		registerCommand(new ExchangeCommand());
	}

	@Override
	public List<Class<? extends YamlStaticConfig>> getSettings() {
		return Arrays.asList(Configuration.class);
	}
}
