package us.newadventures.rewardingachievements.commands;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommand;
import us.newadventures.rewardingachievements.utility.CustomFirework;

public class ExchangeCommand extends SimpleCommand {


	public ExchangeCommand() {
		super("exchange");
	}

	@Override
	protected void onCommand() {
		checkConsole();

		ItemStack check = new ItemStack(Material.DIRT);
		ItemStack goods = new ItemStack(Material.DIRT, 32);
		ItemStack reward = new ItemStack(Material.PHANTOM_MEMBRANE, 1);

		Player player = getPlayer();
		World world = player.getWorld();
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
