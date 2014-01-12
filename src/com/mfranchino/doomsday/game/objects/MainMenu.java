package com.mfranchino.doomsday.game.objects;

import org.newdawn.slick.Color;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.awt.Font;

public class MainMenu extends Menu {

	private String[] menuItems = new String[4];
	
	private int currentSelection = 0;
	private Color color;
	
	private TrueTypeFont font = new TrueTypeFont(new java.awt.Font("Verdana", Font.BOLD, 24), false);
	
	public MainMenu(int id, float x, float y, float height, float width) {
		super(id, x, y, height, width);
	}

	public void onExpire() {
	}

	public void init(GameContainer gc) {
		
		this.enabled = true;
		this.visible = true;
		
		// TODO Externalize - Make this class very generic
		menuItems[0] = "Play";
		menuItems[1] = "Load";
		menuItems[2] = "Options";
		menuItems[3] = "Quit";
		
		// TODO Externalize - Make this part of setup
		// Set color
		color = new Color(Color.yellow);
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		if (isVisible()) {
			int index = 0;
			int offset = font.getHeight();
			g.setFont(font);
			g.setColor(color);
			for (String menuItem: menuItems ) {
				g.drawString(menuItem, getX(), getY() + (index++ * offset)); 
			}
			
			g.setColor(Color.red);
			g.drawString(">", getX() - font.getWidth(">  "), getY() + (currentSelection * offset));
		}
	}

	@Override
	public void update(GameContainer gc, int delta) {
		if (isEnabled()) {
			Input input = gc.getInput();
			if (input.isKeyPressed(Input.KEY_DOWN))
				currentSelection++;
			if (input.isKeyPressed(Input.KEY_UP))
				currentSelection--;
			// If user enters escape - quit menu for now
			if (input.isKeyPressed(Input.KEY_ESCAPE)) {
				hideMenu();
			}
			if (currentSelection < 0)
				currentSelection = menuItems.length - 1;
			if (currentSelection > menuItems.length - 1)
				currentSelection = 0;
			
			// Determine where on menu cursor is if ENTER is pressed
			if (input.isKeyPressed(Input.KEY_ENTER)) {
				switch (currentSelection) {
				case 0 : hideMenu();
						 break;
				case 1 : break;
				case 2 : break;
				case 3 : gc.exit();
						 break;
				}
			}

			input.clearKeyPressedRecord();
			input.consumeEvent();
		}
	}

	private void hideMenu() {
		enabled = false;
		visible = false;
	}

	public final TrueTypeFont getFont() {
		return font;
	}
	public final void setFont(TrueTypeFont font) {
		this.font = font;
	}
}
