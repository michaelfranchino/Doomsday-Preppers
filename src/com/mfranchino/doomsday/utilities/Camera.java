package com.mfranchino.doomsday.utilities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.mfranchino.doomsday.framework.entities.BaseEntity;
import com.mfranchino.doomsday.game.Game;

public class Camera {

    private int x, y;
    private int mapWidth, mapHeight;
    private Rectangle viewPort;

    public Camera(int mapWidth, int mapHeight) {
        x = 0;
        y = 0;
        viewPort = new Rectangle(0, 0, Game.WIDTH, Game.HEIGHT);
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
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