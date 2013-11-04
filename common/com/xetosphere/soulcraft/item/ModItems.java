package com.xetosphere.soulcraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.soulcraft.lib.ItemIDs;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item soroniteDust;
	public static Item soroniteIngot;
	public static Item arcaneGem;

	/**
	 * Adds the items that the mod contains. As well as item recipes.
	 */
	public static void init() {

		soroniteDust = new ItemMagicDust(ItemIDs.SORONITE_DUST);
		soroniteIngot = new ItemMagicIngot(ItemIDs.SORONITE_INGOT);
		arcaneGem = new ItemArcaneGem(ItemIDs.ARCANE_GEM);

		registerRecipes();
	}

	/**
	 * Adds the recipes for the craftable items.
	 */
	public static void registerRecipes() {

		// Arcane gem duplicating recipes
		duplicateItems();
	}

	public static void duplicateItems() {

		int i = OreDictionary.WILDCARD_VALUE;

		Item dupleGem = arcaneGem.setContainerItem(ModItems.arcaneGem);

		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 0), new ItemStack(Item.coal, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 1), new ItemStack(Item.coal, 1, 1), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 2, 0), new ItemStack(Item.ingotIron, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 2, 0), new ItemStack(Item.ingotGold, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 2, 0), new ItemStack(Item.diamond, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(Item.emerald, 1, 0), new ItemStack(dupleGem, 1, i));
	}

}
