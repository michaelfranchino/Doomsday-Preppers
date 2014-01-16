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
package com.mfranchino.doomsday.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * The main game interface that should be implemented by any game being developed
 * using the container system. There will be some utility type sub-classes as development
 * continues.
 * 
 * This is a subset of the slick2d GAME interface
 *
 * @author mfranchino
 */
public interface GameLoop {

	/**
	* initialize the game. This can be used to load static resources. It's called
	* before the game loop starts
	* 
	* @param gc The container holding the game
	* @throws SlickException Throw to indicate an internal error
	*/
	void init(GameContainer gc) throws SlickException;

	/**
	* Render the game/'s screen here. 
	* 
	* @param gc The container holing this game
	* @param g The graphics context that can be used to render. However, normal rendering
	* routines can also be used.
	 * @throws SlickException Throw to indicate a internal error
	*/
	void render(GameContainer gc, Graphics g) throws SlickException;

  /**
	* Update the game logic here. No rendering should take place in this method
	* though it won't do any harm. 
	* 
	* @param gc The container holing this game
	* @param delta The amount of time thats passed since last update in milliseconds
	* @throws SlickException Throw to indicate an internal error
	*/
	void update(GameContainer gc, int delta) throws SlickException;
	
}
