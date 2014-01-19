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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mfranchino
 */
public class ServerManager {
	
	private final int port;
	private final String hostname;
	private List<Server> activeServers = new ArrayList<>();

	public ServerManager(int port, String hostname) {
		this.port = port;
		this.hostname = hostname;
	}
	
	public void addServer(Server server) {
		activeServers.add(server);
	}
	
	public void checkServerConnections() {
		for (Server temp : activeServers) {
			
		}
	}

	public int getServerCount() {
		return activeServers.size();
	}
	
}