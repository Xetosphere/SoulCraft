package com.xetosphere.soulcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.xetosphere.soulcraft.recipe.DuplicatorRecipes;
import com.xetosphere.soulcraft.tileentity.TileDuplicator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerDuplicator extends Container {

	private TileDuplicator duplicator;

	private int lastDuplicateTime = 0;
	private int lastDuplicatingTime = 0;
	private int lastItemDuplicatingTime = 0;

	public ContainerDuplicator(InventoryPlayer inventoryPlayer, TileDuplicator duplicator) {

		this.duplicator = duplicator;

		// Add the input slot to the container
		this.addSlotToContainer(new Slot(duplicator, TileDuplicator.INPUT_INVENTORY_INDEX, 56, 17));

		// Add the dust input slot to the container
		this.addSlotToContainer(new Slot(duplicator, TileDuplicator.DUST_INVENTORY_INDEX, 56, 53));

		// Add the output results slot to the container
		this.addSlotToContainer(new SlotDuplicator(duplicator, TileDuplicator.OUTPUT_INVENTORY_INDEX, 116, 35));

		// Add the player's inventory slots to the container
		for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
			for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
				this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
			}
		}

		// Add the player's action bar slots to the container
		for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
			this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting par1ICrafting) {

		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.duplicator.duplicatorDupledTime2);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.duplicator.duplicatorDupleTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.duplicator.currentItemDupleTime);
	}

	public void detectAndSendChanges() {

		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {

			ICrafting iCrafting = (ICrafting) this.crafters.get(i);

			if (this.lastDuplicateTime != this.duplicator.duplicatorDupledTime2) {
				iCrafting.sendProgressBarUpdate(this, 0, this.duplicator.duplicatorDupledTime2);
			}

			if (this.lastDuplicatingTime != this.duplicator.duplicatorDupleTime) {
				iCrafting.sendProgressBarUpdate(this, 1, this.duplicator.duplicatorDupleTime);
			}

			if (this.lastItemDuplicatingTime != this.duplicator.currentItemDupleTime) {
				iCrafting.sendProgressBarUpdate(this, 2, this.duplicator.currentItemDupleTime);
			}

			this.lastDuplicateTime = this.duplicator.duplicatorDupledTime2;
			this.lastDuplicatingTime = this.duplicator.duplicatorDupleTime;
			this.lastItemDuplicatingTime = this.duplicator.currentItemDupleTime;
		}
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {

		if (par1 == 0) {
			this.duplicator.duplicatorDupledTime2 = par2;
		}

		if (par1 == 1) {
			this.duplicator.duplicatorDupleTime = par2;
		}

		if (par1 == 2) {
			this.duplicator.currentItemDupleTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer player) {

		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {

		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {

			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (par2 != 1 && par2 != 0) {
				if (DuplicatorRecipes.dupling().getDuplingResult(itemstack1) != null) {
					if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
						return null;
					}
				} else if (TileDuplicator.isItemFuel(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
				} else if (par2 >= 3 && par2 < 30) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return null;
					}
				} else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		return itemstack;
	}

}
