package com.xetosphere.soulcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.xetosphere.soulcraft.tileentity.TileArcaneFuser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerArcaneFuser extends Container {

	private TileArcaneFuser fuser;

	private int lastFuseTime = 0;
	private int lastFusingTime = 0;
	private int lastItemFusingTime = 0;

	public ContainerArcaneFuser(InventoryPlayer inventoryPlayer, TileArcaneFuser fuser) {

		this.fuser = fuser;

		// Add the input slot to the container
		this.addSlotToContainer(new Slot(fuser, TileArcaneFuser.INPUT_INVENTORY_INDEX, 74, 17));

		// Add the dust input slot to the container
		this.addSlotToContainer(new Slot(fuser, TileArcaneFuser.DUST_INVENTORY_INDEX, 38, 17));

		// Add the fuel slot to the container
		this.addSlotToContainer(new Slot(fuser, TileArcaneFuser.FUEL_INVENTORY_INDEX, 56, 53));

		// Add the output results slot to the container
		this.addSlotToContainer(new SlotArcaneFuser(fuser, TileArcaneFuser.OUTPUT_INVENTORY_INDEX, 116, 35));

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
		par1ICrafting.sendProgressBarUpdate(this, 0, this.fuser.fuserFusedTime2);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.fuser.fuserFuseTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.fuser.currentItemFuseTime);
	}

	public void detectAndSendChanges() {

		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {

			ICrafting iCrafting = (ICrafting) this.crafters.get(i);

			if (this.lastFuseTime != this.fuser.fuserFusedTime2) {
				iCrafting.sendProgressBarUpdate(this, 0, this.fuser.fuserFusedTime2);
			}

			if (this.lastFusingTime != this.fuser.fuserFuseTime) {
				iCrafting.sendProgressBarUpdate(this, 1, this.fuser.fuserFuseTime);
			}

			if (this.lastItemFusingTime != this.fuser.currentItemFuseTime) {
				iCrafting.sendProgressBarUpdate(this, 2, this.fuser.currentItemFuseTime);
			}

			this.lastFuseTime = this.fuser.fuserFusedTime2;
			this.lastFusingTime = this.fuser.fuserFuseTime;
			this.lastItemFusingTime = this.fuser.currentItemFuseTime;
		}
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {

		if (par1 == 0) {
			this.fuser.fuserFusedTime2 = par2;
		}

		if (par1 == 1) {
			this.fuser.fuserFuseTime = par2;
		}

		if (par1 == 2) {
			this.fuser.currentItemFuseTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer player) {

		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {

		ItemStack itemStack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {

			ItemStack slotItemStack = slot.getStack();
			itemStack = slotItemStack.copy();

			if (slotIndex < TileArcaneFuser.INVENTORY_SIZE) {

				if (!this.mergeItemStack(slotItemStack, TileArcaneFuser.INVENTORY_SIZE, inventorySlots.size(), false)) {
					return null;
				}

			} else {

				if (TileArcaneFuser.isItemFuel(slotItemStack)) {
					if (!this.mergeItemStack(slotItemStack, TileArcaneFuser.FUEL_INVENTORY_INDEX, TileArcaneFuser.OUTPUT_INVENTORY_INDEX, false)) {
						return null;
					}
				}

				else if (TileArcaneFuser.isItemDust(slotItemStack)) {
					if (!this.mergeItemStack(slotItemStack, TileArcaneFuser.DUST_INVENTORY_INDEX, TileArcaneFuser.OUTPUT_INVENTORY_INDEX, false)) {
						return null;
					}
				}

				else if (!this.mergeItemStack(slotItemStack, TileArcaneFuser.INPUT_INVENTORY_INDEX, TileArcaneFuser.OUTPUT_INVENTORY_INDEX, false)) {
					return null;
				}

			}

			if (slotItemStack.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

		}

		return itemStack;
	}

}
