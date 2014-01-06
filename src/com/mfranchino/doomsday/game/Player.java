package com.mfranchino.doomsday.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

import com.mfranchino.doomsday.framework.entities.BaseEntity;
import com.mfranchino.doomsday.framework.entities.Entity;

public class Player extends BaseEntity implements Entity{
	
	private int health;
	private int maxSpeed;
	private int maxJumpHeight;
	
	private Animation image;
	
	// Constructor
	public Player(int id, float x, float y, float height, float width) {
		super(id, x, y, height, width);
	}

	public void onExpire() {
	}

	// Game loop methods
	public void init(GameContainer gc) {
		SpriteSheet frames = null;
		try {
			frames = new SpriteSheet(new Image("res/player/standard.png"), 32, 64);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = new Animation(frames, 20);
	}
	public void render(GameContainer gc, Graphics g) {
		g.drawAnimation(image, getX(), getY());
	}
	
	public void update(GameContainer gc, int delta, int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
		Vector2f trans = new Vector2f(0,0);
		
		Input input = gc.getInput();
		setVelX(0);
		setVelY(0);
		
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A))  trans.x = -0.5f * delta; // setVelX(-128);
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) trans.x = 0.5f * delta;  // setVelX(128);
		if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W))    trans.y = -0.5f * delta; // setVelY(-128);
		if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S))  trans.y = 0.5f * delta;  // setVelY(128);
		
		if (trans.x != 0 && trans.y !=0) {
			trans.set(trans.x / 1.5f, trans.y / 1.5f);
		}
		//System.out.println("tileWidth = " + tileWidth + " tileHeight = " + tileHeight);
		System.out.println("trans = " + trans.toString());
		if (position.x + trans.x > tileWidth && position.x + trans.x < (mapWidth - (2 * tileWidth))) {
			position.x += trans.x;
		}
		if (position.y + trans.y > tileHeight && position.y + trans.y < (mapHeight - (4 * tileHeight))) {
			position.y += trans.y;
		}
		
		super.update(gc, delta);
	}
	
	public final int getHealth() {
		return health;
	}
	public final void setHealth(int health) {
		this.health = health;
	}
	public final int getMaxSpeed() {
		return maxSpeed;
	}
	public final void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public final int getMaxJumpHeight() {
		return maxJumpHeight;
	}
	public final void setMaxJumpHeight(int maxJumpHeight) {
		this.maxJumpHeight = maxJumpHeight;
	}

}
