package com.mfranchino.doomsday.game.objects;

import com.mfranchino.engine.framework.game.Menu;
import org.newdawn.slick.Color;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.awt.Font;

public class MainMenu extends Menu {

  private final float x, y;
  private String[] menuItems = new String[4];
  private int currentSelection = 0;
  private Color color;
  private TrueTypeFont font = new TrueTypeFont(new java.awt.Font("Verdana", Font.BOLD, 24), false);

  public MainMenu() {
    x = 300;
    y = 150;
  }
  //public MainMenu(int id, float x, float y, float height, float width) {
//		super(id, x, y, height, width);
//	}

  public void onExpire() {
  }

  public void init(GameContainer gc) {

    // TODO Externalize - Make this class very generic
    menuItems[0] = "Play";
    menuItems[1] = "Load";
    menuItems[2] = "Options";
    menuItems[3] = "Quit";

    // TODO Externalize - Make this part of setup
    // Set color
    color = new Color(Color.yellow);
  }

  public void render(GameContainer gc, Graphics g) {
    int index = 0;
    int offset = font.getHeight();
    g.setFont(font);
    g.setColor(color);
    for (String menuItem : menuItems) {
      g.drawString(menuItem, x, y + (index++ * offset));
    }

    g.setColor(Color.red);
    g.drawString(">", x - font.getWidth(">  "), y + (currentSelection * offset));
  }

  public void update(GameContainer gc, int delta) {
    Input input = gc.getInput();
    if (input.isKeyPressed(Input.KEY_DOWN))
      currentSelection++;
    if (input.isKeyPressed(Input.KEY_UP))
      currentSelection--;
    // If user enters escape - quit menu for now
    if (input.isKeyPressed(Input.KEY_ESCAPE)) {
      // TODO what should happen if they press ESC on the main menu???
    }
    if (currentSelection < 0)
      currentSelection = menuItems.length - 1;
    if (currentSelection > menuItems.length - 1)
      currentSelection = 0;

    // Determine where on menu cursor is if ENTER is pressed
    if (input.isKeyPressed(Input.KEY_ENTER)) {
      switch (currentSelection) {
        case 0:
          com.mfranchino.doomsday.game.Game.gameStateManager().setState(gc, 1);
          // TODO Should change game state, but don't have the state in the class currently
          break;
        case 1:
          break;
        case 2:
          break;
        case 3:
          gc.exit();
          break;
      }
    }

    input.clearKeyPressedRecord();
    input.consumeEvent();
  }

  public final TrueTypeFont getFont() {
    return font;
  }

  public final void setFont(TrueTypeFont font) {
    this.font = font;
  }
}
