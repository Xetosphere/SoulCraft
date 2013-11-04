package com.xetosphere.soulcraft.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.xetosphere.soulcraft.item.ModItems;
import com.xetosphere.soulcraft.lib.Strings;
import com.xetosphere.soulcraft.recipe.DuplicatorRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileDuplicator extends TileSC implements IInventory {

	private ItemStack[] inventory;

	public static final int INVENTORY_SIZE = 3;

	public static final int INPUT_INVENTORY_INDEX = 0;
	public static final int DUST_INVENTORY_INDEX = 1;
	public static final int OUTPUT_INVENTORY_INDEX = 2;

	public int duplicatorDupleTime;
	public int currentItemDupleTime;
	public int duplicatorDupledTime2;

	public TileDuplicator() {

		inventory = new ItemStack[INVENTORY_SIZE];
	}

	@Override
	public int getSizeInventory() {

		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {

		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int ammount) {

		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			if (itemStack.stackSize <= ammount) {
				setInventorySlotContents(slot, null);
			} else {
				itemStack = itemStack.splitStack(ammount);
				if (itemStack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}

		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {

		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			setInventorySlotContents(slot, null);
		}

		return itemStack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {

		inventory[slot] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
			itemStack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {

		return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_DUPLICATOR_NAME;
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}

	@Override
	public void openChest() {

	}

	@Override
	public void closeChest() {

	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {

		super.readFromNBT(nbtTagCompound);

		NBTTagList tagList = nbtTagCompound.getTagList("Items");
		inventory = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tagCompound.getByte("Slot");
			if (slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}

			this.duplicatorDupleTime = nbtTagCompound.getShort("DuplicateTime");
			this.duplicatorDupledTime2 = nbtTagCompound.getShort("TimeSpent");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {

		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setShort("DuplicateTime", (short) this.duplicatorDupleTime);
		nbtTagCompound.setShort("TimeSpent", (short) this.duplicatorDupledTime2);

		NBTTagList tagList = new NBTTagList();
		for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
			if (inventory[currentIndex] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) currentIndex);
				inventory[currentIndex].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}

		nbtTagCompound.setTag("Items", tagList);
	}

	@Override
	public boolean isInvNameLocalized() {

		return this.hasCustomName();
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {

		return true;
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(super.toString());

		stringBuilder.append("TileDuplicator Data - ");
		for (int i = 0; i < inventory.length; i++) {
			if (i != 0) {
				stringBuilder.append(", ");
			}

			if (inventory[i] != null) {
				stringBuilder.append(String.format("inventory[%d]: %s", i, inventory[i].toString()));
			} else {
				stringBuilder.append(String.format("inventory[%d]: empty", i));
			}
		}

		stringBuilder.append("\n");

		return stringBuilder.toString();
	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressTimeScaled(int par1) {

		return this.duplicatorDupledTime2 * par1 / getTimeRequired(inventory[INPUT_INVENTORY_INDEX]);
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {

		if (this.currentItemDupleTime == 0) {
			this.currentItemDupleTime = getTimeRequired(inventory[INPUT_INVENTORY_INDEX]);
		}

		return this.duplicatorDupleTime * par1 / this.currentItemDupleTime;
	}

	public boolean isBurning() {

		return this.duplicatorDupleTime > 0;
	}

	@Override
	public void updateEntity() {

		boolean flag = this.duplicatorDupleTime > 0;
		boolean flag1 = false;

		if (this.duplicatorDupleTime > 0) {
			--this.duplicatorDupleTime;
		}

		if (!this.worldObj.isRemote) {
			if (this.duplicatorDupleTime == 0 && this.canSmelt()) {
				this.currentItemDupleTime = this.duplicatorDupleTime = getItemBurnTime(this.inventory[DUST_INVENTORY_INDEX]);
				if (this.duplicatorDupleTime > 0) {
					flag1 = true;
					if (this.inventory[DUST_INVENTORY_INDEX] != null) {
						--this.inventory[DUST_INVENTORY_INDEX].stackSize;
						if (this.inventory[DUST_INVENTORY_INDEX].stackSize == 0) {
							this.inventory[DUST_INVENTORY_INDEX] = this.inventory[DUST_INVENTORY_INDEX].getItem().getContainerItemStack(inventory[DUST_INVENTORY_INDEX]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt()) {
				++this.duplicatorDupledTime2;

				if (this.duplicatorDupledTime2 == getTimeRequired(inventory[INPUT_INVENTORY_INDEX])) {
					this.duplicatorDupledTime2 = 0;
					this.smeltItem();
					flag1 = true;
				}

			} else {

				this.duplicatorDupledTime2 = 0;

			}

			if (flag != this.duplicatorDupleTime > 0) {
				flag1 = true;
			}

		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	private boolean canSmelt() {

		if (this.inventory[INPUT_INVENTORY_INDEX] == null) {

			return false;

		} else {

			ItemStack itemstack = DuplicatorRecipes.dupling().getDuplingResult(this.inventory[INPUT_INVENTORY_INDEX]);

			if (itemstack == null) return false;
			if (this.inventory[OUTPUT_INVENTORY_INDEX] == null) return true;
			if (!this.inventory[OUTPUT_INVENTORY_INDEX].isItemEqual(itemstack)) return false;
			int result = inventory[OUTPUT_INVENTORY_INDEX].stackSize + itemstack.stackSize;

			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}

	public void smeltItem() {

		if (this.canSmelt()) {

			ItemStack itemstack = DuplicatorRecipes.dupling().getDuplingResult(this.inventory[INPUT_INVENTORY_INDEX]);

			if (this.inventory[OUTPUT_INVENTORY_INDEX] == null) {

				this.inventory[OUTPUT_INVENTORY_INDEX] = itemstack.copy();

			} else if (this.inventory[OUTPUT_INVENTORY_INDEX].isItemEqual(itemstack)) {

				inventory[OUTPUT_INVENTORY_INDEX].stackSize += itemstack.stackSize;

			}

			--this.inventory[INPUT_INVENTORY_INDEX].stackSize;

			if (this.inventory[INPUT_INVENTORY_INDEX].stackSize <= 0) {
				this.inventory[INPUT_INVENTORY_INDEX] = null;
			}
		}
	}

	public static int getItemBurnTime(ItemStack itemStack) {

		if (itemStack == null) {
			return 0;
		}

		int i = itemStack.getItem().itemID;
		int meta = itemStack.getItemDamage();

		if (i == ModItems.soroniteDust.itemID && meta == 0) return 400;

		return GameRegistry.getFuelValue(itemStack);
	}

	public static boolean isItemFuel(ItemStack itemStack) {

		return getItemBurnTime(itemStack) > 0;
	}

	public static int getTimeRequired(ItemStack stack) {

		if (stack != null) {
			if (stack.itemID == ModItems.soroniteIngot.itemID) {
				return 1000;
			}

			if (stack.itemID == Item.diamond.itemID || stack.itemID == Item.emerald.itemID || (stack.itemID == Item.appleGold.itemID && stack.getItemDamage() == 1)) {
				return 800;
			}

			else if (stack.itemID == Item.ingotIron.itemID || stack.itemID == Item.ingotGold.itemID || (stack.itemID == Item.appleGold.itemID && stack.getItemDamage() == 0) || stack.itemID == Item.brick.itemID || stack.itemID == Item.blazePowder.itemID) {
				return 600;
			}
		}

		return 400;
	}

}
