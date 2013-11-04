package com.xetosphere.soulcraft.item;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Strings;

public class ItemMagicDust extends ItemSC {

	public ItemMagicDust(int id) {

		super(id);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITE_DUST_NAME);
		setCreativeTab(SoulCraft.tabSC);
		maxStackSize = 64;
	}

}
