package us.newadventures.rewardingachievements.commands;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommand;
import us.newadventures.rewardingachievements.settings.Configuration;
import us.newadventures.rewardingachievements.utility.CustomFirework;

public class ExchangeCommand extends SimpleCommand {


	public ExchangeCommand() {
		super("exchange");
		setMinArguments(1);
		setUsage("<player>");
		setDescription("Exchange items for rewards through the GuildMaster");
	}

	@Override
	protected void onCommand() {

		Player player = findPlayer(args[0]);

		Material dirt = Material.getMaterial(Configuration.REWARD_ITEMS);

		ItemStack check = new ItemStack(dirt);
		ItemStack goods = new ItemStack(dirt, 32);
		ItemStack reward = new ItemStack(Material.PHANTOM_MEMBRANE, 1);

		CustomFirework firework = new CustomFirework();
		Location location = player.getLocation();
		Inventory inventory = player.getInventory();

		if (inventory.containsAtLeast(check, 32)) {
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
