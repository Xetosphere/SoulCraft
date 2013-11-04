package com.xetosphere.soulcraft.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xetosphere.soulcraft.item.ModItems;

public class ArcaneFuserRecipes {

	private static final ArcaneFuserRecipes fusingBase = new ArcaneFuserRecipes();

	public static final ArcaneFuserRecipes fusing() {

		return fusingBase;
	}

	private ArcaneFuserRecipes() {

	}

	public ItemStack getFusingResult(int itemID, int itemMeta, int dustID, int dustMeta) {

		return getOutput(itemID, itemMeta, dustID, dustMeta);
	}

	private static ItemStack getOutput(int itemID, int itemMeta, int dustID, int dustMeta) {

		if (itemID == Item.ingotIron.itemID && dustID == ModItems.soroniteDust.itemID && dustMeta == 0) {
			return new ItemStack(ModItems.soroniteIngot, 1, 0);
		}

		if (itemID == Item.ingotIron.itemID && dustID == ModItems.soroniteDust.itemID && dustMeta == 1) {
			return new ItemStack(ModItems.soroniteIngot, 1, 1);
		}

		if (itemID == Item.ingotIron.itemID && dustID == ModItems.soroniteDust.itemID && dustMeta == 2) {
			return new ItemStack(ModItems.soroniteIngot, 1, 2);
		}

		return null;
	}

}
