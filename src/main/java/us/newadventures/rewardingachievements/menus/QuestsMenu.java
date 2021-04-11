package us.newadventures.rewardingachievements.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.model.ItemCreator;
import us.newadventures.rewardingachievements.quests.Quest;

public class QuestsMenu extends MenuPagged<Quest> {

	public QuestsMenu() {
		super(Quest.getQuests());

		setTitle("&5GuildMaster Quests");
		setSize(9 * 3);
	}

	@Override
	protected ItemStack convertToItemStack(Quest quest) {
		return ItemCreator.of(quest.getTradeable(),
				quest.getName(),
				"",
				"Trade: " + quest.getTradeLore(),
				"Reward: " + quest.getRewardLore()
		).build().make();
	}

	@Override
	protected void onPageClick(Player player, Quest quest, ClickType click) {
		Common.dispatchCommand(player, "ra exchange {player} " + quest.getQuestID());
	}
}
