package com.xetosphere.soulcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.soulcraft.lib.BlockIDs;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block soroniteOre;
	public static Block soroniteBlock;
	public static Block duplicator;
	public static Block fuser;

	/**
	 * Initializes the blocks that the mod contains. As well as block recipes and registering the blocks.
	 */
	public static void init() {

		soroniteOre = new BlockMagicOre(BlockIDs.SORONITE_ORE);
		soroniteBlock = new BlockMagicBlock(BlockIDs.SORONITE_BLOCK);
		duplicator = new BlockDuplicator(BlockIDs.DUPLICATOR);
		fuser = new BlockArcaneFuser(BlockIDs.ARCANE_FUSER);

		GameRegistry.registerBlock(fuser, Strings.ARCANE_FUSER_NAME);
		GameRegistry.registerBlock(duplicator, Strings.DUPLICATOR_NAME);

		GameRegistry.registerBlock(soroniteOre, Strings.SORONITE_ORE_NAME);
		GameRegistry.registerBlock(soroniteBlock, Strings.SORONITE_BLOCK_NAME);

		addOreLevels();
		initToOreDictionary();
	}

	public static void addOreLevels() {

		MinecraftForge.setBlockHarvestLevel(soroniteOre, "pickaxe", 2);

		MinecraftForge.setBlockHarvestLevel(soroniteBlock, "pickaxe", 0);
	}

	public static void initToOreDictionary() {

		OreDictionary.registerOre("oreSoronite", new ItemStack(soroniteOre, 1));
	}

}
