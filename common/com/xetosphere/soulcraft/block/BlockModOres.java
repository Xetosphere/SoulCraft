package com.xetosphere.soulcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.item.ModItems;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModOres extends Block {

	public BlockModOres(int id) {

		super(id, Material.rock);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.ORE_NAME);
		setCreativeTab(SoulCraft.tabSC);
		setHardness(3.0F);
		setResistance(8.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		blockIcon = iconRegister.registerIcon(getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
	}

	@Override
	public int idDropped(int id, Random random, int meta) {

		return ModItems.soroniteDust.itemID;
	}

	@Override
	public int quantityDropped(Random random) {

		int quantity = random.nextInt(3) + 1;
		return quantity;
	}

}
