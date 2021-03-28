package us.newadventures.rewardingachievements.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import us.newadventures.rewardingachievements.quests.Quest;

public class QuestsMenu extends Menu {

	private final Button dirtButton;
	private final Button honeyButton;
	private final Button questButton;

	public QuestsMenu() {

		setTitle("&eGuildMaster Quests");
		setSize(9 * 3);

		dirtButton = new Button() {

			@Override
			public void onClickedInMenu(Player player, Menu menu, ClickType click) {
				Common.dispatchCommand(player, "ra exchange {player}");
			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of(CompMaterial.DIRT,
						"&2Black Earth",
						"Provide 32 dirt",
						"for your reward"
				).build().make();
			}
		};

		honeyButton = new Button() {

			@Override
			public void onClickedInMenu(Player player, Menu menu, ClickType click) {
				Common.dispatchCommand(player, "ra exchange {player}");
			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of(CompMaterial.HONEY_BOTTLE,
						"&6Sweet Honey",
						"Provide 16 Bottles",
						"of Honey and earn your reward"
				).build().make();
			}
		};

		questButton = new ButtonMenu(new QuestsMenu(), CompMaterial.PHANTOM_SPAWN_EGG,
				"GuildMaster Quests Menu",
				"Click to trade items",
				"for a reward!");
	}

	@Override
	public ItemStack getItemAt(int slot) {

		if (slot == 9 * 1 + 3)
			return dirtButton.getItem();
		else if (slot == 9 * 1 + 5)
			return honeyButton.getItem();
		else if (slot == 9 * 1 + 4)
			return questButton.getItem();
		else
			return super.getItemAt(slot);
	}

	@Override
	protected String[] getInfo() {
		return super.getInfo();
	}


	private class TestMenu extends MenuPagged<Quest> {


		protected TestMenu(Iterable<Quest> pages) {
			super(pages);
		}

		@Override
		protected ItemStack convertToItemStack(Quest item) {
			return null;
		}

		@Override
		protected void onPageClick(Player player, Quest item, ClickType click) {

		}
	}
}
