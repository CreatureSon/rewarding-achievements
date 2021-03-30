package us.newadventures.rewardingachievements.utility;

import java.util.ArrayList;
import java.util.List;

public class LoreReader {

	public static String capitalize(String lore) {

		if (lore == null || lore.isEmpty()) {
			return lore;
		}

		List<String> trade = new ArrayList<>();
		for (String s : lore.split("_")) {
			trade.add(s.substring(0, 1).toUpperCase() + s.substring(1));
		}

		return String.join(" ", trade);
	}

	public static String plural(String lore) {

		if (lore == null || lore.isEmpty()) {
			return lore;
		}

		List<String> trade = new ArrayList<>();
		for (String s : lore.split(" ")) {
			String plural;
			if (s.equalsIgnoreCase("bottle")) {
				plural = s + "s";
			} else {
				plural = s;
			}
			trade.add(plural);
		}

		return String.join(" ", trade);
	}

	public static String pluralReward(double reward) {
		if (reward > 1) {
			return "are " + reward + " Phantoms";
		} else {
			return "is " + reward + " Phantom";
		}
	}

	public static String pluralTrade(String trade, int amount) {
		return amount + " " + plural(capitalize(trade));
	}
}
