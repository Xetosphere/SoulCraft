package com.xetosphere.soulcraft.item;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Strings;

public class ItemIngot extends ItemSC {

	public ItemIngot(int id) {

		super(id);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.INGOT_NAME);
		setCreativeTab(SoulCraft.tabSC);
	}

}
