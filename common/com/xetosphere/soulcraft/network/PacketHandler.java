package com.xetosphere.soulcraft.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.xetosphere.soulcraft.network.packet.PacketSC;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		PacketSC packetSC = PacketTypeHandler.buildPacket(packet.data);

		packetSC.execute(manager, player);
	}

}
