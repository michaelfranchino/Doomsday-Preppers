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

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author mfranchino
 */
public class ScheduleExecutor extends ScheduledThreadPoolExecutor{

	
	public ScheduleExecutor(int corePoolSize) {
		super(corePoolSize);
	}
	
	@Override
	public ScheduledFuture scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		return super.scheduleAtFixedRate(wrapRunnable(command), initialDelay, period, unit);
	}
	
	@Override
	public ScheduledFuture scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
		return super.scheduleWithFixedDelay(wrapRunnable(command), initialDelay, delay, unit);
	}
	
	private Runnable wrapRunnable(Runnable command) {
		return new LogOnExceptionRunnable(command);
	}
	
	private class LogOnExceptionRunnable implements Runnable {
		private Runnable runnable;
		
		public LogOnExceptionRunnable(Runnable runnable) {
			super();
			this.runnable = runnable;
		}
		public void run() {
			try {
				runnable.run();
			} catch (Exception e) {
				System.err.println("Error in executing: " + runnable + ". It will no longer be run!");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}

