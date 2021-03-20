package us.newadventures.rewardingachievements.commands;

import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommand;

public class ExchangeCommand extends SimpleCommand {


	public ExchangeCommand() {
		super("exchange");
	}

	@Override
	protected void onCommand() {

		checkConsole();

		Player player = getPlayer();

		player.getInventory().remove(new ItemStack(Material.DIRT, 32));

		player.getWorld().spawn(player.getLocation(), Firework.class);

		tell("A firework has been spawned.");
	}
}
