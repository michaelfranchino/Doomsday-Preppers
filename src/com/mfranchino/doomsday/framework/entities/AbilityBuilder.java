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
package com.mfranchino.doomsday.framework.entities;

/**
 *
 * @author mfranchino
 */
// Inner classes
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
	
	public AbilityBuilder with(AbilityModifier abilityModifier) {
		this.abilityModifier = abilityModifier;
		this.index = abilityModifier.getIndex();
		this.modifier = abilityModifier.getModifier();
		return this;
	}

	public AbilityBuilder strength(int value) {
		_temp.setStrength(index, value * modifier);
		return this;
	}

	public AbilityBuilder dexterity(int value) {
		_temp.setDexterity(index, value * modifier);
		return this;
	}

	public AbilityBuilder constitution(int value) {
		_temp.setConstitution(index, value * modifier);
		return this;
	}

	public AbilityBuilder intelligence(int value) {
		_temp.setIntelligence(index, value * modifier);
		return this;
	}

	public AbilityBuilder wisdom(int value) {
		_temp.setWisdom(index, value * modifier);
		return this;
	}

	public AbilityBuilder charisma(int value) {
		_temp.setCharisma(index, value * modifier);
		return this;
	}

	public AbilityScores end() {
		return _temp;
	}
}