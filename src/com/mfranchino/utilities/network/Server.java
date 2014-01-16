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



package com.mfranchino.utilities.network;

//~--- non-JDK imports --------------------------------------------------------

import com.mfranchino.doomsday.game.Configuration;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.net.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mfranchino
 */
public class Server {
	public static ArrayList<Socket> connectionArray = new ArrayList<>();
	public static ArrayList<String> currentUsers    = new ArrayList<>();
	private final int               serverPort      = Configuration.SERVER_SOCKET;

	public static void main(String[] args) throws Exception {
		Server server = new Server();

		server.run();
	}

	public void run() throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);

			System.out.println("Waiting for clients....");

			while (true) {
				Socket socket = serverSocket.accept();

				connectionArray.add(socket);
				System.out.println("Client connected from: " + socket.getLocalAddress().getHostName());
				addUserName(socket);

				ChatServer chatServer = new ChatServer(socket);
				Thread     thread     = new Thread((Runnable) chatServer);

				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addUserName(Socket socket) throws IOException {
		Scanner input    = new Scanner(socket.getInputStream());
		String  userName = input.nextLine();

		currentUsers.add(userName);

		for (Socket temp : connectionArray) {
			PrintWriter out = new PrintWriter(temp.getOutputStream());

			out.println("#?!" + currentUsers);
			out.flush();
		}
	}
}


//~ Formatted by Jindent --- http://www.jindent.com
