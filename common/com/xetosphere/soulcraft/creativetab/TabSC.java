package com.xetosphere.soulcraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.xetosphere.soulcraft.item.ModItems;

public class TabSC extends CreativeTabs {

	public TabSC(int id, String nameInCode) {

		super(id, nameInCode);
	}

	@Override
	public ItemStack getIconItemStack() {

		return new ItemStack(ModItems.soroniteDust);
	}

}
