package com.mfranchino.doomsday.framework.entities;

import java.util.Arrays;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class EntityList<E extends IEntity> implements IEntity, Iterable<E> {

	public class EntityListIterator implements Iterator<E> {
		public int index;

		public boolean hasNext() {
			return (index < size);
		}

		public E next() {
			return entities[index++];
		}

		public void remove() {
			entities[index - 1].expire();
		}

		public EntityListIterator reset() {
			index = 0;
			return this;
		}
	}

	public static int DEFAULT_CAPACITY = 64;
	protected E[] entities;

	protected int size;
	protected float shrinkPercent;
	protected float shrinkReadyTime;
	protected float shrinkTime;

	protected final EntityListIterator iterator = new EntityListIterator();

	// Constructors
	public EntityList() {
		this(DEFAULT_CAPACITY);
	}
	public EntityList(E[] entities) {
		this.entities = entities;
	}
	@SuppressWarnings("unchecked")
	public EntityList(int initialCapacity) {
		this((E[]) new IEntity[initialCapacity]);
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

	public int available() {
		return (this.capacity() - this.size);
	}
	public int capacity() {
		return entities.length;
	}

	public E get(int index) {
		return entities[index];
	}
	public Iterator<E> iterator() {
		return (iterator.hasNext() ? new EntityListIterator() : iterator.reset());
	}

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

	public int size() {
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
		
		int shrinkLength = (int)(shrinkPercent * entities.length);
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
	public boolean isExpired() {
		return false;
	}
	public boolean isEnabled() {
		return true;
	}
	public boolean isVisible() {
		return true;
	}
	public void expire() {
	}

	protected void onAdd(E entity, int index) {
	}
	protected void onExpired(E entity) {
	}
	protected void onUpdated(E entity, GameContainer gc, int index) {
	}

	// Game loop
	// This should only initialize the EntityList and not the entities, as they should be initialized on creation
	public void init(GameContainer gc) {
		for (int i=0;i < entities.length;i++) {
			if (entities[i] != null ) entities[i].init(gc);
    	}
	}
	public void update(GameContainer gc, int delta) {
		int alive = 0;
		
		for (int i = 0; i < size; i++) {
			E entity = entities[i];
			if (!entity.isExpired())
				entity.update(gc, delta);
			
			if (entity.isExpired()) {
				entity.onExpire(); // 
				onExpired(entity); // notify entity that it has expired
			} else {
				entities[alive] = entity;
				onUpdated(entity, gc, alive);
				alive++;
			}
		}
		
		while (size > alive) {
			entities[--size] = null;
		}
		handleShrinking(delta);
	}
	public void render(GameContainer gc, Graphics g) {
		for (int i = 0; i < size; i++) {
			entities[i].render(gc, g);
		}
	}

}