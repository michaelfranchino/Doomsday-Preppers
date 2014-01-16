/*
 * @(#)LevelState.java   2014-01-15
 * 
 * Copyright (c) 2014 Michael Franchino
 *
 *
 *
 *
 */
package com.mfranchino.doomsday.game;

//~--- non-JDK imports --------------------------------------------------------
import com.mfranchino.doomsday.framework.level.Level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class LevelState extends GameState {
	private Level level;

	public LevelState(GameStateManager gsm) {
		super(gsm);
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		level.init(gc);
	}

	public void keyPressed(int key) {}

	public void keyReleased(int key) {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		level.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		level.update(gc, delta);
	}
}