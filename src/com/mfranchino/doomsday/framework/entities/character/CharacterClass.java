package com.mfranchino.doomsday.framework.entities.character;

/**
 * Created by mfranchino on 1/13/14.
 */
public class CharacterClass {

  private final String name;
  private final int level;
  private final int baseSaveBonus;
  private final int baseAttackBonus;
  private final int skillMaxRank;
  private final double crossSkilMaxRank;

  public CharacterClass() {
    name = null;
    level = 0;
    baseSaveBonus = 0;
    baseAttackBonus = 0;
    skillMaxRank = 0;
    crossSkilMaxRank = 0;
  }
}
