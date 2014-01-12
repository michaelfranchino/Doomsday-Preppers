package com.mfranchino.doomsday.game;

import com.mfranchino.doomsday.game.level.*;
import com.mfranchino.doomsday.game.objects.Camera;
import org.newdawn.slick.*;

public class Game extends BasicGame {

	public static final String gameName = "YouTube Video Series";

	public static final int SPLASHSCREEN = 0;
	public static final int MAINMENU = 1;

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final int FPS = 60;
	public static final double VERSION = 0.05;

	Level level;
	private static Camera camera;

	double counter;

	public static Camera getCamera() {
		return camera;
	}
	
	public Game(String gameName) {
		super(gameName);
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
		camera.translate(g, level.getPlayer());  // have camera follow entity (player, mob, etc)
		level.render(gc, g);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		level = new TestLevel(TestLayerEnum.class);
		level.init(gc);
		
		camera = new Camera(level.getMapWidth(), level.getMapHeight());
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		level.update(gc, delta);
	}
}