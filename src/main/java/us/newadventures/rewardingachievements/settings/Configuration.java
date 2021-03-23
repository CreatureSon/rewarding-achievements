package us.newadventures.rewardingachievements.settings;

import org.mineacademy.fo.settings.SimpleSettings;

public class Configuration extends SimpleSettings {

	public static String REWARD_ITEMS;

	private static void init() {
		REWARD_ITEMS = getString("rewards.blocks.1.item").toUpperCase();
	}

	@Override
	protected int getConfigVersion() {
		return 1;
	}

	@Override
	protected void preLoad() {
		pathPrefix(null);

		if ((VERSION = getInteger("version")) != getConfigVersion())
			set("version", getConfigVersion());
	}

	@Override
	protected String getSettingsFileName() {
		return "config.yml";
	}
}
