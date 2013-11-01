package com.xetosphere.soulcraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Reference;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoul extends ItemSC {

	private static final String[] SOUL_NAMES = new String[] { "Empty", "Zombie", "Spider", "Creeper", "Enderman", "ZombiePigman", "Sheep", "Cow", "Blaze", "Skeleton", "WitherSkeleton", "Slime", "MagmaCube", "SilverFish", "CaveSpider", "Witch", "Pig", "Horse", "Chicken", "Bat" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemSoul(int id) {

		super(id);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SOUL_NAME);
		setHasSubtypes(true);
		setCreativeTab(SoulCraft.tabSC);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {

		StringBuilder unlocalizedName = new StringBuilder();
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, SOUL_NAMES.length);

		unlocalizedName.append("item.");
		unlocalizedName.append(Strings.RESOURCE_PREFIX);
		unlocalizedName.append(Strings.SOUL_NAME);
		unlocalizedName.append(SOUL_NAMES[meta]);

		return unlocalizedName.toString();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {

		int j = MathHelper.clamp_int(meta, 0, SOUL_NAMES.length);
		return icons[j];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[SOUL_NAMES.length];

		for (int i = 0; i < SOUL_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.SOUL_NAME + SOUL_NAMES[i]);
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs creativeTab, List list) {

		for (int meta = 0; meta < SOUL_NAMES.length; ++meta) {
			list.add(new ItemStack(id, 1, meta));
		}
	}

}
