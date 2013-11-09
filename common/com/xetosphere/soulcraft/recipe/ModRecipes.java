package com.xetosphere.soulcraft.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.soulcraft.block.ModBlocks;
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

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.soroniteIngot, 9), ModBlocks.soroniteBlock);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.soroniteBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), ModItems.soroniteIngot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.soroniteBrick), new Object[] { "SS", "SS", Character.valueOf('S'), ModBlocks.soroniteBlock });
		GameRegistry.addRecipe(new ItemStack(ModItems.arcaneGem), new Object[] { "XYX", "YZY", "XYX", Character.valueOf('X'), ModItems.soroniteDust, Character.valueOf('Y'), Item.diamond, Character.valueOf('Z'), Item.emerald });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.duplicator), new Object[] { "GWG", "BAB", "BFB", Character.valueOf('G'), Item.ingotGold, Character.valueOf('W'), new ItemStack(Block.cloth, 1, 10), Character.valueOf('B'), Block.netherBrick, Character.valueOf('A'), ModItems.arcaneGem, Character.valueOf('F'), Block.furnaceIdle });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.arcaneFuser), new Object[] { "GWG", "BRB", "BFB", Character.valueOf('G'), Item.ingotGold, Character.valueOf('W'), new ItemStack(Block.cloth, 1, 5), Character.valueOf('B'), Block.brick, Character.valueOf('R'), Item.redstone, Character.valueOf('F'), Block.furnaceIdle });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.auraCrusher), new Object[] { "SWS", "OfO", "OFO", Character.valueOf('S'), ModItems.soroniteIngot, Character.valueOf('W'), new ItemStack(Block.cloth, 1, 14), Character.valueOf('O'), Block.obsidian, Character.valueOf('f'), Item.flint, Character.valueOf('F'), Block.furnaceIdle });
		GameRegistry.addRecipe(new ItemStack(ModItems.soronitePaxel), new Object[] { "SSS", "SWS", " W ", Character.valueOf('S'), ModItems.soroniteIngot, Character.valueOf('W'), Item.stick });
	}

}
