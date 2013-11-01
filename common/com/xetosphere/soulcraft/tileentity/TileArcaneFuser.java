package com.xetosphere.soulcraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.xetosphere.soulcraft.item.ModItems;
import com.xetosphere.soulcraft.lib.Strings;
import com.xetosphere.soulcraft.recipe.ArcaneFuserRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileArcaneFuser extends TileSC implements IInventory {

	private ItemStack[] inventory;

	public static final int INVENTORY_SIZE = 4;

	public static final int INPUT_INVENTORY_INDEX = 0;
	public static final int DUST_INVENTORY_INDEX = 1;
	public static final int FUEL_INVENTORY_INDEX = 2;
	public static final int OUTPUT_INVENTORY_INDEX = 3;

	public static final int FUSION_TIME = 200;

	public int fuserFuseTime;
	public int currentItemFuseTime;
	public int fuserFusedTime2;

	public TileArcaneFuser() {

		inventory = new ItemStack[INVENTORY_SIZE];
	}

	public int getSizeInventory() {

		return inventory.length;
	}

	public ItemStack getStackInSlot(int slot) {

		return inventory[slot];
	}

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

	public ItemStack getStackInSlotOnClosing(int slot) {

		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			setInventorySlotContents(slot, null);
		}

		return itemStack;
	}

	public void setInventorySlotContents(int slot, ItemStack itemStack) {

		inventory[slot] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
			itemStack.stackSize = getInventoryStackLimit();
		}
	}

	public String getInvName() {

		return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_ARCANE_FUSER_NAME;
	}

	public int getInventoryStackLimit() {

		return 64;
	}

	public void openChest() {

	}

	public void closeChest() {

	}

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

			this.fuserFuseTime = nbtTagCompound.getShort("FuseTime");
			this.fuserFusedTime2 = nbtTagCompound.getShort("TimeSpent");
		}
	}

	public void writeToNBT(NBTTagCompound nbtTagCompound) {

		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setShort("FuseTime", (short) this.fuserFuseTime);
		nbtTagCompound.setShort("TimeSpent", (short) this.fuserFusedTime2);

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

	public boolean isInvNameLocalized() {

		return this.hasCustomName();
	}

	public boolean isItemValidForSlot(int i, ItemStack itemStack) {

		return true;
	}

	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(super.toString());

		stringBuilder.append("TileArcaneFuser Data - ");
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

		return this.fuserFusedTime2 * par1 / FUSION_TIME;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {

		if (this.currentItemFuseTime == 0) {
			this.currentItemFuseTime = FUSION_TIME;
		}

		return this.fuserFuseTime * par1 / this.currentItemFuseTime;
	}

	public boolean isBurning() {

		return this.fuserFuseTime > 0;
	}

	public void updateEntity() {

		boolean flag = this.fuserFuseTime > 0;
		boolean flag1 = false;

		if (this.fuserFuseTime > 0) {
			--this.fuserFuseTime;
		}

		if (!this.worldObj.isRemote) {
			if (this.fuserFuseTime == 0 && this.canSmelt()) {
				this.currentItemFuseTime = this.fuserFuseTime = getItemBurnTime(this.inventory[FUEL_INVENTORY_INDEX]);
				if (this.fuserFuseTime > 0) {
					flag1 = true;
					if (this.inventory[FUEL_INVENTORY_INDEX] != null) {
						--this.inventory[FUEL_INVENTORY_INDEX].stackSize;
						if (this.inventory[FUEL_INVENTORY_INDEX].stackSize == 0) {
							this.inventory[FUEL_INVENTORY_INDEX] = this.inventory[FUEL_INVENTORY_INDEX].getItem().getContainerItemStack(inventory[FUEL_INVENTORY_INDEX]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt()) {
				++this.fuserFusedTime2;

				if (this.fuserFusedTime2 == FUSION_TIME) {
					this.fuserFusedTime2 = 0;
					this.smeltItem();
					flag1 = true;
				}

			} else {

				this.fuserFusedTime2 = 0;

			}

			if (flag != this.fuserFuseTime > 0) {
				flag1 = true;
			}

		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	private boolean canSmelt() {

		if (this.inventory[INPUT_INVENTORY_INDEX] == null || this.inventory[DUST_INVENTORY_INDEX] == null) {

			return false;

		} else {

			ItemStack itemstack = ArcaneFuserRecipes.fusing().getFusingResult(this.inventory[INPUT_INVENTORY_INDEX].getItem().itemID, this.inventory[INPUT_INVENTORY_INDEX].getItemDamage(), this.inventory[DUST_INVENTORY_INDEX].getItem().itemID, this.inventory[DUST_INVENTORY_INDEX].getItemDamage());

			if (itemstack == null) return false;
			if (this.inventory[OUTPUT_INVENTORY_INDEX] == null) return true;
			if (!this.inventory[OUTPUT_INVENTORY_INDEX].isItemEqual(itemstack)) return false;
			int result = inventory[OUTPUT_INVENTORY_INDEX].stackSize + itemstack.stackSize;

			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}

	public void smeltItem() {

		if (this.canSmelt()) {

			ItemStack itemstack = ArcaneFuserRecipes.fusing().getFusingResult(this.inventory[INPUT_INVENTORY_INDEX].getItem().itemID, this.inventory[INPUT_INVENTORY_INDEX].getItemDamage(), this.inventory[DUST_INVENTORY_INDEX].getItem().itemID, this.inventory[DUST_INVENTORY_INDEX].getItemDamage());

			if (this.inventory[OUTPUT_INVENTORY_INDEX] == null) {

				this.inventory[OUTPUT_INVENTORY_INDEX] = itemstack.copy();

			} else if (this.inventory[OUTPUT_INVENTORY_INDEX].isItemEqual(itemstack)) {

				inventory[OUTPUT_INVENTORY_INDEX].stackSize += itemstack.stackSize;

			}

			--this.inventory[INPUT_INVENTORY_INDEX].stackSize;
			--this.inventory[DUST_INVENTORY_INDEX].stackSize;

			if (this.inventory[INPUT_INVENTORY_INDEX].stackSize <= 0) {
				this.inventory[INPUT_INVENTORY_INDEX] = null;
			}

			if (this.inventory[DUST_INVENTORY_INDEX].stackSize <= 0) {
				this.inventory[DUST_INVENTORY_INDEX] = null;
			}
		}
	}

	public static int getItemBurnTime(ItemStack itemStack) {

		if (itemStack == null) {
			return 0;
		}

		int i = itemStack.getItem().itemID;
		Item item = itemStack.getItem();

		if (itemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null) {
			Block block = Block.blocksList[i];

			if (block == Block.woodSingleSlab) {
				return 150;
			}

			if (block.blockMaterial == Material.wood) {
				return 300;
			}

			if (block == Block.coalBlock) {
				return 16000;
			}
		}

		if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
		if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
		if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
		if (i == Item.stick.itemID) return 100;
		if (i == Item.coal.itemID) return 1600;
		if (i == Item.bucketLava.itemID) return 20000;
		if (i == Block.sapling.blockID) return 100;
		if (i == Item.blazeRod.itemID) return 2400;
		return GameRegistry.getFuelValue(itemStack);
	}

	public static boolean isItemFuel(ItemStack itemStack) {

		return getItemBurnTime(itemStack) > 0;
	}

	public static boolean isItemDust(ItemStack itemStack) {

		if (itemStack.itemID == ModItems.soroniteDust.itemID) {
			return true;
		} else {

			return false;
		}
	}

}
