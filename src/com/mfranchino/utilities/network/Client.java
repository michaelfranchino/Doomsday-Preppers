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
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client implements Runnable {
	Scanner     send = new Scanner(System.in);
	Scanner     input;
	PrintWriter output;
	Socket      socket;

	Client(Socket socket) {
		this.socket = socket;
	}

	public void checkStream() {
		while (true) {
			receive();
		}
	}

	public void disconnect() throws IOException {
		output.println(ClientGUI.userName + " has disconnected");
		output.flush();
		socket.close();
		JOptionPane.showMessageDialog(null, "You disconnected");
		System.exit(0);
	}

	public void receive() {
		if (input.hasNext()) {
			String message = input.nextLine();

			if (message.contains("#?!")) {
				String temp1 = message.substring(3);

				temp1 = temp1.replace("[", "");
				temp1 = temp1.replace("]", "");

				String[] currentUsers = temp1.split(", ");

				ClientGUI.online.setListData(currentUsers);
			} else {
				ClientGUI.conversation.append(message + "\n");
			}
		}
	}

	@Override
	public void run() {
		try {
			try {
				input  = new Scanner(socket.getInputStream());
				output = new PrintWriter(socket.getOutputStream());
				output.flush();
				checkStream();
			} finally {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String message) {
		output.println(ClientGUI.userName + ": " + message);
		output.flush();
		ClientGUI.message.setText("");
	}
}