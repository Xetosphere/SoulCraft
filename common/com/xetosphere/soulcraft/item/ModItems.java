package com.xetosphere.soulcraft.item;

import net.minecraft.item.Item;

import com.xetosphere.soulcraft.lib.ItemIds;

public class ModItems {

	public static Item soroniteDust;
	public static Item arcaneGem;
	public static Item soul;
	public static Item soroniteIngot;

	public static void init() {

		soroniteDust = new ItemDust(ItemIds.dustID);
		arcaneGem = new ItemArcaneGem(ItemIds.arcaneGemID);
		soul = new ItemSoul(ItemIds.soulID);
		soroniteIngot = new ItemIngot(ItemIds.ingotID);
	}

}
