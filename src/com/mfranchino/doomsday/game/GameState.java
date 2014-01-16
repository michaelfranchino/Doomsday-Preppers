/*
 * @(#)GameState.java   2014-01-15
 * 
 * Copyright (c) 2014 Michael Franchino
 *
 *
 *
 *
 */
package com.mfranchino.doomsday.game;

//~--- non-JDK imports --------------------------------------------------------
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Created by mfranchino on 1/14/14.
 */
public abstract class GameState {
	protected GameStateManager gsm;

	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	public abstract void init(GameContainer gc) throws SlickException;

	public abstract void keyPressed(int key);

	public abstract void keyReleased(int key);

	public abstract void render(GameContainer gc, Graphics g) throws SlickException;

	public abstract void update(GameContainer gc, int delta) throws SlickException;
}