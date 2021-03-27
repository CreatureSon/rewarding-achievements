package us.newadventures.rewardingachievements.commands;

import org.mineacademy.fo.command.SimpleCommandGroup;

public class CommandGroup extends SimpleCommandGroup {
	@Override
	protected void registerSubcommands() {
		registerSubcommand(new ExchangeCommand(this));
		registerSubcommand(new QuestsCommand(this));
	}
}
