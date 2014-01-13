package com.mfranchino.doomsday.framework.level;

import com.mfranchino.doomsday.framework.entities.Entity;
import com.mfranchino.doomsday.framework.entities.EntityLayers;
import com.mfranchino.doomsday.framework.entities.EntityList;
import com.mfranchino.doomsday.game.GameLoop;
import com.mfranchino.doomsday.game.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Level implements GameLoop {

	private TiledMap map;

	private boolean expired;
	protected EntityLayers entityLayers;	// used for backgrounds, mobs, inventory items, drops, etc.
	protected Player player;					    // used for player
	protected final EntityList<Entity> menus;		// used for menus

	// Constructors
	public Level() {
		player = null;
		map = null;
		menus = new EntityList<>();
	}

	public Level(int layerCount) {
		this();
		entityLayers = new EntityLayers(layerCount);
	}

	public <E extends Enum<E>> Level(Class<E> layerEnum) {
		this();
		entityLayers = new EntityLayers(layerEnum);
	}

	// Game loop methods
	@Override
	public abstract void init(GameContainer gc);

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		player.update(gc, delta, getMapWidth(), getMapHeight(), map.getTileWidth(), map.getTileHeight());
		entityLayers.update(gc, delta);
		if (menus.isEnabled()) {
			menus.update(gc, delta);
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		map.render(0, 0);
		entityLayers.render(gc, g);
		if (menus.isEnabled()) {
			menus.render(gc, g);
		}
		player.render(gc, g);
	}

	// Helpers
	public int getLayerCount() {
		return entityLayers.getLayerCount();
	}

	public final Player getPlayer() {
		return player;
	}

	public final void setMap(TiledMap map) {
		this.map = map;
	}

	public final TiledMap getMap() {
		return map;
	}

	public final int getMapWidth() {
		return map.getWidth() * map.getTileWidth();
	}

	public final int getMapHeight() {
		return map.getHeight() * map.getTileHeight();
	}

	public final int getWidthInTiles() {
		return map.getWidth();
	}

	public final int getHeightInTiles() {
		return map.getHeight();
	}
}