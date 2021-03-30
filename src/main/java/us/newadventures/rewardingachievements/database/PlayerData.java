package us.newadventures.rewardingachievements.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;
import us.newadventures.rewardingachievements.quests.Quest;

import java.util.*;

@Getter
@NoArgsConstructor
public class PlayerData {

	private static final Map<UUID, PlayerData> dataMap = new HashMap<>();

	private final Set<Quest> completedQuests = new HashSet<>();

	public static PlayerData getData(final Player player) {
		return getData(player.getUniqueId());
	}

	public static PlayerData getData(final UUID uuid) {
		PlayerData data = dataMap.get(uuid);

		if (data == null) {
			data = new PlayerData();

			dataMap.put(uuid, data);
		}

		return data;
	}

	public void questCompleted(Quest quest) {
		completedQuests.add(quest);
	}

	public void loadCompletedQuests(List<String> questIDs) {
		for (String questID : questIDs) {
			completedQuests.add(Quest.getByID(questID));
		}
	}

	public List<String> getCompletedQuestIDs() {
		List<String> questIDs = new ArrayList<>();

		for (Quest quest : completedQuests) {
			questIDs.add(quest.getQuestID());
		}

		return Collections.unmodifiableList(questIDs);
	}
}
