package us.newadventures.rewardingachievements.menus;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.ItemUtil;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuPagged;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuestsMenu extends Menu {

	private final Button dirtButton;
	private final Button honeyButton;
	private final Button eggButton;

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

		eggButton = new ButtonMenu(new EggsMenu(), CompMaterial.PHANTOM_SPAWN_EGG,
				"Monster Egg Menu",
				"Click to open monster",
				"egg selection menu.");
	}

	@Override
	public ItemStack getItemAt(int slot) {

		if (slot == 9 * 1 + 3)
			return dirtButton.getItem();
		else if (slot == 9 * 1 + 5)
			return honeyButton.getItem();
		else if (slot == 9 * 1 + 4)
			return eggButton.getItem();
		else
			return super.getItemAt(slot);
	}

	@Override
	protected String[] getInfo() {
		return super.getInfo();
	}


	private class EggsMenu extends MenuPagged<EntityType> {

		protected EggsMenu() {
			super(QuestsMenu.this, Arrays.asList(EntityType.values())
					.stream().filter((entityType -> entityType.isSpawnable() &&
							entityType.isAlive() &&
							(entityType == EntityType.SHEEP || CompMaterial.makeMonsterEgg(entityType) != CompMaterial.SHEEP_SPAWN_EGG)))
					.collect(Collectors.toList()));

			setTitle("&aCreature Eggs");
		}

		@Override
		protected ItemStack convertToItemStack(final EntityType entity) {
			return ItemCreator.of(CompMaterial.makeMonsterEgg(entity),
					"Spawn " + ItemUtil.bountifyCapitalized(entity)
			).build().make();
		}

		@Override
		protected void onPageClick(Player player, EntityType entity, ClickType click) {
			player.getInventory().addItem(ItemCreator.of(CompMaterial.makeMonsterEgg(entity)).build().make());
		}
	}
}
