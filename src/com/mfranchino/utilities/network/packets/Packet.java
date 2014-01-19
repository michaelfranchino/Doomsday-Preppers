/*
 * Copyright (C) 2014 mfranchino
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mfranchino.utilities.network.packets;

import com.mfranchino.utilities.network.Client;
import com.mfranchino.utilities.network.Server;

/**
 *
 * @author mfranchino
 */
public abstract class Packet {
	
	public static enum PacketTypes {
		INVALID(-1),
		LOGIN(01),
		LOGOUT(02);
		
		private int packetId;
		
		private PacketTypes(int packetId) {
			this.packetId = packetId;
		}
		
		public byte getId() {
			return (byte) packetId;
		}
	}
	
	public byte packetId;
	public Packet(int packetId) {
		this.packetId = (byte) packetId;
	}
	
	public abstract void writeData(Client client);
	public abstract void writeData(Server server);
	public abstract byte[] getData();
	
	public String readData(byte[] data) {
		String message = new String(data).trim();
		return message.substring(2);
	}
	
	public static PacketTypes lookupPacket(int id) {
		for (PacketTypes p : PacketTypes.values()) {
			if (p.getId() == id) {
				return p;
			}
		}
		return PacketTypes.INVALID;
	}
}
