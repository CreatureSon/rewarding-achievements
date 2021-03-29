package us.newadventures.rewardingachievements.database;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.mineacademy.fo.settings.YamlSectionConfig;
import us.newadventures.rewardingachievements.quests.Quest;

import java.util.*;

@Getter
public class PlayerData extends YamlSectionConfig {

	private static final Map<UUID, PlayerData> dataMap = new HashMap<>();

	private final List<Quest> completedQuests = new ArrayList<>();

	protected PlayerData(String uuid) {
		super(uuid);
		loadConfiguration(null, "data.db");
	}

	@Override
	protected void onLoadFinish() {

		if (isSet("quests")) {
			for (String name : getStringList("quests")) {
				completedQuests.add(Quest.getByID(name));
			}
		}
	}

	public static PlayerData getData(final Player player) {
		UUID uuid = player.getUniqueId();
		PlayerData data = dataMap.get(uuid);

		if (data == null) {
			data = new PlayerData(uuid.toString());

			dataMap.put(uuid, data);
		}

		return data;
	}

	public void questCompleted(Quest quest) {
		completedQuests.add(quest);

		List<String> questIDs = new ArrayList<>();

		for (Quest completed : completedQuests) {
			questIDs.add(completed.getQuestID());
		}

		save("quests", questIDs);
	}

	public List<String> getCompletedQuestIDs() {
		List<String> questIDs = new ArrayList<>();

		for (Quest quest : completedQuests) {
			questIDs.add(quest.getQuestID());
		}

		return Collections.unmodifiableList(questIDs);
	}
}
