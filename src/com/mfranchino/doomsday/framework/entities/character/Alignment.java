package com.mfranchino.doomsday.framework.entities.character;

/**
 * Created by mfranchino on 1/13/14.
 */
public enum Alignment {

  LAWFUL_GOOD("Lawful good"),
  LAWFUL_NEUTRAL("Lawful neutral"),
  LAWFUL_EVIL("Lawful evil"),
  NEUTRAL_GOOD("Neutral good"),
  NEUTRAL("Neutral"),
  NEUTRAL_EVIL("Neutral evil"),
  CHAOTIC_GOOD("Chaotic good"),
  CHAOTIC_NEUTRAL("Chaotic neutral"),
  CHAOTIC_EVIL("Chaotic evil");

  private final String description;

  private Alignment(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
