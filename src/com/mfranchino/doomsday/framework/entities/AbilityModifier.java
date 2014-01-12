package com.mfranchino.doomsday.framework.entities;

public enum AbilityModifier {
  BASESCORE(1, "Base score"),
  RACIALMODIFIER(2, "Racial modifiers"),
  ENHANCEMENTBONUSES(3, "Enhancement bonuses"),
  MISCBONUSES(4, "Miscellaneous bonuses"),
  MISCPENALTIES(5, "Miscellaneous penalties"),
  MODIFIER(6, "Modifier");

  private final int index;
  private final String description;

  private AbilityModifier(int index, String description) {
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
