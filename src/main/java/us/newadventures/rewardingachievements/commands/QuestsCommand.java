package us.newadventures.rewardingachievements.commands;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import us.newadventures.rewardingachievements.menus.QuestsMenu;

public class QuestsCommand extends SimpleSubCommand {

	public QuestsCommand(final SimpleCommandGroup parent) {
		super(parent, "quests");

		setPermission("ra.quests");
		setUsage("[player]");
		setDescription("Look at the current quests from the GuildMaster");
	}

	@Override
	protected void onCommand() {

		Player player;
		if (args.length > 0) {
			player = findPlayer(args[0]);
		} else {
			checkConsole();
			player = getPlayer();
		}

		new QuestsMenu().displayTo(player);
	}
}
