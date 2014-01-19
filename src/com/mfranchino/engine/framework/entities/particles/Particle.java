/*
 * Copyright (C) 2014 mfranchino
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mfranchino.engine.framework.entities.particles;

import com.mfranchino.engine.framework.entities.BaseEntity;
import com.mfranchino.engine.framework.level.Level;
import com.mfranchino.doomsday.game.Game;
import com.mfranchino.engine.framework.game.Camera;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.util.Log;

import java.io.File;

/**
 *
 * @author mfranchino
 */
public class Particle extends BaseEntity {

	private ParticleSystem system;

	public void setSystem(ParticleSystem system) {
		this.system = system;
	}

	public ParticleSystem getSystem() {
		return system;
	}

	public String getXmlPath() {
		return xmlPath;
	}
	private final String xmlPath;

	public Particle(String xmlPath, int id, float x, float y, float height, float width) {
		super(id, x, y, height, width);

		this.xmlPath = xmlPath;
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		try {
			File xmlFile = new File(xmlPath);
			ConfigurableEmitter emitter = ParticleIO.loadEmitter(xmlFile);

      this.enabled = true;
      this.visible = true;

			Image image = new Image(emitter.imageName);
			this.system = new ParticleSystem(image, 1500);

			emitter.setPosition(this.getX(), this.getY());
			system.addEmitter(emitter);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		system.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		system.render();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		Camera camera = Level.getCamera();
		
		system.setPosition(input.getMouseX() - camera.getX(), input.getMouseY() - camera.getY());

		system.update(delta);
	}

	@Override
	public void onExpire() {
	}
}
