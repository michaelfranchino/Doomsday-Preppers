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

package com.mfranchino.doomsday.framework.events;

/**
 *
 * @author mfranchino
 */
public class Alarm {

	static String getName() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	private final String name;
	private boolean enabled;
	private int triggerTime;
	private int counter;
	private boolean expired;
	private final AlarmType alarmType;
	private final AlarmTrigger alarmTrigger;

	
	private Alarm(String name, AlarmType alarmType, AlarmTrigger alarmTrigger, boolean active, int triggerTime) {
		this.name = name;
		this.alarmType = alarmType;
		this.alarmTrigger = alarmTrigger;
		this.enabled = active;
		this.triggerTime = triggerTime;
	}

	public static Alarm createAutoAlarm(String name, AlarmType alarmType, int triggerTimeSeconds ) {
		return new Alarm(name, alarmType, AlarmTrigger.Automatic, true, triggerTimeSeconds * 1000);
	}
	
	public static Alarm createManualAlarm(String name, AlarmType alarmType) {
		return new Alarm(name, alarmType, AlarmTrigger.Manual, false, 0);
	}
	
	public static Alarm createExternalAlarm(String name, AlarmType alarmType) {
		return new Alarm(name, alarmType, AlarmTrigger.External, false, 0);
	}
	
	public void pause() {
		this.enabled = false;
	}
	
	public void resume() {
		this.enabled = true;
	}
	
	// This will trigger the alarm to start immediately
	public void trigger() {
		if (!this.expired)
			this.enabled = true;
	}
	
	public void update(int delta) {

		// If alarm is enabled, then process ticks
		if (enabled) {
			counter -= delta;
			if (counter < 0) {
				// alarm has trigger, do action
				counter = triggerTime;
				if (this.alarmType == AlarmType.OneShot) this.setExpired();
			}
		}
	}
	
	private void setExpired() {
		this.expired = true;
		this.enabled = false;
	}
	
}
