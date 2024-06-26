package us.newadventures.rewardingachievements.quests;

import lombok.Getter;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.model.ConfigSerializable;
import org.mineacademy.fo.remain.CompMaterial;
import us.newadventures.rewardingachievements.utility.LoreReader;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Quest implements ConfigSerializable {

	private static Map<String, Quest> quests = new HashMap<>();

	private final String questID;
	private String name;
	private CompMaterial tradeable;
	private int tradeAmount;
	private String tradeLore;
	private CompMaterial reward;
	private int rewardAmount;
	private String rewardLore;

	protected Quest(String questID) {
		this.questID = questID;
	}

	@Override
	public SerializedMap serialize() {
		SerializedMap map = new SerializedMap();

		map.put("id", questID);
		map.put("name", name);
		map.put("trade", tradeable.toString().toLowerCase() + ", " + tradeAmount);
		map.put("reward", reward.toString().toLowerCase() + ", " + rewardAmount);

		return map;
	}

	public static Quest deserialize(String questID, SerializedMap map) {
		Quest quest = new Quest(questID);

		String[] trades = map.getString("trade").split(",");
		String[] rewards = map.getString("reward").split(",");

		quest.name = map.getString("name");
		quest.tradeable = CompMaterial.fromString(trades[0]);
		quest.tradeAmount = (int) Double.parseDouble(trades[1]);
		quest.tradeLore = LoreReader.pluralTrade(trades[0], quest.tradeAmount);
		quest.reward = CompMaterial.fromString(rewards[0]);
		quest.rewardAmount = (int) Double.parseDouble(rewards[1]);
		quest.rewardLore = LoreReader.pluralReward(rewards[0], quest.rewardAmount);

		return quest;
	}

	public static void loadQuests(Map<String, Quest> loadedQuests) {
		quests = loadedQuests;
	}

	public static Quest getByID(final String ID) {
		return quests.get(ID);
	}

	public static Collection<Quest> getQuests() {
		return Collections.unmodifiableCollection(quests.values());
	}

	public static Collection<String> getQuestNames() {
		return Collections.unmodifiableCollection(quests.keySet());
	}
}
