package com.xetosphere.soulcraft.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

import com.xetosphere.soulcraft.SoulCraft;
import com.xetosphere.soulcraft.lib.Reference;
import com.xetosphere.soulcraft.lib.Strings;

public class ItemPaxel extends ItemTool {

	public static final Block[] blocksEffectiveAgainst = new Block[] { Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator, Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium };

	public ItemPaxel(int par1, EnumToolMaterial par2EnumToolMaterial) {

		super(par1 - Reference.SHIFTED_ID_RANGE_CORRECTION, 2.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITE_PAXEL_NAME);
		setCreativeTab(SoulCraft.tabSC);
	}

	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {

		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par5Boolean) {

		list.add("Uses: " + (this.getMaxDamage() - itemStack.getItemDamage()));
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;

		} else {

			UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);

			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}

			if (event.getResult() == Result.ALLOW) {
				par1ItemStack.damageItem(1, par2EntityPlayer);
				return true;
			}

			int i1 = par3World.getBlockId(par4, par5, par6);
			boolean air = par3World.isAirBlock(par4, par5 + 1, par6);

			if (par7 != 0 && air && (i1 == Block.grass.blockID || i1 == Block.dirt.blockID)) {

				Block block = Block.tilledField;
				par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

				if (par3World.isRemote) {

					return true;

				} else {
					par3World.setBlock(par4, par5, par6, block.blockID);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}

			} else {
				return false;
			}
		}
	}

	public boolean canHarvestBlock(Block par1Block) {

		return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() >= 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) || par1Block == Block.snow ? true : par1Block == Block.blockSnow;
	}

	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {

		return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock || par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine || par2Block.blockMaterial == Material.snow) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}

}
