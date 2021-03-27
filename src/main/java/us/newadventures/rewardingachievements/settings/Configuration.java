package us.newadventures.rewardingachievements.settings;

import org.bukkit.Material;
import org.mineacademy.fo.settings.SimpleSettings;

public class Configuration extends SimpleSettings {

	public static Material DIRT_EXCHANGE;
	public static Integer DIRT_EXCHANGE_COUNT;
	public static Material HONEY_EXCHANGE;
	public static Integer HONEY_EXCHANGE_COUNT;

	private static void init() {

		pathPrefix("rewards");

		DIRT_EXCHANGE = getMaterial("1.item").getMaterial();
		DIRT_EXCHANGE_COUNT = getInteger("1.count");
		HONEY_EXCHANGE = getMaterial("2.item").getMaterial();
		HONEY_EXCHANGE_COUNT = getInteger("2.count");
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
