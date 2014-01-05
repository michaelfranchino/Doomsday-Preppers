package com.mfranchino.doomsday.game.level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;

import com.mfranchino.doomsday.framework.entities.EntityLayers;
import com.mfranchino.doomsday.framework.entities.EntityList;
import com.mfranchino.doomsday.framework.entities.IEntity;
import com.mfranchino.doomsday.game.objects.Player;

public abstract class Level implements IEntity {
	
	private TiledMap	map;
	
	protected boolean expired;
	protected EntityLayers entityLayers;		// used for backgrounds, mobs, inventory items, drops, etc. 
	protected Player player;					// used for player
	protected EntityList<IEntity> menus;		// used for menus
	
	// Constructors
	public Level() {
		player = null;
		map = null;
		menus = new EntityList<IEntity>();
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
	public abstract void init(GameContainer gc);
	public void update(GameContainer gc, int delta) {
		player.update(gc, delta, getMapWidth(), getMapHeight(), map.getTileWidth(), map.getTileHeight());
		entityLayers.update(gc, delta);
		if (menus.isEnabled()) menus.update(gc, delta);
	}
	public void render(GameContainer gc, Graphics g) {
		entityLayers.render(gc, g);
		map.render(0, 0);
		if (menus.isEnabled()) menus.render(gc, g);
		player.render(gc, g);
	}

	// Framework
	public boolean isExpired() {
		return expired;
	}
	public void expire() {
		expired = true;
	}
	public void onExpire() {
		entityLayers.expire();
	}
	public final boolean isEnabled() {
		return true;
	}
	public final boolean isVisible() {
		return true;
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