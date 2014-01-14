package com.mfranchino.doomsday.framework.entities.character;

/**
 * Created by mfranchino on 1/13/14.
 */
public enum Gender {

  MALE("Male"),
  FEMALE("Female");

  private final String description;

  private Gender(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
