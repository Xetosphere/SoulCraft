package com.xetosphere.soulcraft.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.soulcraft.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModCraftingRecipes {

	public static void initRecipes() {

		shapelessRecipes();
		recipes();
	}

	public static void recipes() {

		GameRegistry.addRecipe(new ItemStack(ModItems.arcaneGem), new Object[] { "XYX", "YZY", "XYX", Character.valueOf('X'), new ItemStack(ModItems.soroniteDust), Character.valueOf('Y'), Item.diamond, Character.valueOf('Z'), Item.emerald });
	}

	public static void shapelessRecipes() {

		int i = OreDictionary.WILDCARD_VALUE;

		Item dupleGem = ModItems.arcaneGem.setContainerItem(ModItems.arcaneGem);

		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 0), new ItemStack(Item.coal, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 1), new ItemStack(Item.coal, 1, 1), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 2, 0), new ItemStack(Item.ingotIron, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 2, 0), new ItemStack(Item.ingotGold, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 2, 0), new ItemStack(Item.diamond, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(Item.emerald, 1, 0), new ItemStack(dupleGem, 1, i));

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 1), Item.rottenFlesh, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 2), Item.silk, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 3), Item.gunpowder, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 4), Item.enderPearl, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 5), Item.goldNugget, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 6), Block.cloth, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 7), Item.leather, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 8), Item.blazePowder, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 9), Item.bone, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 10), Item.bone, Item.netherStalkSeeds, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 11), Item.slimeBall, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 12), Item.magmaCream, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 13), Block.stone, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 14), Item.spiderEye, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 15), Item.potion, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 16), Item.porkRaw, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 17), Item.saddle, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 18), Item.feather, new ItemStack(ModItems.soul, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soul, 1, 19), new ItemStack(ModItems.soul, 1, 0), new ItemStack(ModItems.soul, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), Item.egg, new ItemStack(ModItems.soul, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 52), Item.egg, new ItemStack(ModItems.soul, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 50), Item.egg, new ItemStack(ModItems.soul, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 58), Item.egg, new ItemStack(ModItems.soul, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 57), Item.egg, new ItemStack(ModItems.soul, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 91), Item.egg, new ItemStack(ModItems.soul, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 92), Item.egg, new ItemStack(ModItems.soul, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 61), Item.egg, new ItemStack(ModItems.soul, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), Item.egg, new ItemStack(ModItems.soul, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), Item.egg, new ItemStack(ModItems.soul, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 62), Item.egg, new ItemStack(ModItems.soul, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 60), Item.egg, new ItemStack(ModItems.soul, 1, 13));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 59), Item.egg, new ItemStack(ModItems.soul, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 66), Item.egg, new ItemStack(ModItems.soul, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 90), Item.egg, new ItemStack(ModItems.soul, 1, 16));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 100), Item.egg, new ItemStack(ModItems.soul, 1, 17));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 93), Item.egg, new ItemStack(ModItems.soul, 1, 18));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 65), Item.egg, new ItemStack(ModItems.soul, 1, 19));
	}

}
