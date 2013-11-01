package com.xetosphere.soulcraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotArcaneFuser extends Slot {

	public SlotArcaneFuser(IInventory inventory, int x, int y, int z) {

		super(inventory, x, y, z);
	}

	public boolean isItemValid(ItemStack par1ItemStack) {

		return false;
	}

}
