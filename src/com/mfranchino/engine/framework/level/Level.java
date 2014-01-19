/*
 * @(#)Level.java   2014-01-15
 * 
 * Copyright (c) 2014 Michael Franchino
 *
 *
 *
 *
 */



package com.mfranchino.engine.framework.level;

//~--- non-JDK imports --------------------------------------------------------
import com.mfranchino.engine.framework.entities.EntityLayers;
import com.mfranchino.engine.framework.game.GameLoop;
import com.mfranchino.engine.framework.game.Player;
import com.mfranchino.engine.framework.game.Camera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Level implements GameLoop {
	private static Camera  camera;
	private boolean        expired;
	private TiledMap       map;
	protected EntityLayers entityLayers;    // used for backgrounds, mobs, inventory items, drops, etc.
	protected Player       player;          // used for player

	// Constructors
	public Level() {
		player = null;
		map    = null;
		camera = new Camera();
	}

	// TODO Rename to indicate usage and make a static constructor
	public <E extends Enum<E>>Level(Class<E> layerEnum) {
		this();
		entityLayers = new EntityLayers(layerEnum);
	}

	// TODO Rename to indicate usage and make a static constructor
	public Level(int layerCount) {
		this();
		entityLayers = new EntityLayers(layerCount);
	}

	public static Camera getCamera() {
		return camera;
	}

	public final int getHeightInTiles() {
		return map.getHeight();
	}

	// Helpers
	public int getLayerCount() {
		return entityLayers.getLayerCount();
	}

	public final TiledMap getMap() {
		return map;
	}

	public final int getMapHeight() {
		return map.getHeight() * map.getTileHeight();
	}

	public final int getMapWidth() {
		return map.getWidth() * map.getTileWidth();
	}

	public final Player getPlayer() {
		return player;
	}

	public final int getWidthInTiles() {
		return map.getWidth();
	}

	public final void setMap(TiledMap map) {
		this.map = map;

		// If the map changes, the camera also have to change its coordinates
		camera.setMapHeight(getMapHeight());
		camera.setMapWidth(getMapWidth());
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		// Focus camera on the player
		camera.translate(g, player);
		map.render(0, 0);
		entityLayers.render(gc, g);
		player.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		player.update(gc, delta, getMapWidth(), getMapHeight(), map.getTileWidth(), map.getTileHeight());
		entityLayers.update(gc, delta);
	}

	// Game loop methods
	@Override
	public abstract void init(GameContainer gc);
}