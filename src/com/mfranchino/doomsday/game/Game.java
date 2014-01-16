/*
 * @(#)Game.java   2014-01-15
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
import com.mfranchino.doomsday.game.level.*;
import com.mfranchino.doomsday.game.objects.MainMenu;
import com.mfranchino.doomsday.game.objects.Menu;

import org.newdawn.slick.*;

public class Game extends BasicGame {
	public static final String gameName = "YouTube Video Series";
	
	public static final int    WIDTH        = 640;
	public static final int    HEIGHT       = 480;
	public static final int    FPS          = 60;
	public static final double VERSION      = 0.05;

	// TODO this really shouln't be static
	public static GameStateManager gsm;
	double                         counter;

	public Game(String gameName) {
		super(gameName);
	}

	// TODO code smell
	public static GameStateManager gameStateManager() {
		return gsm;
	}

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Game(gameName));

			app.setDisplayMode(WIDTH, HEIGHT, false);
			app.setAlwaysRender(true);
			app.setTargetFrameRate(FPS);
			app.setShowFPS(false);
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		gsm = new GameStateManager(gc);

		MenuState menuState = new MenuState(gsm);
		Menu      mainMenu  = new MainMenu();

		menuState.setMenu(mainMenu);
		gsm.addState(menuState);

		LevelState levelState = new LevelState(gsm);
		Level      level      = new TestLevel(TestLayerEnum.class);

		levelState.setLevel(level);
		gsm.addState(levelState);
		gsm.setState(gc, GameStateManager.MAINMENUSTATE);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		// g.setColor(Color.white);
		// g.setLineWidth(4f);
		// g.drawLine(0,0,gc.getWidth(), gc.getHeight());
		// g.drawLine(0,gc.getHeight(),gc.getWidth(), 0);
		// g.drawString("0,0", 0, 0);
		// g.drawString("640,0", 640 - g.getFont().getWidth("640,0"), 0);
		// g.drawString("0,480", 0, 480-g.getFont().getHeight("0,480"));
		// g.drawString("640,480", 640-g.getFont().getWidth("640,480"),
		// 480-g.getFont().getHeight("640,480"));
		// g.fillOval(gc.getWidth()/2, gc.getHeight()/2, 3, 3);
		// g.setLineWidth(1f);
		// g.setColor(Color.red);
		// g.drawOval(320f, 240f, (float)(10 + counter), (float)(10 + counter));
		gsm.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		gsm.update(gc, delta);
	}
}


//~ Formatted by Jindent --- http://www.jindent.com
