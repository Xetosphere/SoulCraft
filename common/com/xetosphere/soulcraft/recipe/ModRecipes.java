package com.xetosphere.soulcraft.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.soulcraft.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void addRecipes() {

		vanillaRecipes();

		gemRecipes();
	}

	public static ItemStack fuseRecipes(Item item, int itemMeta, Item dust) {

		if (dust == ModItems.soroniteDust) {

			if (item == Item.ingotIron) {
				return new ItemStack(ModItems.soroniteIngot);
			}
		}

		return null;
	}

	private static void gemRecipes() {

		int i = OreDictionary.WILDCARD_VALUE;

		Item arcaneGem = ModItems.arcaneGem.setContainerItem(ModItems.arcaneGem);

		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 0), new ItemStack(Item.coal, 1, 0), new ItemStack(arcaneGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 1), new ItemStack(Item.coal, 1, 1), new ItemStack(arcaneGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 2, 0), new ItemStack(Item.ingotIron, 1, 0), new ItemStack(arcaneGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 2, 0), new ItemStack(Item.ingotGold, 1, 0), new ItemStack(arcaneGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 2, 0), new ItemStack(Item.diamond, 1, 0), new ItemStack(arcaneGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(Item.emerald, 1, 0), new ItemStack(arcaneGem, 1, i));
	}

	private static void vanillaRecipes() {

		furnaceRecipes();

		craftingRecipes();
	}

	private static void furnaceRecipes() {

	}

	private static void craftingRecipes() {

	}

}
