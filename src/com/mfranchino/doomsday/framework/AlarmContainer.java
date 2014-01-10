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
package com.mfranchino.doomsday.framework;

import com.mfranchino.doomsday.entities.BaseEntity;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mfranchino
 */
public class AlarmContainer {

	private final Map<String, Alarm> alarms = new HashMap<>();
	private final BaseEntity entity;

	public AlarmContainer(BaseEntity entity) {
		this.entity = entity;
	}

	public void addAlarm(Alarm alarm) {
		alarms.put(Alarm.getName(), alarm);
	}
	
	public void update(int delta) {
		// go through every alarm and trigger update
		// if during the update, an alarm becomes expired, remove it from the list
	}
	
	private void removeAlarm() {
		
	}
	
	
}
