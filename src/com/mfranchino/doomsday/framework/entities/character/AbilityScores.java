package com.mfranchino.doomsday.framework.entities.character;

/**
 * Each ability partially describes your character and affects some of his or her actions.
 *
 * <UL>
 *   <LI>Strength {@link AbilityScores#strength}
 *   <LI>Dexterity {@link AbilityScores#dexterity}
 *   <LI>Constitution {@link AbilityScores#constitution}
 *   <LI>Intelligence {@link AbilityScores#intelligence}
 *   <LI>Wisdom {@link AbilityScores#wisdom}
 *   <LI>Charisma {@link AbilityScores#charisma}
 *
 * @author mfranchino
 */
public final class AbilityScores {

  /**
   * Strength measures muscle and physical power. This ability is important for those who engage in hand-to-hand (or “melee”) combat.
   * Strength also sets the maximum amount of weight your character can carry. A character with a Strength score of 0
   * is too weak to move in any way and is unconscious
   */
	private int[] strength = new int[AbilityModifier.values().length];
  /**
   * Dexterity measures hand-eye coordination, agility, reflexes, and balance.This ability is vital for characters seeking to excel
   * with ranged weapons, such as the bow or sling. A character with a Dexterity score of 0 is incapable of moving and
   * is effectively immobile (but not unconscious).
   */
	private int[] dexterity = new int[AbilityModifier.values().length];
  /**
   * Constitution represents your character's health and stamina. A Constitution bonus increases a character's hit points.
   * A character with a Constitution score of 0 is dead.
   */
	private int[] constitution = new int[AbilityModifier.values().length];
  /**
   * Intelligence determines how well your character learns and reasons.
   * A character with an Intelligence score of 0 is comatose.
   */
	private int[] intelligence = new int[AbilityModifier.values().length];
  /**
   * Wisdom describes a character's willpower, common sense, perception, and intuition.
   * A character with a Wisdom score of 0 is incapable of rational thought and is unconscious.
   */
	private int[] wisdom = new int[AbilityModifier.values().length];
  /**
   * Charisma measures a character's force of personality, persuasiveness, personal magnetism, ability to lead, and physical
   * attractiveness. This ability represents actual strength of personality, not merely how one is perceived by others in a social setting.
   * A character with a Charisma score of 0 is not able to exert himself in any way and is unconscious.
   */
	private int[] charisma = new int[AbilityModifier.values().length];

  /**
   * This method is used to update an ability score object using the fluent api interface.
   *
   * @return AbilityBuilder the ability builder fluent API
   */
	public AbilityBuilder update() {
		return AbilityBuilder.update(this);
	}

  /**
   * @see # setStrength(int, int)
   */

	public int getStrength() {
		return sum(strength);
	}

  /**
   * This method is used to set the strength ability
   * @param index      index of strength component, set by enumeration.
   * @param value      value to set for the dexterity ability
   * @see AbilityModifier
   */
	public void setStrength(int index, int value) {
		this.strength[index] = value;
	}

  /**
   * @see # setDexterity(int, int)
   */
	public int getDexterity() {
		return sum(dexterity);
	}

  /**
   * This method is used to set the dexterity ability
   * @param index      index of dexterity component, set by enumeration.
   * @param value      value to set for the dexterity ability
   * @see AbilityModifier
   */
	public void setDexterity(int index, int value) {
		this.dexterity[index] = value;
	}

  /**
   * @see # setConstitution(int, int)
   */
	public int getConstitution() {
		return sum(constitution);
	}

  /**
   * This method is used to set the constitution ability
   * @param index      index of constitution component, set by enumeration.
   * @param value      value to set for the dexterity ability
   * @see AbilityModifier
   */
	public void setConstitution(int index, int value) {
		this.constitution[index] = value;
	}

  /**
   * @see # setIntelligence(int, int)
   */
	public int getIntelligence() {
		return sum(intelligence);
	}

  /**
   * This method is used to set the intelligence ability
   * @param index      index of intelligence component, set by enumeration.
   * @param value      value to set for the dexterity ability
   * @see AbilityModifier
   */
	public void setIntelligence(int index, int value) {
		this.intelligence[index] = value;
	}

	public int getWisdom() {
		return sum(wisdom);
	}

  /**
   * This method is used to set the wisdom ability
   * @param index      index of wisdom component, set by enumeration.
   * @param value      value to set for the dexterity ability
   * @see AbilityModifier
   */
	public void setWisdom(int index, int value) {
		this.wisdom[index] = value;
	}

	public int getCharisma() {
		return sum(charisma);
	}

	public void setCharisma(int index, int value) {
		this.charisma[index] = value;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("AbilityScores{");
		sb.append("strength=");
		if (strength == null) {
			sb.append("null");
		} else {
			sb.append(getStrength());
			sb.append(" [");
			for (int i = 0; i < strength.length; ++i) {
				sb.append(i == 0 ? "" : ", ").append(strength[i]);
			}
			sb.append(']');
		}
		sb.append(", dexterity=");
		if (dexterity == null) {
			sb.append("null");
		} else {
			sb.append(getDexterity());
			sb.append(" [");
			for (int i = 0; i < dexterity.length; ++i) {
				sb.append(i == 0 ? "" : ", ").append(dexterity[i]);
			}
			sb.append(']');
		}
		sb.append(", constitution=");
		if (constitution == null) {
			sb.append("null");
		} else {
			sb.append(getConstitution());
			sb.append(" [");
			for (int i = 0; i < constitution.length; ++i) {
				sb.append(i == 0 ? "" : ", ").append(constitution[i]);
			}
			sb.append(']');
		}
		sb.append(", intelligence=");
		if (intelligence == null) {
			sb.append("null");
		} else {
			sb.append(getIntelligence());
			sb.append(" [");
			for (int i = 0; i < intelligence.length; ++i) {
				sb.append(i == 0 ? "" : ", ").append(intelligence[i]);
			}
			sb.append(']');
		}
		sb.append(", wisdom=");
		if (wisdom == null) {
			sb.append("null");
		} else {
			sb.append(getWisdom());
			sb.append(" [");
			for (int i = 0; i < wisdom.length; ++i) {
				sb.append(i == 0 ? "" : ", ").append(wisdom[i]);
			}
			sb.append(']');
		}
		sb.append(", charisma=");
		if (charisma == null) {
			sb.append("null");
		} else {
			sb.append(getCharisma());
			sb.append(" [");
			for (int i = 0; i < charisma.length; ++i) {
				sb.append(i == 0 ? "" : ", ").append(charisma[i]);
			}
			sb.append(']');
		}
		sb.append('}');
		return sb.toString();
	}

	private int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
}
