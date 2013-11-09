package com.xetosphere.soulcraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.xetosphere.soulcraft.inventory.ContainerAuraCrusher;
import com.xetosphere.soulcraft.lib.Strings;
import com.xetosphere.soulcraft.lib.Textures;
import com.xetosphere.soulcraft.tileentity.TileAuraCrusher;

public class GuiAuraCrusher extends GuiContainer {

	private TileAuraCrusher tileAuraCrusher;

	public GuiAuraCrusher(InventoryPlayer player, TileAuraCrusher tileAuraCrusher) {

		super(new ContainerAuraCrusher(player, tileAuraCrusher));
		this.tileAuraCrusher = tileAuraCrusher;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {

		String containerName = tileAuraCrusher.isInvNameLocalized() ? tileAuraCrusher.getInvName() : StatCollector.translateToLocal(tileAuraCrusher.getInvName());
		fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.getTextureManager().bindTexture(Textures.GUI_AURA_CRUSHER);

		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;

		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

		int i1;

		if (this.tileAuraCrusher.isBurning()) {
			i1 = this.tileAuraCrusher.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(xStart + 56, yStart + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}

		i1 = this.tileAuraCrusher.getCookProgressTimeScaled(24);
		this.drawTexturedModalRect(xStart + 79, yStart + 34, 176, 14, i1 + 1, 16);
	}

}
