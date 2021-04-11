package us.newadventures.rewardingachievements.utility;

import java.util.Arrays;
import java.util.List;

public class PluralMaterial {

	private static final List<String> plurals = Arrays.asList(
			"phantom",
			"bottle",
			"carrot",
			"potato",
			"apple",
			"emerald",
			"diamond",
			"ingot",
			"rose",
			"beetroot",
			"button",
			"boat",
			"plank",
			"sapling",
			"log",
			"door",
			"fence",
			"gate",
			"rail",
			"anvil",
			"arrow",
			"slab",
			"egg",
			"beacon",
			"beehive",
			"nest",
			"bell",
			"banner",
			"wool",
			"furnace",
			"smoker",
			"book",
			"tear",
			"eye",
			"nugget",
			"head",
			"sword",
			"axe",
			"pickaxe",
			"shovel",
			"hoe",
			"helmet",
			"chestplate",
			"bow",
			"chest",
			"torch",
			"vine",
			"bean",
			"noteblock",
			"scute"
	);

	private static final List<String> specialPlurals = Arrays.asList(
			"potato",
			"torch"
	);

	public static String getPlural(String material) {
		String pluralName;
		if (plurals.contains(material.toLowerCase())) {
			pluralName = material + "s";
		} else if (specialPlurals.contains(material.toLowerCase())) {
			pluralName = material + "es";
		} else {
			pluralName = material;
		}

		return pluralName;
	}
}
