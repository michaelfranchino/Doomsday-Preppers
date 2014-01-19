package com.mfranchino.engine.framework.events;

import org.newdawn.slick.GameContainer;

public abstract class Action {

	public static enum ActionLanes {

		MOVEMENT(1, "movement"),
		ANIMATION(2,"animation"),
		BEHAVIOR(3, "behaviour"),
		GAMESTATE(99, "gamestate");

		private final int lane;
		private final String description;

		private ActionLanes(int lane, String description) {
			this.lane = lane;
			this.description = description;
		}

		public final int getLane() {
			return lane;
		}
		public final String getDescription() {
			return description;
		}
	}

	public int lane;

	public boolean blocking;
	public boolean running;
	public boolean finished;

	/**
	 *
	 * @param blocking determines if this action should block other actions
	 * @param lane     specific lane to run the action in
	 */
	public Action(boolean blocking, int lane) {
		this.lane = lane;
		this.blocking = blocking;
		this.finished = false;
	}

	/**
	 *
	 * @return if this action will block other actions
	 */
	public final boolean isBlocking() {
		return blocking;
	}

	/**
	 *
	 * @return if this action has finished processing
	 */
	public final boolean isFinished() {
		return finished;
	}

	/**
	 *
	 * @return lane that the action is on
	 */
	public final int getLane() {
		return lane;
	}

	/**
	 * 
	 * @return is this action running
	 */
	public final boolean isRunning() {
		return running;
	}

	public abstract void update(GameContainer gc, int delta);
}