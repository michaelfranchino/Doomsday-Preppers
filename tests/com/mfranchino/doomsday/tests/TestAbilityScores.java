package com.mfranchino.doomsday.tests;

import com.mfranchino.doomsday.framework.entities.AbilityModifier;
import com.mfranchino.doomsday.framework.entities.AbilityScores;
import org.junit.Test;
import org.junit.Assert.*;
/**
 * Created by mfranchino on 1/11/14.
 */
public class TestAbilityScores {

  @Test
  public void testCreationOfAbility() {
    AbilityScores ab = new AbilityScores.Builder()
            .with(AbilityModifier.BASESCORE)
              .strength(10)
              .intelligence(10)
              .wisdom(18)
              .dexterity(10)
              .charisma(8)
              .constitution(15)
            .create();

    Assert.assertEquals(ab.getStrength(), 10);
    Assert.assertEquals(ab.getIntelligence(), 10);
    Assert.assertEquals(ab.getWisdom(), 18);
    Assert.assertEquals(ab.getDexterity(), 10);
    Assert.assertEquals(ab.getCharisma(), 8);
    Assert.assertEquals(ab.getConstitution(), 15);
  }

}
