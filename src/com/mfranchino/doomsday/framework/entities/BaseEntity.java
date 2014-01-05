package com.mfranchino.doomsday.framework.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author mfranchino
 */
public abstract class BaseEntity implements IEntity {

    private final int id;
    private boolean expired;  // expired will remove the game object
    private float X, Y;
    protected Vector2f position;
    private float Height, Width;
    private float velX, velY; // Velocity X & Y
    private GameContainer gameContainer;

    protected boolean enabled;
    protected boolean visible;

    // Constructors
    public BaseEntity(int id, float x, float y, float height, float width) {

        super();

        this.id = id;
        this.position = new Vector2f(x, y);
        this.setX(x);
        this.setY(y);
        this.setHeight(height);
        this.setWidth(width);
        this.setVelX(0);
        this.setVelY(0);
    }

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
		// Getters/Setters
		public final GameContainer getGameContainer() {
			return gameContainer;
		}
		public final int getId() {
			return id;
		}
		public final float getX() {
			return position.x;
		}
		public final void setX(float x) {
			position.x = x;
		}
		public final float getHeight() {
			return Height;
		}
		public final void setHeight(float height) {
			Height = height;
		}
		public final float getWidth() {
			return Width;
		}
		public final void setWidth(float width) {
			Width = width;
		}
		public final void setY(float y) {
			position.y = y;
		}
		public final float getY() {
			return position.y;
		}
		public final float getVelX() {
			return velX;
		}
		public final void setVelX(float velX) {
			this.velX = velX;
		}
		public final float getVelY() {
			return velY;
		}
		public final void setVelY(float velY) {
			this.velY = velY;
		}
		public final void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public final void setVisible(boolean visible) {
			this.visible = visible;
		}
		public void expire() {
			this.expired = true;
		}
		public boolean isExpired() {
			return expired;
		}
		public final boolean isEnabled() {
			return enabled;
		}
		public final boolean isVisible() {
			return visible;
		}
		public final Vector2f getPosition() {
			return position;
		}
		public final void setPosition(Vector2f position) {
			this.position = position;
		}
//</editor-fold>
		
	protected void setDeltaX(int delta) {
		position.x += velX * delta / 1000.0f;
    }
    protected void setDeltaY(int delta) {
        position.y += velY * delta / 1000.0f;
    }

    public String toString() {
        return String.format("BaseEntity [id=%s, expired=%s, X=%s, Y=%s, Height=%s, Width=%s, velX=%s, velY=%s, enabled=%s, visible=%s]",
                id, expired, X, Y, Height, Width, velX, velY, enabled,
                visible);
    }

		//<editor-fold defaultstate="collapsed" desc="Game loop framework">
		public abstract void init(GameContainer gc);
		public abstract void render(GameContainer gc, Graphics g);
		public void update(GameContainer gc, int delta) {
			setDeltaX(delta);
			setDeltaY(delta);
		}
//</editor-fold>


}
