/*
 * @(#)BaseEntity.java   2014-01-04
 * 
 * Copyright (c) 2014 Michael Franchino
 *
 *
 *
 *
 */
package com.mfranchino.doomsday.framework.entities;

//~--- non-JDK imports --------------------------------------------------------
import com.mfranchino.doomsday.framework.events.AlarmContainer;
import com.mfranchino.doomsday.game.GameLoop;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author mfranchino
 */
public abstract class BaseEntity implements Entity, GameLoop {

	private float Height, Width;

	private boolean expired;       // expired will remove the game object
	private final int id;
	private float velX, velY;    // TODO convert to vector 

	/**
	 * If this entity is enabled. 
	 *   enabled = true, system will do the update() method during game loop
	 *   enabled = false, system will not call the update() method during the game loop
	 */
	protected boolean enabled;
	/**
	 * The position of the entity on the world map
	 */
	protected Vector2f position;
	/**
	 * The velocity of the entity on the world map
	 */
	protected Vector2f velocity; 
	/**
	 * If the entity is not visible, the render() method will not bother rendering the object
	 */
	protected boolean visible;
	/**
	 * alarms that can be attached to entity to perform actions
	 */
	protected AlarmContainer alarms;

	/**
	 * Creates a new entity in game world.
	 *
	 * @param id	Id of new entity
	 * @param x	starting x position in world
	 * @param y	starting y position in world
	 * @param height	starting height of entity in world
	 * @param width	starting width of entity in world
	 */
  protected BaseEntity(int id, float x, float y, float height, float width) {
		super();

		this.id = id;
		this.position = new Vector2f(x, y);

		this.setHeight(height);
		this.setWidth(width);

		this.setVelX(0);			// TODO need to look at vectors
		this.setVelY(0);
	}

//  <editor-fold defaultstate="collapsed" desc="Getters/Setters">
	/**
	 *
	 * @return {@link BaseEntity#alarms}
	 */
	public final AlarmContainer getAlarms() {
		return alarms;
	}

	/**
	 *
	 * @return
	 */
	public final float getHeight() {
		return Height;
	}

	/**
	 *
	 * @return
	 */
	protected final int getId() {
		return id;
	}

	/**
	 *
	 * @return
	 */
	public final Vector2f getPosition() {
		return position;
	}

	/**
	 *
	 * @return
	 */
	public final float getVelX() {
		return velX;
	}

	/**
	 *
	 * @return
	 */
	public final float getVelY() {
		return velY;
	}

	/**
	 *
	 * @return
	 */
	public final float getWidth() {
		return Width;
	}

	/**
	 *
	 * @return
	 */
	public final float getX() {
		return position.x;
	}

	/**
	 *
	 * @return
	 */
	public final float getY() {
		return position.y;
	}

	/**
	 *
	 * @param enabled
	 */
	public final void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 *
	 * @param height
	 */
	public final void setHeight(float height) {
		Height = height;
	}

	/**
	 *
	 * @param position
	 */
	public final void setPosition(Vector2f position) {
		this.position = position;
	}

	/**
	 *
	 * @param velX
	 */
	public final void setVelX(float velX) {
		this.velX = velX;
	}

	/**
	 *
	 * @param velY
	 */
	public final void setVelY(float velY) {
		this.velY = velY;
	}

	/**
	 *
	 * @param visible
	 */
	public final void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 *
	 * @param width
	 */
	public final void setWidth(float width) {
		Width = width;
	}

	/**
	 *
	 * @param x
	 */
	public final void setX(float x) {
		position.x = x;
	}

	/**
	 *
	 * @param y
	 */
	public final void setY(float y) {
		position.y = y;
	}
//  </editor-fold>

	/**
	 *
	 * @param delta
	 */
	protected void setDeltaX(int delta) {
		position.x += velX * delta / 1000.0f;
	}

	/**
	 *
	 * @param delta
	 */
	protected void setDeltaY(int delta) {
		position.y += velY * delta / 1000.0f;
	}

	/**
	 *
	 */
	@Override
	public final void expire() {
		this.expired = true;
    this.visible = false;
    this.enabled = false;
    onExpire();
	}

  /**
   * Will be called on entity right after the expired method is called. This method should be
   * overridden if any additional processing is required for the entity.
   */
  public void onExpire() {
  }

	// <editor-fold defaultstate="collapsed" desc="Game loop framework">
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		setDeltaX(delta);
		setDeltaY(delta);
	}

	@Override
	public abstract void init(GameContainer gc) throws SlickException;

	@Override
	public abstract void render(GameContainer gc, Graphics g) throws SlickException;

	/**
	 *
	 * @return
	 */
	@Override
	public final boolean isEnabled() {
		return enabled;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public final boolean isExpired() {
		return expired;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public final boolean isVisible() {
		return visible;
	}
	// </editor-fold>

	// TODO what is the World?
	/**
	 *
	 * @return
	 */
	public BaseEntity addToWorld() {
		return this;
	}
}
