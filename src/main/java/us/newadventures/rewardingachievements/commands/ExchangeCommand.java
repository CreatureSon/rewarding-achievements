package us.newadventures.rewardingachievements.commands;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleSubCommand;
import us.newadventures.rewardingachievements.database.PlayerData;
import us.newadventures.rewardingachievements.quests.Quest;
import us.newadventures.rewardingachievements.utility.CustomFirework;

public class ExchangeCommand extends SimpleSubCommand {

	public ExchangeCommand() {
		super("exchange");

		setPermission("ra.exchange");
		setMinArguments(2);
		setUsage("<player> <quest>");
		setDescription("Exchange items for rewards through the GuildMaster");
	}

	@Override
	protected void onCommand() {

		Player player = findPlayer(args[0]);
		final PlayerData playerData = PlayerData.getData(player);
		Quest quest = Quest.getByID(args[1]);

		if (playerData.getCompletedQuests().isEmpty() || !playerData.getCompletedQuestIDs().contains(quest.getQuestID())) {
			Material tradeItem = quest.getTradeable().getMaterial();
			int tradeCount = quest.getTradeAmount();

			ItemStack check = new ItemStack(tradeItem);
			ItemStack goods = new ItemStack(tradeItem, tradeCount);
			ItemStack reward = new ItemStack(quest.getReward().getMaterial(), quest.getRewardAmount());

			CustomFirework firework = new CustomFirework();
			Location location = player.getLocation();
			Inventory inventory = player.getInventory();

			if (inventory.containsAtLeast(check, tradeCount)) {
				inventory.removeItem(goods);
				inventory.addItem(reward);
				firework.spawnFirework(location, 1, Color.LIME);
				Common.tell(player, "&3[&5GuildMaster&3]&7 Thank you for the " + quest.getName() + "&7, take " + quest.getRewardLore() + " for your troubles");
				playerData.questCompleted(quest);
			} else {
				Common.tell(player, "&3[&5GuildMaster&3]&7 Please provide " + quest.getTradeLore() + " to receive reward");
			}
		} else {
			Common.tell(player, "&3[&5GuildMaster&3]&7 You have already completed this quest.  Please select a different quest.");
		}
	}
}