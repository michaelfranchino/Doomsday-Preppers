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
public class Packet_Login extends Packet {
	private String userName;
	private final byte packetId = PacketTypes.LOGIN.getId();

	public Packet_Login(byte[] data) {
		super(PacketTypes.LOGIN.getId());
		this.userName = readData(data);
	}
	
	public Packet_Login(String userName) {
		super(PacketTypes.LOGIN.getId());
		this.userName = userName;
	}

	@Override
	public void writeData(Client client) {
	//	client.send(getData());
	}

	@Override
	public void writeData(Server server) {
	}

	@Override
	public byte[] getData() {
		return (packetId + userName).getBytes();
	}
}