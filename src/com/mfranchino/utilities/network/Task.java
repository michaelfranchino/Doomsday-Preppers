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

import java.util.concurrent.TimeUnit;

/**
 *
 * @author mfranchino
 */
public class Task implements Runnable {
	public void run() {
		System.out.println("Sleeping....");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Throwing");
		throw new RuntimeException("Fail!!!!!");
	}
	
	public static void main(String[] args) {
		new ScheduleExecutor(1).scheduleAtFixedRate(new Task(), 1, 1, TimeUnit.SECONDS);
	}
}