package com.xetosphere.soulcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.soulcraft.lib.BlockIDs;
import com.xetosphere.soulcraft.lib.Elements;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block soroniteOre;
	public static Block soroniteBlock;
	public static Block soroniteBrick;
	public static Block duplicator;
	public static Block arcaneFuser;
	public static Block auraCrusher;
	public static Block airTotem;
	public static Block fireTotem;
	public static Block waterTotem;
	public static Block earthTotem;

	/**
	 * Initializes the blocks that the moderation contains. As well as block recipes and registering the blocks.
	 */
	public static void init() {

		soroniteOre = new BlockMagicOre(BlockIDs.SORONITE_ORE);
		soroniteBlock = new BlockMagicBlock(BlockIDs.SORONITE_BLOCK, Strings.SORONITE_BLOCK_NAME);
		soroniteBrick = new BlockMagicBlock(BlockIDs.SORONITE_BRICK, Strings.SORONITE_BRICK_NAME);
		duplicator = new BlockDuplicator(BlockIDs.DUPLICATOR);
		arcaneFuser = new BlockArcaneFuser(BlockIDs.ARCANE_FUSER);
		auraCrusher = new BlockAuraCrusher(BlockIDs.AURA_CRUSHER);
		airTotem = new BlockTotem(BlockIDs.AIR_TOTEM, Strings.AIR_TOTEM_NAME, Elements.AIR);
		fireTotem = new BlockTotem(BlockIDs.FIRE_TOTEM, Strings.FIRE_TOTEM_NAME, Elements.FIRE);
		waterTotem = new BlockTotem(BlockIDs.WATER_TOTEM, Strings.WATER_TOTEM_NAME, Elements.WATER);
		earthTotem = new BlockTotem(BlockIDs.EARTH_TOTEM, Strings.EARTH_TOTEM_NAME, Elements.EARTH);

		GameRegistry.registerBlock(arcaneFuser, Strings.ARCANE_FUSER_NAME);
		GameRegistry.registerBlock(duplicator, Strings.DUPLICATOR_NAME);
		GameRegistry.registerBlock(auraCrusher, Strings.AURA_CRUSHER_NAME);

		GameRegistry.registerBlock(soroniteOre, Strings.SORONITE_ORE_NAME);
		GameRegistry.registerBlock(soroniteBlock, Strings.SORONITE_BLOCK_NAME);
		GameRegistry.registerBlock(soroniteBrick, Strings.SORONITE_BRICK_NAME);
		GameRegistry.registerBlock(airTotem, Strings.AIR_TOTEM_NAME);
		GameRegistry.registerBlock(fireTotem, Strings.FIRE_TOTEM_NAME);
		GameRegistry.registerBlock(waterTotem, Strings.WATER_TOTEM_NAME);
		GameRegistry.registerBlock(earthTotem, Strings.EARTH_TOTEM_NAME);

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
