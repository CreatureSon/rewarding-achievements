package us.newadventures.rewardingachievements.database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.database.SimpleFlatDatabase;
import us.newadventures.rewardingachievements.utility.PlayerData;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RADatabases extends SimpleFlatDatabase<PlayerData> {

	@Getter
	private static final RADatabases instance = new RADatabases();

	@Override
	protected void onLoad(SerializedMap map, PlayerData data) {

	}

	@Override
	protected SerializedMap onSave(PlayerData data) {
		return null;
	}

	@Override
	protected int getExpirationDays() {
		return 180;
	}
}
