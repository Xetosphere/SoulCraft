package com.xetosphere.soulcraft.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.xetosphere.soulcraft.lib.Reference;
import com.xetosphere.soulcraft.network.packet.PacketSC;
import com.xetosphere.soulcraft.network.packet.PacketTileUpdate;
import com.xetosphere.soulcraft.network.packet.PacketTileWithItemUpdate;

public enum PacketTypeHandler {
	TILE(PacketTileUpdate.class), TILE_WITH_ITEM(PacketTileWithItemUpdate.class);

	private Class<? extends PacketSC> clazz;

	PacketTypeHandler(Class<? extends PacketSC> clazz) {

		this.clazz = clazz;
	}

	public static PacketSC buildPacket(byte[] data) {

		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		int selector = bis.read();
		DataInputStream dis = new DataInputStream(bis);

		PacketSC packet = null;

		try {
			packet = values()[selector].clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		packet.readPopulate(dis);

		return packet;
	}

	public static PacketSC buildPacket(PacketTypeHandler type) {

		PacketSC packet = null;

		try {
			packet = values()[type.ordinal()].clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return packet;
	}

	public static Packet populatePacket(PacketSC packetSC) {

		byte[] data = packetSC.populate();

		Packet250CustomPayload packet250 = new Packet250CustomPayload();
		packet250.channel = Reference.CHANNEL_NAME;
		packet250.data = data;
		packet250.length = data.length;
		packet250.isChunkDataPacket = packetSC.isChunkDataPacket;

		return packet250;
	}

}
