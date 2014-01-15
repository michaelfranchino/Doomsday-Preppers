package com.mfranchino.doomsday.game;

import com.mfranchino.doomsday.framework.level.Level;
import com.mfranchino.doomsday.game.GameState;
import com.mfranchino.doomsday.game.GameStateManager;
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

  @Override
  public void update(GameContainer gc, int delta) throws SlickException {
    level.update(gc, delta);
  }

  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException {
    level.render(gc, g);
  }

  public void keyReleased(int key) {
  }

  public void keyPressed(int key) {
  }
}
