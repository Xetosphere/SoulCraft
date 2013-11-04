package com.xetosphere.soulcraft.core.proxy;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import com.xetosphere.soulcraft.tileentity.TileSC;

import cpw.mods.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void initRenderingAndTextures() {

	}

	@Override
	public void registerTileEntities() {

		super.registerTileEntities();
	}

	@Override
	public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

		TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

		if (tileEntity != null) {
			if (tileEntity instanceof TileSC) {
				((TileSC) tileEntity).setOrientation(orientation);
				((TileSC) tileEntity).setState(state);
				((TileSC) tileEntity).setCustomName(customName);
			}
		}
	}

	@Override
	public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

		this.handleTileEntityPacket(x, y, z, orientation, state, customName);
	}

}
