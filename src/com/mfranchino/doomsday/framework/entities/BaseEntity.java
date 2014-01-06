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

import com.mfranchino.doomsday.game.GameLoop;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author mfranchino
 */
public abstract class BaseEntity implements Entity, GameLoop {
	private float         Height, Width;
	private boolean       expired;       // expired will remove the game object
	private GameContainer gameContainer;
	private final int     id;
	private float         velX, velY;    // Velocity X & Y
	protected boolean     enabled;
	protected Vector2f    position;
	protected boolean     visible;

	// Constructors
	public BaseEntity(int id, float x, float y, float height, float width) {
		super();
		
		this.id       = id;
		this.position = new Vector2f(x, y);
		
		this.setHeight(height);
		this.setWidth(width);
		
		this.setVelX(0);
		this.setVelY(0);
	}

//  <editor-fold defaultstate="collapsed" desc="Getters/Setters">
	public final GameContainer getGameContainer() {
		return gameContainer;
	}

	public final float getHeight() {
		return Height;
	}

	public final int getId() {
		return id;
	}

	public final Vector2f getPosition() {
		return position;
	}

	public final float getVelX() {
		return velX;
	}

	public final float getVelY() {
		return velY;
	}

	public final float getWidth() {
		return Width;
	}

	public final float getX() {
		return position.x;
	}

	public final float getY() {
		return position.y;
	}

	public final void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public final void setHeight(float height) {
		Height = height;
	}

	public final void setPosition(Vector2f position) {
		this.position = position;
	}

	public final void setVelX(float velX) {
		this.velX = velX;
	}

	public final void setVelY(float velY) {
		this.velY = velY;
	}

	public final void setVisible(boolean visible) {
		this.visible = visible;
	}

	public final void setWidth(float width) {
		Width = width;
	}

	public final void setX(float x) {
		position.x = x;
	}

	public final void setY(float y) {
		position.y = y;
	}
//  </editor-fold>
	
	protected void setDeltaX(int delta) {
		position.x += velX * delta / 1000.0f;
	}

	protected void setDeltaY(int delta) {
		position.y += velY * delta / 1000.0f;
	}
	
	@Override
	public void expire() {
		this.expired = true;
	}

	// <editor-fold defaultstate="collapsed" desc="Game loop framework">
	@Override
	public void update(GameContainer gc, int delta) {
		setDeltaX(delta);
		setDeltaY(delta);
	}
	
	@Override
	public abstract void init(GameContainer gc);

	@Override
	public abstract void render(GameContainer gc, Graphics g);

	@Override
	public final boolean isEnabled() {
		return enabled;
	}

	@Override
	public boolean isExpired() {
		return expired;
	}

	@Override
	public final boolean isVisible() {
		return visible;
	}
	// </editor-fold>
}
