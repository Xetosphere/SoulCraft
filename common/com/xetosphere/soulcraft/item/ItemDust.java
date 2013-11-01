package com.xetosphere.soulcraft.item;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Strings;

public class ItemDust extends ItemSC {

	public ItemDust(int id) {

		super(id);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.DUST_NAME);
		setCreativeTab(SoulCraft.tabSC);
	}

}
