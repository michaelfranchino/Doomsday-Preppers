/*
 * @(#)GameStateManager.java   2014-01-15
 * 
 * Copyright (c) 2014 Michael Franchino
 *
 *
 *
 *
 */
package com.mfranchino.engine.framework.game;

//~--- non-JDK imports --------------------------------------------------------
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

//~--- JDK imports ------------------------------------------------------------
import java.util.ArrayList;

public class GameStateManager {

	public static final int MAINMENUSTATE = 0;
	public static final int LEVELSTATE = 1;
	public static final int OPTIONMENUSTATE = 2;

	private int currentState;
	private final ArrayList<GameState> gameStates;
	private final GameContainer gc;

	public GameStateManager(GameContainer gc) {
		gameStates = new ArrayList<>();
		this.gc = gc;
	}

	public void setState(GameContainer gc, int state) {
		currentState = state;

		try {
			gameStates.get(currentState).init(gc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void addState(GameState gs) {
		gameStates.add(gs);
	}

	public void keyPressed(int key) {
		gameStates.get(currentState).keyPressed(key);
	}

	public void keyReleased(int key) {
		gameStates.get(currentState).keyReleased(key);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		gameStates.get(currentState).render(gc, g);
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		gameStates.get(currentState).update(gc, delta);
	}
}
