package com.xetosphere.soulcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Elements;
import com.xetosphere.soulcraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTotem extends Block {

	private int element;

	public BlockTotem(int id, String name, int element) {

		super(id, Material.wood);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + name);
		setCreativeTab(SoulCraft.tabSC);
		setHardness(3.0F);
		setResistance(12.0F);
		this.element = element;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		blockIcon = iconRegister.registerIcon(getUnlocalizedName().substring(getUnlocalizedName().indexOf('.') + 1));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

		ItemStack activeItem = player.inventory.getCurrentItem();

		if (player.isSneaking()) {

			return false;

		} else {

			if (activeItem == null) {

				return false;
			}

			if (element == Elements.AIR) {

				if (activeItem.itemID == Item.goldNugget.itemID) {

					player.addPotionEffect(new PotionEffect(1, 1200, 0, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(12, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(3, 600, 0, false));
					}
				}

				if (activeItem.itemID == Item.ingotGold.itemID) {

					player.addPotionEffect(new PotionEffect(1, 2400, 0, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(12, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(3, 600, 0, false));
					}
				}

				if (activeItem.itemID == Block.blockGold.blockID) {

					player.addPotionEffect(new PotionEffect(1, 3000, 1, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(12, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(3, 600, 0, false));
					}
				}

			}

			else if (element == Elements.FIRE) {

				if (activeItem.itemID == Item.goldNugget.itemID) {

					player.addPotionEffect(new PotionEffect(12, 1200, 0, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(1, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(3, 600, 0, false));
					}
				}

				if (activeItem.itemID == Item.ingotGold.itemID) {

					player.addPotionEffect(new PotionEffect(12, 2400, 0, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(1, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(3, 600, 0, false));
					}
				}

				if (activeItem.itemID == Block.blockGold.blockID) {

					player.addPotionEffect(new PotionEffect(12, 3000, 1, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(1, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(3, 600, 0, false));
					}
				}

			}

			else if (element == Elements.WATER) {

				if (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

					player.addPotionEffect(new PotionEffect(12, 600, 0, false));
				}

				if (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

					player.addPotionEffect(new PotionEffect(1, 600, 0, false));
				}

				if (world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.earthTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.earthTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.earthTotem.blockID))) {

					player.addPotionEffect(new PotionEffect(3, 600, 0, false));
				}

				if (activeItem.itemID == Item.goldNugget.itemID) {

					player.addPotionEffect(new PotionEffect(13, 1200, 0, false));
					activeItem.stackSize -= 1;
				}

				if (activeItem.itemID == Item.ingotGold.itemID) {

					player.addPotionEffect(new PotionEffect(13, 2400, 0, false));
					activeItem.stackSize -= 1;
				}

				if (activeItem.itemID == Block.blockGold.blockID) {

					player.addPotionEffect(new PotionEffect(13, 3000, 1, false));
					activeItem.stackSize -= 1;
				}

			} else if (element == Elements.EARTH) {

				if (activeItem.itemID == Item.goldNugget.itemID) {

					player.addPotionEffect(new PotionEffect(3, 1200, 0, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(12, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(1, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}
				}

				if (activeItem.itemID == Item.ingotGold.itemID) {

					player.addPotionEffect(new PotionEffect(3, 2400, 0, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(12, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(1, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}
				}

				if (activeItem.itemID == Block.blockGold.blockID) {

					player.addPotionEffect(new PotionEffect(3, 3000, 1, false));
					activeItem.stackSize -= 1;

					if (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.fireTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(12, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.airTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(1, 600, 0, false));
					}

					if (world.getBlockId(x, y - 1, z) == ModBlocks.waterTotem.blockID || (world.getBlockId(x, y - 2, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID)) || (world.getBlockId(x, y - 3, z) == ModBlocks.waterTotem.blockID && (world.getBlockId(x, y - 1, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 1, z) == ModBlocks.airTotem.blockID) && (world.getBlockId(x, y - 2, z) == ModBlocks.fireTotem.blockID || world.getBlockId(x, y - 2, z) == ModBlocks.airTotem.blockID))) {

						player.addPotionEffect(new PotionEffect(13, 600, 0, false));
					}
				}
			}

		}

		return true;
	}

}
