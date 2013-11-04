package com.xetosphere.soulcraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.xetosphere.soulcraft.lib.Reference;

public class ItemSC extends Item {

	public ItemSC(int id) {

		super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
		maxStackSize = 1;
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
