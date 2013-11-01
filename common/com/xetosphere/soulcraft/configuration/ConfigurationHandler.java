package com.xetosphere.soulcraft.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.xetosphere.soulcraft.lib.BlockIds;
import com.xetosphere.soulcraft.lib.ItemIds;
import com.xetosphere.soulcraft.lib.Reference;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.common.FMLLog;

public class ConfigurationHandler {

	public static Configuration config;

	public static void init(File configFile) {

		config = new Configuration(configFile);

		try {

			config.load();

			BlockIds.oreID = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.ORE_NAME, BlockIds.ORE_ID).getInt(BlockIds.ORE_ID);
			BlockIds.blockID = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.BLOCK_NAME, BlockIds.BLOCK_ID).getInt(BlockIds.BLOCK_ID);
			BlockIds.duplicatorID = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.DUPLICATOR_NAME, BlockIds.DUPLICATOR_ID).getInt(BlockIds.DUPLICATOR_ID);
			BlockIds.arcaneFuserID = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.ARCANE_FUSER_NAME, BlockIds.ARCANE_FUSER_ID).getInt(BlockIds.ARCANE_FUSER_ID);
			BlockIds.auraCrusherID = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.AURA_CRUSHER_NAME, BlockIds.AURA_CRUSHER_ID).getInt(BlockIds.AURA_CRUSHER_ID);

			ItemIds.dustID = config.getItem(Configuration.CATEGORY_ITEM, Strings.DUST_NAME, ItemIds.DUST_ID).getInt(ItemIds.DUST_ID);
			ItemIds.soulID = config.getItem(Configuration.CATEGORY_ITEM, Strings.SOUL_NAME, ItemIds.SOUL_ID).getInt(ItemIds.SOUL_ID);
			ItemIds.arcaneGemID = config.getItem(Configuration.CATEGORY_ITEM, Strings.ARCANEGEM_NAME, ItemIds.ARCANEGEM_ID).getInt(ItemIds.ARCANEGEM_ID);
			ItemIds.ingotID = config.getItem(Configuration.CATEGORY_ITEM, Strings.INGOT_NAME, ItemIds.INGOT_ID).getInt(ItemIds.INGOT_ID);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + " had a problem loading its configuration file.");
		} finally {
			config.save();
		}
	}

}
