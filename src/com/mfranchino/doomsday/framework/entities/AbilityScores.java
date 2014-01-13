package com.mfranchino.doomsday.framework.entities;

/**
 * Created by mfranchino on 1/11/14.
 */
public final class AbilityScores {

	private int[] strength = new int[AbilityModifier.values().length];
	private int[] dexterity = new int[AbilityModifier.values().length];
	private int[] constitution = new int[AbilityModifier.values().length];
	private int[] intelligence = new int[AbilityModifier.values().length];
	private int[] wisdom = new int[AbilityModifier.values().length];
	private int[] charisma = new int[AbilityModifier.values().length];

	public AbilityBuilder udpate() {
		return AbilityBuilder.update(this);
	}
	
	public int getStrength() {
		return sum(strength);
	}

	public void setStrength(int index, int strength) {
		this.strength[index] = strength;
	}

	public int getDexterity() {
		return sum(dexterity);
	}

	public void setDexterity(int index, int dexterity) {
		this.dexterity[index] = dexterity;
	}

	public int getConstitution() {
		return sum(constitution);
	}

	public void setConstitution(int index, int constitution) {
		this.constitution[index] = constitution;
	}

	public int getIntelligence() {
		return sum(intelligence);
	}

	public void setIntelligence(int index, int intelligence) {
		this.intelligence[index] = intelligence;
	}

	public int getWisdom() {
		return sum(wisdom);
	}

	public void setWisdom(int index, int wisdom) {
		this.wisdom[index] = wisdom;
	}

	public int getCharisma() {
		return sum(charisma);
	}

	public void setCharisma(int index, int charisma) {
		this.charisma[index] = charisma;
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
