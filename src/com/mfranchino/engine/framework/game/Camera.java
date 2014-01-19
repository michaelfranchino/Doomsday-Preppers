package com.mfranchino.engine.framework.game;

import com.mfranchino.engine.framework.entities.BaseEntity;
import com.mfranchino.doomsday.game.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Camera {

  private final Rectangle viewPort;
  private int mapWidth;
  private int mapHeight;
  private int x, y;

  public Camera() {
    x = 0;
    y = 0;
    viewPort = new Rectangle(0, 0, Game.WIDTH, Game.HEIGHT);
  }

  public Camera(int mapWidth, int mapHeight) {
    this();
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getMapWidth() {
    return mapWidth;
  }

  public void setMapWidth(int mapWidth) {
    this.mapWidth = mapWidth;
  }

  public int getMapHeight() {
    return mapHeight;
  }

  public void setMapHeight(int mapHeight) {
    this.mapHeight = mapHeight;
  }

  public Rectangle getViewPort() {
    return viewPort;
  }

  public void translate(Graphics g, BaseEntity entity) {

    if (entity.getX() - Game.WIDTH / 2 + 16 < 0) {
      x = 0;
    } else if (entity.getX() + Game.WIDTH / 2 + 16 > mapWidth) {
      x = -mapWidth + Game.WIDTH;
    } else {
      x = (int) -entity.getX() + Game.WIDTH / 2 - 16;
    }

    if (entity.getY() - Game.HEIGHT / 2 + 16 < 0) {
      y = 0;
    } else if (entity.getY() + Game.HEIGHT / 2 + 16 > mapHeight) {
      y = -mapHeight + Game.HEIGHT;
    } else {
      y = (int) -entity.getY() + Game.HEIGHT / 2 - 16;
    }
    g.translate(x, y);
    viewPort.setX(-x);
    viewPort.setY(-y);
  }
}
