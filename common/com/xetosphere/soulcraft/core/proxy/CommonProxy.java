package com.xetosphere.soulcraft.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.xetosphere.soulcraft.client.gui.inventory.GuiArcaneFuser;
import com.xetosphere.soulcraft.client.gui.inventory.GuiDuplicator;
import com.xetosphere.soulcraft.inventory.ContainerArcaneFuser;
import com.xetosphere.soulcraft.inventory.ContainerDuplicator;
import com.xetosphere.soulcraft.lib.GuiIDs;
import com.xetosphere.soulcraft.lib.Reference;
import com.xetosphere.soulcraft.lib.Strings;
import com.xetosphere.soulcraft.tileentity.TileArcaneFuser;
import com.xetosphere.soulcraft.tileentity.TileDuplicator;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

	public void initRenderingAndTextures() {

	}

	public void registerTileEntities() {

		GameRegistry.registerTileEntity(TileDuplicator.class, Reference.MOD_ID + Strings.DUPLICATOR_NAME);
		GameRegistry.registerTileEntity(TileArcaneFuser.class, Reference.MOD_ID + Strings.ARCANE_FUSER_NAME);
	}

	public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

	}

	public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

	}

	public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {


		if (ID == GuiIDs.DUPLICATOR) {

			TileDuplicator tileDuplicator = (TileDuplicator) world.getBlockTileEntity(x, y, z);
			return new ContainerDuplicator(player.inventory, tileDuplicator);
		}
		
		else if (ID == GuiIDs.ARCANE_FUSER) {

			TileArcaneFuser tileFuser = (TileArcaneFuser) world.getBlockTileEntity(x, y, z);
			return new ContainerArcaneFuser(player.inventory, tileFuser);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == GuiIDs.DUPLICATOR) {

			TileDuplicator tileDuplicator = (TileDuplicator) world.getBlockTileEntity(x, y, z);
			return new GuiDuplicator(player.inventory, tileDuplicator);
		}

		else if (ID == GuiIDs.ARCANE_FUSER) {

			TileArcaneFuser tileFuser = (TileArcaneFuser) world.getBlockTileEntity(x, y, z);
			return new GuiArcaneFuser(player.inventory, tileFuser);
		}

		return null;
	}

}
