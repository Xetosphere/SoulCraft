package com.xetosphere.soulcraft;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.xetosphere.soulcraft.block.ModBlocks;
import com.xetosphere.soulcraft.configuration.ConfigurationHandler;
import com.xetosphere.soulcraft.core.proxy.CommonProxy;
import com.xetosphere.soulcraft.creativetab.TabSC;
import com.xetosphere.soulcraft.item.ModItems;
import com.xetosphere.soulcraft.lib.Reference;
import com.xetosphere.soulcraft.network.PacketHandler;
import com.xetosphere.soulcraft.world.gen.WorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class SoulCraft {

	@Instance(Reference.MOD_ID)
	public static SoulCraft instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	// Adds the moderations creative tab in the creative tabs.
	public static final CreativeTabs tabSC = new TabSC(CreativeTabs.getNextID(), Reference.MOD_ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

		// Adds the configuration, that can change block and item identities as well as making the mob spawn in an already existing world.
		ConfigurationHandler.init(new File(e.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));

		// Adds the items that the moderation contains. As well as item recipes.
		ModItems.init();

		// Adds the blocks that the moderation contains. As well as block recipes and registering the blocks.
		ModBlocks.init();

		// Adds everything that has to do with generation.
		WorldGen.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

		// Register the GUI Handler.
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		// Initialize moderation tile entities.
		proxy.registerTileEntities();

		// Initialize custom rendering and textures (Client only).
		proxy.initRenderingAndTextures();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}
