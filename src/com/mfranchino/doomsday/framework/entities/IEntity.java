package com.mfranchino.doomsday.framework.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface IEntity {
	
	// Game loop methods
	public void init(GameContainer gc);
	public void update(GameContainer gc, int delta);
	public void render(GameContainer gc, Graphics g);

	// Framework methods
	public boolean isExpired();
	public void expire();
	public void onExpire();
	public boolean isEnabled();
	public boolean isVisible();
}
