package com.xetosphere.soulcraft.item;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Strings;

public class ItemMagicIngot extends ItemSC {

	public ItemMagicIngot(int id) {

		super(id);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITE_INGOT_NAME);
		setCreativeTab(SoulCraft.tabSC);
		maxStackSize = 64;
	}

}
