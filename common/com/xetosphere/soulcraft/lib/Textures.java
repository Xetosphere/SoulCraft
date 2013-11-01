package com.xetosphere.soulcraft.lib;

import net.minecraft.util.ResourceLocation;

import com.xetosphere.soulcraft.core.util.ResourceLocationHelper;

public class Textures {

	// Base file paths
	public static final String ARMOR_SHEET_LOCATION = "textures/armour/";
	public static final String GUI_SHEET_LOCATION = "textures/gui/";

	// GUI textures
	public static final ResourceLocation GUI_ARCANE_FUSER = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "arcaneFuser.png");
	public static final ResourceLocation GUI_DUPLICATOR = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "duplicator.png");
	public static final ResourceLocation GUI_AURA_CRUSHER = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "auraCrusher.png");
}
