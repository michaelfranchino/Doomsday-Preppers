/*
 * @(#)EntityLayers.java   2014-01-03
 * 
 * Copyright (c) 2014 Michael Franchino
 *
 *
 *
 *
 */
package com.mfranchino.doomsday.framework.entities;

//~--- non-JDK imports --------------------------------------------------------

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class EntityLayers implements IEntity {
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
	public void expire() {
		for (int i = 0; i < layers.length; i++) {
			layers[i].expire();
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

	public boolean isExpired() {
		return expired;
	}

	public void onExpire() {
		for (int i = 0; i < layers.length; i++) {
			layers[i].onExpire();
		}
	}

//  <editor-fold defaultstate="collapsed" desc="Game loop framework methods">
	// initialize any settings that need to be in place before starting
	public void init(GameContainer gc) {
		for (int i = 0; i < layers.length; i++) {
			layers[i].init(gc);
		}
	}

	// Update each layer's entities
	public void update(GameContainer gc, int delta) {
		for (int i = 0; i < layers.length; i++) {
			layers[i].update(gc, delta);
		}
	}

	// Render each layer's entities
	public void render(GameContainer gc, Graphics g) {
		for (int i = 0; i < layers.length; i++) {
			layers[i].render(gc, g);
		}
	}

//  </editor-fold>

	public final boolean isEnabled() {
		return true;
	}

	public boolean isVisible() {
		return true;
	}
}