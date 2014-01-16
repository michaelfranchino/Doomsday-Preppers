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

//~--- JDK imports ------------------------------------------------------------
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ChatServer implements Runnable {
	String              message = "";
	private Scanner     input;
	private PrintWriter output;
	Socket              socket;

	ChatServer(Socket socket) {
		this.socket = socket;
	}

	public void checkConnection() throws IOException {
		if (!socket.isConnected()) {
			for (int i = 0; i < Server.connectionArray.size(); i++) {
				if (Server.connectionArray.get(i) == socket) {
					Server.connectionArray.remove(i);
				}
			}

			for (Socket temp : Server.connectionArray) {
				PrintWriter tempOut = new PrintWriter(temp.getOutputStream());

				tempOut.println(temp.getLocalAddress().getHostName() + " disconnected!");
				tempOut.flush();
				System.out.println(temp.getLocalAddress().getHostName() + " disconnecte!");
			}
		}
	}

	@Override
	public void run() {
		try {
			try {
				input  = new Scanner(socket.getInputStream());
				output = new PrintWriter(socket.getOutputStream());

				while (true) {
					checkConnection();

					if (!input.hasNext()) {
						return;
					}

					message = input.nextLine();
					System.out.println("Client said: " + message);

					for (Socket temp : Server.connectionArray) {
						PrintWriter tempOut = new PrintWriter(temp.getOutputStream());

						tempOut.println(message);
						tempOut.flush();
						System.out.println("Sent to: " + temp.getLocalAddress().getHostName());
					}
				}
			} finally {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}