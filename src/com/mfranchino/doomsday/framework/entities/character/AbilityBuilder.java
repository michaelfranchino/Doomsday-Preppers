/*
 * Copyright (C) 2014 mfranchino
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mfranchino.doomsday.framework.entities.character;

/**
 * Fluent API builder for the AbilityScores object
 * @author mfranchino
 * @version 0.1
 */
public class AbilityBuilder {

	private final AbilityScores _temp; 
	private AbilityModifier abilityModifier;
	private int index;
	private int modifier;

	public static AbilityBuilder create() {
		return new AbilityBuilder();
	}
	
	public static AbilityBuilder update(AbilityScores _temp) {
		return new AbilityBuilder(_temp);
	}

	private AbilityBuilder() {
		this._temp = new AbilityScores();
	}
	
	private AbilityBuilder(AbilityScores _temp) {
		this._temp = _temp;
	}

  /**
   * The with method will allow all subsequent ability scores to be placed in the appropriate bucket.
   * @param abilityModifier Enumeration that determines which "bucket" ability score should be stored in
   * @return the builder to allow for chaining
   */
	public AbilityBuilder with(AbilityModifier abilityModifier) {
		this.abilityModifier = abilityModifier;
		this.index = abilityModifier.getIndex();
		this.modifier = abilityModifier.getModifier();
		return this;
	}

  /**
   * This method is used to update the Strength ability
   * @param value value to set for the strength ability
   * @return <CODE>AbilityBuilder</CODE> the builder to allow for chaining
   */
	public AbilityBuilder strength(int value) {
		_temp.setStrength(index, value * modifier);
		return this;
	}
  /**
  * This method is used to update the dexterity ability
  * @param value value to set for the dexterity ability
  * @return the builder to allow for chaining
  * @see AbilityScores#setDexterity
  */
	public AbilityBuilder dexterity(int value) {
		_temp.setDexterity(index, value * modifier);
		return this;
	}
  /**
  * Constitution ability can be updated to value supplied
  * @param value value to set for the constitution ability
  * @return the builder to allow for chaining
  */
	public AbilityBuilder constitution(int value) {
		_temp.setConstitution(index, value * modifier);
		return this;
	}
  /**
  * Intelligence ability can be updated to value supplied
  * @param value value to set for the intelligence ability
   * @return the builder to allow for chaining
  */
	public AbilityBuilder intelligence(int value) {
		_temp.setIntelligence(index, value * modifier);
		return this;
	}
  /**
   * Wisdom ability can be updated to value supplied
   * @param value value to set for the wisdom ability
   * @return the builder to allow for chaining
   */
	public AbilityBuilder wisdom(int value) {
		_temp.setWisdom(index, value * modifier);
		return this;
	}
  /**
   * Charisma ability can be updated to value supplied
   * @param value value to set for the charisma ability
   * @return the builder to allow for chaining
   */
	public AbilityBuilder charisma(int value) {
		_temp.setCharisma(index, value * modifier);
		return this;
	}
  /**
   * Required by the fluent API to finalize the create/update of ability scores
   * @return the AbilityScores
   * @see AbilityScores
   */
	public AbilityScores end() {
		return _temp;
	}
}