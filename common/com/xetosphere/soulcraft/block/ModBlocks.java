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
	public static Block soroniteBrick;
	public static Block duplicator;
	public static Block arcaneFuser;
	public static Block auraCrusher;

	/**
	 * Initializes the blocks that the moderation contains. As well as block recipes and registering the blocks.
	 */
	public static void init() {

		soroniteOre = new BlockMagicOre(BlockIDs.SORONITE_ORE);
		soroniteBlock = new BlockMagicBlock(BlockIDs.SORONITE_BLOCK).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITE_BLOCK_NAME);
		soroniteBrick = new BlockMagicBlock(BlockIDs.SORONITE_BRICK).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITE_BRICK_NAME);
		duplicator = new BlockDuplicator(BlockIDs.DUPLICATOR);
		arcaneFuser = new BlockArcaneFuser(BlockIDs.ARCANE_FUSER);
		auraCrusher = new BlockAuraCrusher(BlockIDs.AURA_CRUSHER);

		GameRegistry.registerBlock(arcaneFuser, Strings.ARCANE_FUSER_NAME);
		GameRegistry.registerBlock(duplicator, Strings.DUPLICATOR_NAME);
		GameRegistry.registerBlock(auraCrusher, Strings.AURA_CRUSHER_NAME);

		GameRegistry.registerBlock(soroniteOre, Strings.SORONITE_ORE_NAME);
		GameRegistry.registerBlock(soroniteBlock, Strings.SORONITE_BLOCK_NAME);
		GameRegistry.registerBlock(soroniteBrick, Strings.SORONITE_BRICK_NAME);

		addOreLevels();
		initToOreDictionary();
	}

	public static void addOreLevels() {

		MinecraftForge.setBlockHarvestLevel(soroniteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(soroniteBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(soroniteBrick, "pickaxe", 0);
	}

	public static void initToOreDictionary() {

		OreDictionary.registerOre("oreSoronite", new ItemStack(soroniteOre, 1));
	}

}
