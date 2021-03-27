package us.newadventures.rewardingachievements.utility;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class PlayerData extends YamlSectionConfig {

	private static final Map<UUID, PlayerData> dataMap = new HashMap<>();


	/**
	 * Create a new section config with a section prefix,
	 * for example Players for storing player data.
	 *
	 * @param uuid
	 */
	protected PlayerData(String uuid) {
		super(uuid);
		loadConfiguration(null, "data.db");
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
	
}
