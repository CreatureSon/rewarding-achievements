package us.newadventures.rewardingachievements.commands;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;
import us.newadventures.rewardingachievements.settings.Configuration;
import us.newadventures.rewardingachievements.utility.CustomFirework;

public class ExchangeCommand extends SimpleSubCommand {
	
	public ExchangeCommand(final SimpleCommandGroup parent) {
		super(parent, "exchange");

		setPermission("ra.exchange");
		setUsage("[player]");
		setDescription("Exchange items for rewards through the GuildMaster");
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

		Material dirt = Configuration.DIRT_EXCHANGE;
		int count = Configuration.DIRT_EXCHANGE_COUNT;
		Material honey = Configuration.HONEY_EXCHANGE;
		int honey_count = Configuration.HONEY_EXCHANGE_COUNT;

		ItemStack check = new ItemStack(dirt);
		ItemStack goods = new ItemStack(dirt, count);
		ItemStack reward = new ItemStack(Material.PHANTOM_MEMBRANE, 1);

		CustomFirework firework = new CustomFirework();
		Location location = player.getLocation();
		Inventory inventory = player.getInventory();

		if (inventory.containsAtLeast(check, count)) {
			inventory.removeItem(goods);
			inventory.addItem(reward);
			firework.spawnFirework(location, 1, Color.LIME);
			tell("Thank you for the dirt, here is your reward!");
		} else {
			firework.spawnFirework(location, 1, Color.RED);
			tell("Please provide 32 dirt to receive reward");
		}
	}
}
