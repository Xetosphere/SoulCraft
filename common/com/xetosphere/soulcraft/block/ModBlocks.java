package com.xetosphere.soulcraft.block;

import com.xetosphere.soulcraft.lib.BlockIds;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

public class ModBlocks {

	public static Block soroniteOre;
	public static Block soroniteBlock;
	public static Block duplicator;
	public static Block arcaneFuser;
	public static Block auraCrusher;

	public static void init() {

		soroniteOre = new BlockModOres(BlockIds.oreID);
		soroniteBlock = new BlockSolidBlock(BlockIds.blockID);
		duplicator = new BlockDuplicator(BlockIds.duplicatorID);
		arcaneFuser = new BlockArcaneFuser(BlockIds.arcaneFuserID);

		GameRegistry.registerBlock(soroniteOre, "soroniteOre");
		GameRegistry.registerBlock(soroniteBlock, "soroniteBlock");
		GameRegistry.registerBlock(duplicator, "duplicator");
		GameRegistry.registerBlock(arcaneFuser, "arcaneFuser");

		MinecraftForge.setBlockHarvestLevel(soroniteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(soroniteBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(duplicator, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(arcaneFuser, "pickaxe", 0);
	}

}
