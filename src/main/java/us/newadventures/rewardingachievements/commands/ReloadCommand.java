package us.newadventures.rewardingachievements.commands;

import org.mineacademy.fo.command.SimpleSubCommand;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.SimpleLocalization;

public class ReloadCommand extends SimpleSubCommand {

	protected ReloadCommand() {
		super("reload");
	}

	@Override
	protected void onCommand() {
		try {
			SimplePlugin.getInstance().reload();
			tell(SimpleLocalization.Commands.RELOAD_SUCCESS);
		} catch (Throwable t) {
			t.printStackTrace();
			tell(SimpleLocalization.Commands.RELOAD_FAIL.replace("{error}", t.toString()));
		}
	}
}
