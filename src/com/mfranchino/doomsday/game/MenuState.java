package com.mfranchino.doomsday.game;

import com.mfranchino.doomsday.game.objects.Menu;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Created by mfranchino on 1/14/14.
 */
public class MenuState extends GameState {

  private Menu menu;

  public MenuState(GameStateManager gsm) {
    super(gsm);
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  @Override
  public void init(GameContainer gc) throws SlickException {
    menu.init(gc);
  }

  public void update(GameContainer gc, int delta) throws SlickException {
    menu.update(gc, delta);
  }

  public void render(GameContainer gc, Graphics g) throws SlickException {
    menu.render(gc, g);
  }

  public void keyPressed(int key) {
    menu.keyPressed(key);
  }

  public void keyReleased(int key) {
    menu.keyReleased(key);
  }
}
