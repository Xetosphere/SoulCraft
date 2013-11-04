package com.xetosphere.soulcraft.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.xetosphere.soulcraft.lib.BlockIDs;
import com.xetosphere.soulcraft.lib.ItemIDs;
import com.xetosphere.soulcraft.lib.Reference;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.common.FMLLog;

public class ConfigurationHandler {

	public static Configuration config;

	public static void init(File configFile) {

		config = new Configuration(configFile);

		try {

			config.load();

			// Blocks
			BlockIDs.SORONITE_ORE = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.SORONITE_ORE_NAME, BlockIDs.SORONITE_ORE_DEFAULT).getInt(BlockIDs.SORONITE_ORE_DEFAULT);
			BlockIDs.SORONITE_BLOCK = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.SORONITE_BLOCK_NAME, BlockIDs.SORONITE_BLOCK_DEFAULT).getInt(BlockIDs.SORONITE_BLOCK_DEFAULT);
			BlockIDs.DUPLICATOR = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.DUPLICATOR_NAME, BlockIDs.DUPLICATOR_DEFAULT).getInt(BlockIDs.DUPLICATOR_DEFAULT);
			BlockIDs.ARCANE_FUSER = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.ARCANE_FUSER_NAME, BlockIDs.ARCANE_FUSER_DEFAULT).getInt(BlockIDs.ARCANE_FUSER_DEFAULT);

			// Items
			ItemIDs.SORONITE_DUST = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITE_DUST_NAME, ItemIDs.SORONITE_DUST_DEFAULT).getInt(ItemIDs.SORONITE_DUST_DEFAULT);
			ItemIDs.SORONITE_INGOT = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITE_INGOT_NAME, ItemIDs.SORONITE_INGOT_DEFAULT).getInt(ItemIDs.SORONITE_INGOT_DEFAULT);
			ItemIDs.ARCANE_GEM = config.getItem(Configuration.CATEGORY_ITEM, Strings.ARCANE_GEM_NAME, ItemIDs.ARCANE_GEM_DEFAULT).getInt(ItemIDs.ARCANE_GEM_DEFAULT);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + " had a problem loading its configuration file.");
		} finally {
			config.save();
		}
	}

	public static void set(String categoryName, String propertyName, String newValue) {

		config.load();
		if (config.getCategoryNames().contains(categoryName)) {
			if (config.getCategory(categoryName).containsKey(propertyName)) {
				config.getCategory(categoryName).get(propertyName).set(newValue);
			}
		}
		config.save();
	}

}
