package com.mfranchino.doomsday.framework.entities.character;

import com.mfranchino.doomsday.framework.entities.Attributes;
import com.mfranchino.doomsday.framework.entities.BaseEntity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Created by mfranchino on 1/13/14.
 */
public abstract class Character extends BaseEntity {

  private final String name;
  private final Race race;
  private final CharacterClass characterClass;
  private final Gender gender;
  private final float characterWeight, characterHeight;
  private final Alignment alignment;
  private final Attributes attributes;
  private final Defenses defenses;
  private final Movement movement;
  private final Senses senses;


  /**
   * Creates a new entity in game world.
   *
   * @param id     Id of new entity
   * @param x      starting x position in world
   * @param y      starting y position in world
   * @param height starting height of entity in world
   * @param width  starting width of entity in world
   */
  protected Character(int id, float x, float y, float height, float width) {
    super(id, x, y, height, width);

    // TODO:  need to initialize these in the INIT method??

    name = "";
    race = new Race();
    characterWeight = 0;
    characterHeight = 0;
    gender = Gender.MALE;
    characterClass = new CharacterClass();
    alignment = Alignment.NEUTRAL;
    attributes = new Attributes();
    defenses = new Defenses();
    movement = new Movement();
    senses = new Senses();
  }

  @Override
  public void init(GameContainer gc) throws SlickException {

  }

  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException {

  }
}
