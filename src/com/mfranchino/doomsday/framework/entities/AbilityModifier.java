package com.mfranchino.doomsday.framework.entities;

public enum AbilityModifier {
  BASESCORE(1, "Base score", 1),
  RACIALMODIFIER(2, "Racial modifiers", 1),
  ENHANCEMENTBONUSES(3, "Enhancement bonuses", 1),
  MISCBONUSES(4, "Miscellaneous bonuses", 1),
  MISCPENALTIES(5, "Miscellaneous penalties", -1),
  MODIFIER(6, "Modifier", 1);

  private final int index;
  private final String description;
	private final int modifier;

  private AbilityModifier(int index, String description, int modifier) {
    this.index = index;
    this.description = description;
		this.modifier = modifier;
  }

  public int getIndex() {
    return index;
  }
  public String getDescription() {
    return description;
  }
	public int getModifier() {
		return modifier;
	}
}
