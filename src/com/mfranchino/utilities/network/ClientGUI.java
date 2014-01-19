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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClientGUI {
	public static String       userName        = "Anonymous";
	public static JFrame       mainWindow      = new JFrame();
	private static JButton     about           = new JButton();
	private static JButton     connect         = new JButton();
	private static JButton     disconnect      = new JButton();
	private static JButton     help            = new JButton();
	private static JButton     send            = new JButton();
	private static JLabel      message_L       = new JLabel("Message: ");
	public static JTextField   message         = new JTextField(20);
	private static JLabel      conversation_L  = new JLabel();
	public static JTextArea    conversation    = new JTextArea();
	private static JScrollPane conversation_SP = new JScrollPane();
	private static JLabel      online_L        = new JLabel();
	public static JList        online          = new JList();
	private static JScrollPane online_SP       = new JScrollPane();
	private static JLabel      loggedInAs_L    = new JLabel();
	private static JLabel      loggedInAsBox_L = new JLabel();
	public static JFrame       logInWindow     = new JFrame();
	public static JTextField   userNameBox     = new JTextField(20);
	private static JButton     enter           = new JButton("ENTER");
	private static JLabel      enterUsername_L = new JLabel("Enter username: ");
	private static JPanel      login           = new JPanel();
	private static Client      client;

	public static void action_Button_About() {
		JOptionPane.showMessageDialog(null, "Java chat client");
	}

	public static void action_Button_Disconnect() {
		try {
			client.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void action_Button_Enter() {
		if (!userNameBox.getText().equals("")) {
			userName = userNameBox.getText().trim();
			loggedInAsBox_L.setText(userName);
			Server.currentUsers.add(userName);
			mainWindow.setTitle(userName + "'s chat box");
			logInWindow.setVisible(false);
			send.setEnabled(true);
			disconnect.setEnabled(true);
			connect.setEnabled(false);
			connect();
		} else {
			JOptionPane.showMessageDialog(null, "Please enter a name..");
		}
	}

	public static void action_Button_Help() {
		JOptionPane.showMessageDialog(null, "Java chat client help");
	}

	public static void action_Button_Send() {
		if (!message.getText().equals("")) {
			client.send(message.getText());
			message.requestFocus();
		}
	}

	public static void buildLogInWindow() {
		logInWindow.setTitle("What's your name?");
		logInWindow.setSize(400, 100);
		logInWindow.setLocation(250, 200);
		logInWindow.setResizable(false);
		login = new JPanel();
		login.add(enterUsername_L);
		login.add(userNameBox);
		login.add(enter);
		logInWindow.add(login);

		login_Action();
		logInWindow.setVisible(true);
	}

	public static void buildMainWindow() {
		mainWindow.setTitle(userName + "' chat box");
		mainWindow.setSize(450, 500);
		mainWindow.setLocation(220, 180);
		mainWindow.setResizable(false);
		configureMainWindow();
		mainWindow_Action();
		mainWindow.setVisible(true);
	}

	public static void configureMainWindow() {
		mainWindow.setBackground(new Color(255, 255, 255));
		mainWindow.setSize(500, 320);
		mainWindow.getContentPane().setLayout(null);

		send.setBackground(Color.BLUE);
		send.setForeground(Color.WHITE);
		send.setText("SEND");
		mainWindow.getContentPane().add(send);
		send.setBounds(250, 40, 81, 25);

		disconnect.setBackground(Color.BLUE);
		disconnect.setForeground(Color.WHITE);
		disconnect.setText("Disconnect");
		mainWindow.getContentPane().add(disconnect);
		disconnect.setBounds(10, 40, 110, 25);

		connect.setBackground(Color.BLUE);
		connect.setForeground(Color.WHITE);
		connect.setText("Connect");
		connect.setToolTipText("");
		mainWindow.getContentPane().add(connect);
		connect.setBounds(130, 40, 110, 25);

		help.setBackground(Color.BLUE);
		help.setForeground(Color.WHITE);
		help.setText("Help");
		mainWindow.getContentPane().add(help);
		help.setBounds(420, 40, 70, 25);

		about.setBackground(Color.BLUE);
		about.setForeground(Color.WHITE);
		about.setText("About");
		mainWindow.getContentPane().add(about);
		about.setBounds(340, 40, 75, 25);

		message_L.setText("Message");
		mainWindow.getContentPane().add(message_L);
		message_L.setBounds(10, 10, 60, 20);

		message.setForeground(Color.BLUE);
		message.requestFocus();
		mainWindow.getContentPane().add(message);
		message.setBounds(70, 4, 260, 30);

		conversation_L.setHorizontalAlignment(SwingConstants.CENTER);
		conversation_L.setText("Convesation");
		mainWindow.getContentPane().add(conversation_L);
		conversation_L.setBounds(100, 70, 140, 16);

		conversation.setColumns(20);
		conversation.setFont(new Font("Tahoma", 0, 12));
		conversation.setForeground(Color.RED);
		conversation.setLineWrap(true);
		conversation.setRows(5);
		conversation.setEditable(false);

		conversation_SP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		conversation_SP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		conversation_SP.setViewportView(conversation);
		mainWindow.getContentPane().add(conversation_SP);
		conversation_SP.setBounds(10, 90, 330, 180);

		online_L.setHorizontalAlignment(SwingConstants.CENTER);
		online_L.setText("Currently online");
		online_L.setToolTipText("");
		mainWindow.getContentPane().add(online_L);
		online_L.setBounds(350, 70, 130, 16);

		online.setForeground(Color.BLUE);
		online_SP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		online_SP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		online_SP.setViewportView(online);
		mainWindow.getContentPane().add(online_SP);
		online_SP.setBounds(350, 90, 130, 180);

		loggedInAs_L.setFont(new Font("Tahoma", 0, 12));
		loggedInAs_L.setText("Currently logged in as");
		mainWindow.getContentPane().add(loggedInAs_L);
		loggedInAs_L.setBounds(348, 0, 140, 15);

		loggedInAsBox_L.setHorizontalAlignment(SwingConstants.CENTER);
		loggedInAsBox_L.setFont(new Font("Tahoma", 0, 12));
		loggedInAsBox_L.setForeground(Color.RED);
		loggedInAsBox_L.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainWindow.getContentPane().add(loggedInAsBox_L);
		loggedInAsBox_L.setBounds(340, 17, 150, 20);
	}

	public static void connect() {
		try {
			final String host   = "localhost";
			Socket       socket = new Socket(host, 444);

			System.out.println("You connected to: " + host);
			client = new Client(socket);

			PrintWriter out = new PrintWriter(socket.getOutputStream());

			out.println(userName);
			out.flush();

			Thread thread = new Thread(client);

			thread.start();
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Server not responding");
			System.exit(0);
		}
	}

	public static void initialize() {
		send.setEnabled(false);
		disconnect.setEnabled(false);
		connect.setEnabled(true);
	}

	public static void login_Action() {
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				action_Button_Enter();
			}
		});
	}

	public static void main(String[] args) {
		buildMainWindow();
		initialize();
	}

	public static void mainWindow_Action() {
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				action_Button_Send();
			}
		});
		disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				action_Button_Disconnect();
			}
		});
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buildLogInWindow();
			}
		});
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				action_Button_Help();
			}
		});
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				action_Button_About();
			}
		});
	}
}


//~ Formatted by Jindent --- http://www.jindent.com
