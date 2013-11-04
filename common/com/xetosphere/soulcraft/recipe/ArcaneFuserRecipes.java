package com.xetosphere.soulcraft.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArcaneFuserRecipes {

	private static final ArcaneFuserRecipes fusingBase = new ArcaneFuserRecipes();

	public static final ArcaneFuserRecipes fusing() {

		return fusingBase;
	}

	private ArcaneFuserRecipes() {

	}

	public ItemStack getFusingResult(Item item, int itemMeta, Item dust) {

		return ModRecipes.fuseRecipes(item, itemMeta, dust);
	}

}
