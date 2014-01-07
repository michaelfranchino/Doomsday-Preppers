package com.mfranchino.doomsday.framework.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class EntityLayer extends EntityList<Entity> implements Entity{

	protected final int index;
	protected boolean visible;
	protected boolean enabled;
	protected final String name;

//<editor-fold defaultstate="collapsed" desc="Constructors">
	public EntityLayer(int index) {
		this.index = index;
		this.name = "";
	}
	public EntityLayer(int index, String name) {
		this.index = index;
		this.name = name;
	}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/">
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getIndex() {
		return index;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	@Override
	public boolean isVisible() {
		return visible;
	}
	public final String getName() {
		return name;
	}
//</editor-fold>
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntityLayer [index=");
		builder.append(index);
		builder.append(", visible=");
		builder.append(visible);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

//<editor-fold defaultstate="collapsed" desc="Game look framework methods">
	@Override
	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
		
		this.setEnabled(true);
		this.setVisible(true);
	}
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		if (enabled) {
			super.update(gc, delta);
		}
	}
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (visible) {
			super.render(gc, g);
		}
	}
//</editor-fold>
}
