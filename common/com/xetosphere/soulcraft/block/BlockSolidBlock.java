package com.xetosphere.soulcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSolidBlock extends Block {

	public BlockSolidBlock(int id) {

		super(id, Material.rock);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.BLOCK_NAME);
		setCreativeTab(SoulCraft.tabSC);
		setHardness(3.0F);
		setResistance(8.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		blockIcon = iconRegister.registerIcon(getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
	}

}
