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

package com.mfranchino.engine.framework.game;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mfranchino
 */
public class Server extends Thread {
	private final int port;
	private DatagramSocket socket;
	private final String name;
	private ServerManager serverManager;
	private List<Client> connectedClients = new ArrayList<>();
	
	/**
	 *
	 * @param port
	 * @param name
	 */
	public Server (int port, String name) {
		this.port = port;
		this.name = name;
		
		try {
			this.socket = new DatagramSocket(port);
		} catch (SocketException e) {
				e.printStackTrace();
		}
	}
	
	public Server(ServerManager serverManager, int port, String name) {
		this(port, name);
		this.serverManager = serverManager;
	}
	
	private void addClient(Client client) {
		connectedClients.add(client);
	}
	
	private void removeClient(Client client) {
		connectedClients.remove(client);
	}
	
	private void disconnectClient(Client client) {
		// TODO add code to disconnect session
	}
	
	private void init() {
		
	}
	
	public void run() {
		System.out.println("In server - running");
		while (true) {
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			String message = new String(packet.getData());
			System.out.println("CLIENT [" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + "]> " + message);
			if (message.trim().equalsIgnoreCase("ping")) {
				sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
			}
		}
	}
	
	public void sendData(byte[] data, InetAddress ipAddress, int port) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port );
		try {
			socket.send(packet);
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	// ipAddress/port should be in the client to communicate with
//	public void sendData(byte[] data, InetAddress ipAddress, int port) {
//		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
//		try {
//			this.socket().send(packet);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public int getConnectedClientCount() {
		return connectedClients.size();
	}
	
}
