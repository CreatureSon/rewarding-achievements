package us.newadventures.rewardingachievements.quests;

import lombok.Getter;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.model.ConfigSerializable;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Quest implements ConfigSerializable {

	private static Map<String, Quest> quests = new HashMap<>();

	private final String questID;
	private CompMaterial tradeable;
	private double tradeAmount;
	private CompMaterial reward;
	private double rewardAmount;

	protected Quest(String questID) {
		this.questID = questID;
	}

	@Override
	public SerializedMap serialize() {
		SerializedMap map = new SerializedMap();

		map.put("name", questID);
		map.put("trade", tradeable.toString().toLowerCase() + ", " + tradeAmount);
		map.put("reward", reward.toString().toLowerCase() + ", " + rewardAmount);

		return map;
	}

	public static Quest deserialize(String questID, SerializedMap map) {
		Quest quest = new Quest(questID);

		String[] trades = map.getString("trade").split(",");
		String[] rewards = map.getString("reward").split(",");

		quest.tradeable = CompMaterial.fromString(trades[0]);
		quest.tradeAmount = Double.parseDouble(trades[1]);
		quest.reward = CompMaterial.fromString(rewards[0]);
		quest.rewardAmount = Double.parseDouble(rewards[1]);

		return quest;
	}

	public static void loadQuests(Map<String, Quest> loadedQuests) {
		quests = loadedQuests;
	}
	//

	public static Quest getByName(final String name) {
		return quests.get(name);
	}

	public static Collection<Quest> getQuests() {
		return Collections.unmodifiableCollection(quests.values());
	}

	public static Collection<String> getQuestNames() {
		return Collections.unmodifiableCollection(quests.keySet());
	}
}
