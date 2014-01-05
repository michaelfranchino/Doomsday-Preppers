package com.mfranchino.doomsday.game.objects;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import com.mfranchino.doomsday.framework.entities.BaseEntity;

public class Box extends BaseEntity {

	// TODO remove this
	//TrueTypeFont font = new TrueTypeFont(new java.awt.Font("Verdana", Font.BOLD, 12), false);
	Color color;

	public Box(int id, int x, int y, int height, int width) {
		super(id, x, y, height, width);

		color = Color.white;
	}

	public void init(GameContainer gc) {
		this.enabled = true;
		this.visible = true;
	}

	public void onExpire() {
	}

	public void render(GameContainer gc, Graphics g) {
		g.setColor(color);
		g.fillRect(getX(), getY(), getWidth(), getHeight());

		// TODO remove this
		//	g.setFont(font);
		//		g.setColor(Color.white);
		//g.drawString(this.toString(), 50, 100);
	}

	public void update(GameContainer gc, int delta) {
		super.update(gc, delta);
	}

	public final Color getColor() {
		return color;
	}

	public final void setColor(Color color) {
		this.color = color;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [ID=");
		builder.append(getId());
		builder.append(", Color=");
		builder.append(color.toString());
		builder.append(", X=");
		builder.append(getX());
		builder.append(", Y()=");
		builder.append(getY());
		builder.append(", H=");
		builder.append(getHeight());
		builder.append(", W=");
		builder.append(getWidth());
		builder.append("]");
		return builder.toString();
	}

}
