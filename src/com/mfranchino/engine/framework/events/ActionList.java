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
package com.mfranchino.engine.framework.events;

import java.util.Arrays;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;

public class ActionList<E extends Action> {

	public class ActionListIterator implements Iterator<E> {

		public int index;

		@Override
		public boolean hasNext() {
			return (index < size);
		}

		@Override
		public E next() {
			return actions[index++];
		}

		@Override
		public void remove() {
			//actions[index - 1].setFinished(true);
		}

		public ActionListIterator reset() {
			index = 0;
			return this;
		}
	}

	private int mask;

	private static int DEFAULT_CAPACITY = 64;
	private E[] actions;
	private boolean expired;

	private int size;
	private float shrinkPercent;
	private float shrinkReadyTime;
	private float shrinkTime;
	private final ActionListIterator iterator = new ActionListIterator();

	public ActionList() {
		this(DEFAULT_CAPACITY);
	}

	public ActionList(int initialCapacity) {
		this((E[]) new Action[initialCapacity]);
	}

	public ActionList(E[] actions) {
		this.actions = actions;
		this.expired = false;
	}

	public void add(E action) {
		pad(1);
		actions[size] = action;
		onAdd(action, size);
		size++;
	}

	public <T extends E> void add(ActionList<T> actionList) {
		add(actionList.actions, 0, actionList.size);
	}

	public <T extends E> void add(T[] actionArray) {
		add(actionArray, 0, actionArray.length);
	}

	public <T extends E> void add(T[] actionArray, int offset, int length) {
		pad(length);
		System.arraycopy(actionArray, offset, actions, size, length);
		for (int i = 0; i < length; i++) {
			onAdd(actionArray[offset + i], size + i);
		}
		size += length;
	}
	
	private int available() {
		return (this.capacity() - this.size);
	}

	private int capacity() {
		return actions.length;
	}

	public E get(int index) {
		return actions[index];
	}

	public Iterator<E> iterator() {
		return (iterator.hasNext() ? new ActionListIterator() : iterator.reset());
	}

	// Expire the entire list
	public void onExpire() {
		for (int i = 0; i < size; i++) {
			E action = actions[i];
			//action.onExpire();
			onExpired(action);
			actions[i] = null;
		}
		size = 0;
	}

	public void pad(int count) {
		final int capacity = this.capacity();
		if ((size + count) > capacity) {
			int nextSize = capacity + (capacity >> 1);
			int minimumSize = size + count;
			actions = Arrays.copyOf(actions, Math.max(nextSize, minimumSize));
		}
	}

	private int size() {
		return this.size;
	}

	// removes all entities from the list
	public void clear() {
		onExpire();
	}

	// Sets the auto-shrinking feature of the EntityList. If this method is not called
	// then shrinking is disabled. 
	public void setAutoShrink(float shrinkPercent, float shrinkReadyTime) {
		this.shrinkPercent = shrinkPercent;
		this.shrinkReadyTime = shrinkReadyTime;
	}

	private void handleShrinking(int delta) {
		// if the number of live entities has been below the "shrinkPercentage" relative
		// to the length of the array, and it's below that percent 
		// for "shrinkReadyTime" in seconds, shrink the array

		int shrinkLength = (int) (shrinkPercent * actions.length);
		if (size < shrinkLength) {
			shrinkTime += delta / 1000;  // delta is in milliseconds
			if (shrinkTime >= shrinkReadyTime) {
				actions = Arrays.copyOf(actions, shrinkLength);
				shrinkTime = 0;
			}
		} else {
			shrinkTime = 0;
		}
	}

	public void expire() {
		expired = true;
	}

	private void onAdd(E action, int index) {
	}

	// TODO Is this method required?
	private void onExpired(E action) {
	}

	// TODO Should this method really be needed?
	private void onUpdated(E action, GameContainer gc, int index) {
	}

	public void update(GameContainer gc, int delta) {
		int alive = 0;
		for (E action : actions) {
			if (action != null) {
				if (!action.isFinished() && 0 == (mask & action.lane)) {
					if (action.isBlocking()) {
						mask |= action.lane;
					}
					
					action.update(gc, delta); 

					if (action.isFinished()) {
						onExpired(action);
					} else {
						actions[alive] = action;
						onUpdated(action, gc, alive);
						alive++;
					}
				}
			}
		}

		// set all remaining actions to null to be garbage collected
		while (size > alive) {
			actions[--size] = null;
		}
		handleShrinking(delta);
	}

}
