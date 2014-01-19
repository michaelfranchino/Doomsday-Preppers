package com.mfranchino.engine.framework.entities.character;

/**
 * Represents an ability modifier.
 * <p>
 * There are <b>3</b> parts to an <CODE>AbilityModifier</CODE> enumeration value.
 * <UL>
 *   <LI>Index
 *   <LI>Description
 *   <LI>Modifier
 * </UL>
 * <p>
 * The ability score is comprised of a number of values, which are stored in a bucket for each ability. The description of each
 * bucket is designated by the enumeration description. The <i>modifier</i> is used to determine if the value is positive or negative.
 * <p>
 * For example, the {@LINK AbilityScore} object contains an array for each of the 6 ability scores. The array length is based on the
 * number of values in the AbilityModifier enumeration. Each slot in the array will contain a value that when the array is cross-footed,
 * the total score becomes that ability score. Each slot in the array can be either positive (increasing the ability) or negative (decreasing)
 * the ability.
 *
 * @author Michael Franchino
 * @since 1/13/2014
 */
public enum AbilityModifier {
  /**
   * Represents a "Base score" ability modifier
   */
  BASESCORE(1, "Base score", 1),
  /**
   * Represents a "Racial modifier" ability modifier
   */
  RACIALMODIFIER(2, "Racial modifiers", 1),
  /**
   * Represents an "Enhancement bonuses" ability modifier
   */
  ENHANCEMENTBONUSES(3, "Enhancement bonuses", 1),
  /**
   * Represents a "Miscellaneous bonuses" ability modifier
   */
  MISCBONUSES(4, "Miscellaneous bonuses", 1),
  /**
   * Represents a "Miscellaneous penalties" ability modifier. This modifier will be negative.
   */
  MISCPENALTIES(5, "Miscellaneous penalties", -1),
  /**
   * Represents a "Modifier" ability modifier.
   */
  MODIFIER(6, "Modifier", 1);

  private final int index;
  private final String description;
  private final int modifier;

  private AbilityModifier(int index, String description, int modifier) {
    this.index = index;
    this.description = description;
    this.modifier = modifier;
  }

  /**
   *
   * @return the index of the selected enumeration
   */
  public int getIndex() {
    return index;
  }

  /**
   *
   * @return the description of the selected enumeration
   */
  public String getDescription() {
    return description;
  }

  /**
   *
   * @return the modifier of the selected enumeration
   */
  public int getModifier() {
    return modifier;
  }
}
