package us.newadventures.rewardingachievements.utility;

import java.util.ArrayList;
import java.util.List;

public class LoreReader {

	public static String capitalize(String lore, int amount) {

		if (lore == null || lore.isEmpty()) {
			return lore;
		}

		List<String> trade = new ArrayList<>();
		for (String s : lore.split("_")) {
			trade.add(s.substring(0, 1).toUpperCase() + s.substring(1));
		}

		int lastEntry = trade.size() - 1;
		trade.set(lastEntry, plural(trade.get(lastEntry), amount));

		return String.join(" ", trade);
	}

	public static String plural(String lore, int amount) {

		String plural;
		if (amount > 1) {
			plural = PluralMaterial.getPlural(lore);
		} else {
			plural = lore;
		}

		return plural;
	}

	public static String pluralReward(String reward, int amount) {

		String rewardName;
		if (reward.equalsIgnoreCase("phantom_membrane")) {
			rewardName = "Phantom";
		} else {
			rewardName = reward;
		}

		String rewardLore;
		if (amount > 1) {
			rewardLore = "are " + amount + " " + rewardName + "s";
		} else {
			rewardLore = "is " + amount + " " + rewardName;
		}
		return rewardLore;
	}

	public static String pluralTrade(String trade, int amount) {
		return amount + " " + capitalize(trade, amount);
	}
}
