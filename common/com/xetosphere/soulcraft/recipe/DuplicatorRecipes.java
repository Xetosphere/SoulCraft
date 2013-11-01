package com.xetosphere.soulcraft.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xetosphere.soulcraft.item.ModItems;

public class DuplicatorRecipes {

	private static final DuplicatorRecipes duplingBase = new DuplicatorRecipes();

	@SuppressWarnings("rawtypes")
	private Map duplingList = new HashMap();
	private HashMap<List<Integer>, ItemStack> metaDuplingList = new HashMap<List<Integer>, ItemStack>();

	public static final DuplicatorRecipes dupling() {

		return duplingBase;
	}

	private DuplicatorRecipes() {

		// 400
		addDupling(Item.coal.itemID, 0, new ItemStack(Item.coal, 2, 0));
		addDupling(Item.coal.itemID, 1, new ItemStack(Item.coal, 2, 1));
		addDupling(Item.appleRed.itemID, new ItemStack(Item.appleRed, 2));
		addDupling(Item.clay.itemID, new ItemStack(Item.clay, 2));
		addDupling(Item.arrow.itemID, new ItemStack(Item.arrow, 2));
		addDupling(Item.wheat.itemID, new ItemStack(Item.wheat, 2));
		addDupling(Item.bone.itemID, new ItemStack(Item.bone, 2));
		addDupling(Item.stick.itemID, new ItemStack(Item.stick, 2));

		// 600
		addDupling(Item.ingotIron.itemID, new ItemStack(Item.ingotIron, 2, 0));
		addDupling(Item.ingotGold.itemID, new ItemStack(Item.ingotGold, 2, 0));
		addDupling(Item.appleGold.itemID, 0, new ItemStack(Item.appleGold, 2, 0));
		addDupling(Item.blazePowder.itemID, new ItemStack(Item.blazePowder, 2));
		addDupling(Item.brick.itemID, new ItemStack(Item.brick, 2));

		// 800
		addDupling(Item.appleGold.itemID, 1, new ItemStack(Item.appleGold, 2, 1));
		addDupling(Item.diamond.itemID, new ItemStack(Item.diamond, 2, 0));
		addDupling(Item.emerald.itemID, new ItemStack(Item.emerald, 2));

		// 1000
		addDupling(ModItems.soroniteIngot.itemID, 0, new ItemStack(ModItems.soroniteIngot, 2));
	}

	@SuppressWarnings("unchecked")
	public void addDupling(int par1, ItemStack par2ItemStack) {

		this.duplingList.put(Integer.valueOf(par1), par2ItemStack);
	}

	@Deprecated
	public ItemStack getDuplingResult(int par1) {

		return (ItemStack) this.duplingList.get(Integer.valueOf(par1));
	}

	@SuppressWarnings("rawtypes")
	public Map getDuplingList() {

		return this.duplingList;
	}

	public void addDupling(int itemID, int metadata, ItemStack itemstack) {

		metaDuplingList.put(Arrays.asList(itemID, metadata), itemstack);
	}

	public ItemStack getDuplingResult(ItemStack item) {

		if (item == null) {
			return null;
		}

		ItemStack ret = (ItemStack) metaDuplingList.get(Arrays.asList(item.itemID, item.getItemDamage()));

		if (ret != null) {
			return ret;
		}

		return (ItemStack) duplingList.get(Integer.valueOf(item.itemID));
	}

	public Map<List<Integer>, ItemStack> getMetaSmeltingList() {

		return metaDuplingList;
	}

}
