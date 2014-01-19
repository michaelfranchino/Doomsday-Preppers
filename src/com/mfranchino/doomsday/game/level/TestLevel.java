package com.mfranchino.doomsday.game.level;

import com.mfranchino.engine.framework.entities.Entity;
import com.mfranchino.engine.framework.entities.EntityList;
import com.mfranchino.engine.framework.entities.particles.Particle;
import com.mfranchino.engine.framework.level.Level;
import com.mfranchino.engine.framework.game.Player;
import com.mfranchino.doomsday.game.objects.Box;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Random;
import java.util.logging.Logger;

public class TestLevel extends Level {

  EntityList<Entity> entities;

  // <editor-fold defaultstate="collapsed" desc="Constructors">
  public <E extends Enum<E>> TestLevel(Class<E> layerEnum) {
    super(layerEnum);
  }

  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Game loop framework methods">
  @Override
  public void init(GameContainer gc) {
    try {
      gc.setMouseCursor("res/level/glove_mouse_cursor_S.png", 25, 1);
    } catch (SlickException ex) {
      Logger.getLogger(TestLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    // initialize the map
    try {
      this.setMap(new TiledMap("res/tiledmaps/map.tmx"));
    } catch (SlickException e) {
    }

    // create the player
    player = new Player(0, 50, 100, 5, 5);
    player.init(gc);

    Particle particle = new Particle("data/test_emitter.xml", 2, 0, 0, 64, 32);
    try {
      particle.init(gc);
    } catch (SlickException ex) {
      Logger.getLogger(TestLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    entityLayers.getLayer(TestLayerEnum.Mobs).add(particle);

    // Enable the MOBS layer
    entityLayers.getLayer(TestLayerEnum.Mobs).setEnabled(true);
    entityLayers.getLayer(TestLayerEnum.Mobs).setVisible(true);

    Box box = null;
    Random rand = new Random();
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

  @Override
  public void update(GameContainer gc, int delta) throws SlickException {
    super.update(gc, delta);
  }

  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException {
    super.render(gc, g);
  }
  // </editor-fold>
}
