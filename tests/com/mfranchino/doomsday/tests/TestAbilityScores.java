package com.mfranchino.doomsday.tests;

import com.mfranchino.doomsday.framework.entities.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mfranchino on 1/11/14.
 */
public class TestAbilityScores {

	@Test
	public void testCreationOfAbility() {
		AbilityScores ab = AbilityBuilder.create()
						.with(AbilityModifier.BASESCORE)
							.strength(10)
							.intelligence(10)
							.wisdom(18)
							.dexterity(10)
							.charisma(8)
							.constitution(15)
						.end();

		Assert.assertEquals(10, ab.getStrength());
		Assert.assertEquals(10, ab.getIntelligence());
		Assert.assertEquals(18, ab.getWisdom());
		Assert.assertEquals(10, ab.getDexterity());
		Assert.assertEquals(8, ab.getCharisma());
		Assert.assertEquals(15, ab.getConstitution());
	}

	@Test
	public void testUpdateOfAbility() {
		AbilityScores ab = AbilityBuilder.create()
						.with(AbilityModifier.BASESCORE)
							.strength(10)
							.intelligence(10)
							.wisdom(18)
							.dexterity(10)
							.charisma(8)
							.constitution(15)
						.end();

		AbilityBuilder.update(ab)
						.with(AbilityModifier.MISCBONUSES)
						.strength(5)
						.end();

		ab.udpate()
						.with(AbilityModifier.RACIALMODIFIER)
						.strength(11)
						.end();

		Assert.assertEquals(26, ab.getStrength());
		Assert.assertEquals(10, ab.getIntelligence());
		Assert.assertEquals(18, ab.getWisdom());
		Assert.assertEquals(10, ab.getDexterity());
		Assert.assertEquals(8, ab.getCharisma());
		Assert.assertEquals(15, ab.getConstitution());

		System.out.println(ab.toString());
	}

	@Test
	public void testPenalitiesAbility() {
		AbilityScores ab = AbilityBuilder.create()
						.with(AbilityModifier.BASESCORE)
							.strength(10)
							.intelligence(10)
							.wisdom(18)
							.dexterity(10)
							.charisma(8)
							.constitution(15)
						.end();

		ab.udpate()
				.with(AbilityModifier.MISCPENALTIES)
					.strength(4)
					.intelligence(2)
					.wisdom(2)
					.dexterity(3)
					.charisma(4)
					.constitution(5)
				.end();

		Assert.assertEquals(6, ab.getStrength());
		Assert.assertEquals(8, ab.getIntelligence());
		Assert.assertEquals(16, ab.getWisdom());
		Assert.assertEquals(7, ab.getDexterity());
		Assert.assertEquals(4, ab.getCharisma());
		Assert.assertEquals(10, ab.getConstitution());

		System.out.println(ab.toString());
	}
}
