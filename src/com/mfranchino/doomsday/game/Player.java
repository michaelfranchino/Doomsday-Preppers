package com.mfranchino.doomsday.game;

import com.mfranchino.doomsday.framework.entities.Attributes;
import com.mfranchino.doomsday.framework.entities.BaseEntity;
import com.mfranchino.doomsday.framework.entities.Entity;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Player extends BaseEntity implements Entity{

  private Attributes attributes;
	
	// Constructor
	public Player(int id, float x, float y, float height, float width) {
		super(id, x, y, height, width);
    attributes = new Attributes();
	}

	public void onExpire() {
	}

	// Game loop methods
	public void init(GameContainer gc) {
		SpriteSheet frames = null;
		try {
			frames = new SpriteSheet(new Image("res/player/standard.png"), 32, 64);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		attributes.setImage(new Animation(frames, 20));
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) {
		g.drawAnimation(attributes.getImage(), getX(), getY());
	}
	
	public void update(GameContainer gc, int delta, int mapWidth, int mapHeight, int tileWidth, int tileHeight) throws SlickException {
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
		if (position.x + trans.x > tileWidth && position.x + trans.x < (mapWidth - (2 * tileWidth))) {
			position.x += trans.x;
		}
		if (position.y + trans.y > tileHeight && position.y + trans.y < (mapHeight - (4 * tileHeight))) {
			position.y += trans.y;
		}
		
		super.update(gc, delta);
	}
	


}
