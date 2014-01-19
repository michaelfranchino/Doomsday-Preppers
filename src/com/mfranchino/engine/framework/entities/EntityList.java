package com.mfranchino.engine.framework.entities;

import java.util.Arrays;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class EntityList<E extends Entity> implements Entity, Iterable<E> {

	public class EntityListIterator implements Iterator<E> {

		public int index;

		@Override
		public boolean hasNext() {
			return (index < size);
		}

		@Override
		public E next() {
			return entities[index++];
		}

		@Override
		public void remove() {
			entities[index - 1].expire();
		}

		public EntityListIterator reset() {
			index = 0;
			return this;
		}
	}

	private boolean enabled;
	private boolean expired;
	private boolean visible;

	private static int DEFAULT_CAPACITY = 64;
	private E[] entities;

	private int size;
	private float shrinkPercent;
	private float shrinkReadyTime;
	private float shrinkTime;

	private final EntityListIterator iterator = new EntityListIterator();

	// Constructors
	public EntityList() {
		this(DEFAULT_CAPACITY);
	}

	public EntityList(E[] entities) {
		this.entities = entities;
		this.enabled = true;
		this.visible = true;
		this.expired = false;
	}

	public EntityList(int initialCapacity) {
		this((E[]) new Entity[initialCapacity]);
	}

	public void add(E entity) {
		pad(1);
		entities[size] = entity;
		onAdd(entity, size);
		size++;
	}

	public <T extends E> void add(EntityList<T> entityList) {
		add(entityList.entities, 0, entityList.size);
	}

	public <T extends E> void add(T[] entityArray) {
		add(entityArray, 0, entityArray.length);
	}

	public <T extends E> void add(T[] entityArray, int offset, int length) {
		pad(length);
		System.arraycopy(entityArray, offset, entities, size, length);
		for (int i = 0; i < length; i++) {
			onAdd(entityArray[offset + i], size + i);
		}
		size += length;
	}

	private int available() {
		return (this.capacity() - this.size);
	}

	private int capacity() {
		return entities.length;
	}

	public E get(int index) {
		return entities[index];
	}

	@Override
	public Iterator<E> iterator() {
		return (iterator.hasNext() ? new EntityListIterator() : iterator.reset());
	}

	// Expire the entire list
	@Override
	public void onExpire() {
		for (int i = 0; i < size; i++) {
			E entity = entities[i];
			entity.onExpire();
			onExpired(entity);
			entities[i] = null;
		}
		size = 0;
	}

	public void pad(int count) {
		final int capacity = this.capacity();
		if ((size + count) > capacity) {
			int nextSize = capacity + (capacity >> 1);
			int minimumSize = size + count;
			entities = Arrays.copyOf(entities, Math.max(nextSize, minimumSize));
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

		int shrinkLength = (int) (shrinkPercent * entities.length);
		if (size < shrinkLength) {
			shrinkTime += delta / 1000;  // delta is in milliseconds
			if (shrinkTime >= shrinkReadyTime) {
				entities = Arrays.copyOf(entities, shrinkLength);
				shrinkTime = 0;
			}
		} else {
			shrinkTime = 0;
		}
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean isExpired() {
		return expired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void expire() {
		expired = true;
	}

	// TODO Is this method required?
	private void onAdd(E entity, int index) {
	}

	// TODO Is this method required?
	private void onExpired(E entity) {
	}

	// TODO Should this method really be needed?
	private void onUpdated(E entity, GameContainer gc, int index) {
	}

	// Game loop
	// This should only initialize the EntityList and not the entities, as they should be initialized on creation
	@Override
	public void init(GameContainer gc) throws SlickException {
		for (E entity : entities) {
			if (entity != null) {
				entity.init(gc);
			}
		}
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		int alive = 0;

		// Iterate over all entities in this list and process them
		for (E entity : entities) {
			if (entity != null) {
				if (!entity.isExpired()) {
					entity.update(gc, delta);
				}

				// If entity is now expired after going through update method, then remove from list
				if (entity.isExpired()) {
					entity.onExpire();
					onExpired(entity);
				} else {
					entities[alive] = entity;
					onUpdated(entity, gc, alive);
					alive++;
				}
			}
		}

		// set all remaining entities to null to be garbage collected
		while (size > alive) {
			entities[--size] = null;
		}
		handleShrinking(delta);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = 0; i < size; i++) {
			if (entities[i].isVisible()) {
				entities[i].render(gc, g);
			}
		}
	}
}
