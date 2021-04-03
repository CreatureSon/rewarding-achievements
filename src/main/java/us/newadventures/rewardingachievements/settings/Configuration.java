package us.newadventures.rewardingachievements.settings;

import org.mineacademy.fo.settings.SimpleSettings;
import us.newadventures.rewardingachievements.quests.Quest;

import java.util.*;

public class Configuration extends SimpleSettings {

	public static Map<String, Quest> quests = new HashMap<>();

	private static void init() {

		LinkedHashMap<String, LinkedHashMap<String, Object>> questMap = getValuesAndKeys("quests");

		pathPrefix("quests");
		for (String key : questMap.keySet()) {
			quests.put(key, Quest.deserialize(key, getMap(key)));
		}

		TreeMap<String, Quest> sortedQuestMap = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));
		sortedQuestMap.putAll(quests);

		Quest.loadQuests(sortedQuestMap);
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
