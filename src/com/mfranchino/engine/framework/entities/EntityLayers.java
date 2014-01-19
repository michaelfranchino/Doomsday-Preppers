/*
 * @(#)EntityLayers.java   2014-01-03
 * 
 * Copyright (c) 2014 Michael Franchino
 *
 *
 *
 *
 */
package com.mfranchino.engine.framework.entities;

//~--- non-JDK imports --------------------------------------------------------

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class EntityLayers implements Entity {
	private final EntityLayer[] layers;
	private boolean             expired;

	// <editor-fold defaultstate="collapsed" desc="Contructors">
	public <E extends Enum<E>>EntityLayers(Class<E> layerEnum) {
		this(layerEnum.getEnumConstants().length, layerEnum);
	}

	// Initialize the number of layers to store
	public EntityLayers(int layerCount) {
		layers = new EntityLayer[layerCount];

		for (int i = 0; i < layerCount; i++) {
			layers[i] = new EntityLayer(i);
		}
	}

	// Create layers be enumeration with name
	private <E extends Enum<E>>EntityLayers(int layerCount, Class<E> layerEnum) {
		layers = new EntityLayer[layerCount];

		for (E index : layerEnum.getEnumConstants()) {
			layers[index.ordinal()] = new EntityLayer(index.ordinal(), index.name());
		}
	}

//  </editor-fold>

	// add layer to layers by enumeration
	public void add(Enum<?> index, EntityLayer e) {
		layers[index.ordinal()].add(e);
	}

	// add layer by index #
	public void add(int index, EntityLayer e) {
		layers[index].add(e);
	}

	// Expire each layer
	@Override
	public void expire() {
		for (EntityLayer layer : layers) {
			layer.expire();
		}

		expired = true;
	}

	public EntityLayer getLayer(Enum<?> index) {
		return layers[index.ordinal()];
	}

	public EntityLayer getLayer(int index) {
		return layers[index];
	}

	public int getLayerCount() {
		return layers.length;
	}

	@Override
	public boolean isExpired() {
		return expired;
	}

	@Override
	public void onExpire() {
		for (EntityLayer layer : layers) {
			layer.onExpire();
		}
	}

//  <editor-fold defaultstate="collapsed" desc="Game loop framework methods">
	// initialize any settings that need to be in place before starting
	@Override
	public void init(GameContainer gc) throws SlickException {
		for (EntityLayer layer : layers) {
			layer.init(gc);
		}
	}

	// Update each layer's entities
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		for (EntityLayer layer : layers) {
			layer.update(gc, delta);
		}
	}

	// Render each layer's entities
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (EntityLayer layer : layers) {
			layer.render(gc, g);
		}
	}

//  </editor-fold>

	@Override
	public final boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isVisible() {
		return true;
	}
}