package us.newadventures.rewardingachievements.commands;

import org.mineacademy.fo.command.SimpleCommandGroup;

public class CommandGroup extends SimpleCommandGroup {
	@Override
	protected void registerSubcommands() {
		registerSubcommand(new ExchangeCommand());
		registerSubcommand(new QuestsCommand());
		registerSubcommand(new ReloadCommand());
	}
}
