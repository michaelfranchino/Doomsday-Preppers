package com.mfranchino.doomsday.game.level;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.mfranchino.doomsday.framework.entities.EntityList;
import com.mfranchino.doomsday.framework.entities.IEntity;
import com.mfranchino.doomsday.game.objects.Box;
import com.mfranchino.doomsday.game.objects.MainMenu;
import com.mfranchino.doomsday.game.objects.Player;

public class TestLevel extends Level implements IEntity {

	EntityList<IEntity> entities;

	// <editor-fold defaultstate="collapsed" desc="Constructors">
	public <E extends Enum<E>> TestLevel(Class<E> layerEnum) {
		super(layerEnum);
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Game loop framework methods">
	public void init(GameContainer gc) {
		
		// initialize the map
		try {
			this.setMap(new TiledMap("res/tiledmaps/map.tmx"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create the player
		player = new Player(0, 50, 100, 64, 32);
		player.init(gc);

		Box box = null;
		Random rand = new Random();

		MainMenu menu = new MainMenu(0, 300, 150, 0, 0);
		menu.init(gc);
		menus.add(menu);
//
//		for (int i = 0; i < 60; i++) {
//			box = new Box(i, rand.nextInt(200), rand.nextInt(550),
//					rand.nextInt(100) + 10, rand.nextInt(100) + 10);
//			box.init(gc);
//			box.setVelX(rand.nextInt(300) - 150);
//			box.setVelY(rand.nextInt(300) - 150);
//			box.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand
//					.nextInt(255), rand.nextInt(255)));
//			// TODO This needs a better interface
//			entityLayers.getLayer(TestLayerEnum.Mobs).add(box);
//		}
//		entityLayers.getLayer(TestLayerEnum.Mobs).setEnabled(false);
//		entityLayers.getLayer(TestLayerEnum.Background).setEnabled(false);
//		entityLayers.getLayer(TestLayerEnum.Player).setEnabled(false);
	}

	public void update(GameContainer gc, int delta) {
		super.update(gc, delta);
		if (!menus.get(0).isEnabled()) {
			entityLayers.getLayer(TestLayerEnum.Mobs).setEnabled(true);
			entityLayers.getLayer(TestLayerEnum.Background).setEnabled(true);
			entityLayers.getLayer(TestLayerEnum.Player).setEnabled(true);
		}
	}

	public void render(GameContainer gc, Graphics g) {
		super.render(gc, g);
	}
	// </editor-fold>
}
