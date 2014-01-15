package com.mfranchino.doomsday.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class GameStateManager {

  private final GameContainer  gc;
  private ArrayList<GameState> gameStates;
  private int currentState;

  // TODO - this should be in the game state object
  public static final int MENUSTATE = 0;

  public GameStateManager(GameContainer gc) {
    gameStates = new ArrayList<>();

    this.gc = gc;
  }

  public void addState(GameState gs) {
    gameStates.add(gs);
  }

  public void setState(GameContainer gc, int state) {
    currentState = state;
    try {
      gameStates.get(currentState).init(gc);
    } catch (SlickException e) {
      e.printStackTrace();
    }
  }

  public void update(GameContainer gc, int delta) throws SlickException {
    gameStates.get(currentState).update(gc, delta);
  }

  public void render(GameContainer gc, Graphics g) throws SlickException {
    gameStates.get(currentState).render(gc, g);
  }

  public void keyPressed(int key) {
    gameStates.get(currentState).keyPressed(key);
  }

  public void keyReleased(int key) {
    gameStates.get(currentState).keyReleased(key);
  }

}
