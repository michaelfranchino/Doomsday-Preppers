package com.mfranchino.engine.framework.entities.character;

/**
 * Created by mfranchino on 1/13/14.
 */
public enum DefenseModifier {

  BASE_SAVE(0, "Base save"),
  ABILITY_MODIFIER(1, "Ability modifier"),
  MAGIC_MODIFIER(2, "Magic modifier"),
  MISC_MODIFIER(3, "Miscellaneous modifier"),
  TEMP_MODIFIER(4, "Temporary modifier");

  private final int index;
  private final String description;

  private DefenseModifier(int index, String description) {
    this.index = index;
    this.description = description;
  }

  public int getIndex() {
    return index;
  }

  public String getDescription() {
    return description;
  }
}
