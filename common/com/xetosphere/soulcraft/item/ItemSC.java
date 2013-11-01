package com.xetosphere.soulcraft.item;

import com.xetosphere.soulcraft.lib.Reference;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemSC extends Item {

	public ItemSC(int id) {

		super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
