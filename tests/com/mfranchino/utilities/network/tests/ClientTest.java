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
package com.mfranchino.utilities.network.tests;

import com.mfranchino.engine.framework.game.Client;
import com.mfranchino.engine.framework.game.Server;
import java.awt.Canvas;
import javax.swing.JOptionPane;

/**
 *
 * @author mfranchino
 */
public class ClientTest extends Canvas implements Runnable {

	public Client client;
	public Server server;
	private boolean running;

	private void init() {
		System.out.println("In Init");
		client.sendData("ping".getBytes());
	}

	public synchronized void start() {
		running = true;
		
		if (JOptionPane.showConfirmDialog(this, "Do you want to run the server") == 0) {
			System.out.println("Creating server");
			server = new Server(1331, "Our Game Server");
			server.start();
		}

		System.out.println("Creating client");
		client = new Client("localhost");
		client.start();
		
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void run() {

		System.out.println("In running");
		init();

		while (running) {

		}
	}

	public static void main(String[] args) {
		ClientTest test = new ClientTest();

		test.start();

	}

}