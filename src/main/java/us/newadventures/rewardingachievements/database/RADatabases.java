package us.newadventures.rewardingachievements.database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.database.SimpleFlatDatabase;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RADatabases extends SimpleFlatDatabase<PlayerData> {

	@Getter
	private static final RADatabases instance = new RADatabases();

	@Override
	protected void onLoad(SerializedMap map, PlayerData data) {
		List<String> questIDs = map.getStringList("quests");

		if (!questIDs.isEmpty())
			data.loadCompletedQuests(questIDs);
	}

	@Override
	protected SerializedMap onSave(PlayerData data) {
		SerializedMap map = new SerializedMap();

		if (!data.getCompletedQuestIDs().isEmpty())
			map.put("quests", data.getCompletedQuestIDs());

		return map;
	}

	@Override
	protected int getExpirationDays() {
		return 365;
	}
}