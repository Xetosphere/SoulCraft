package com.xetosphere.soulcraft.world.gen;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {

	private static OreGeneration oreGenerator = new OreGeneration();

	public static void init() {

		GameRegistry.registerWorldGenerator(oreGenerator);
	}

}
