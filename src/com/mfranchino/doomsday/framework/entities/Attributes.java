package com.mfranchino.doomsday.framework.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Attributes {
  private String name;
  private int health;
  private int maxSpeed;
  private int maxJumpHeight;
  private Animation image;



  public final int getHealth() {
    return health;
  }
  public final void setHealth(int health) {
    this.health = health;
  }
  public final int getMaxSpeed() {
    return maxSpeed;
  }
  public final void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }
  public final int getMaxJumpHeight() {
    return maxJumpHeight;
  }
  public final void setMaxJumpHeight(int maxJumpHeight) {
    this.maxJumpHeight = maxJumpHeight;
  }
  public final String getName() {
    return name;
  }
  public final void setName(String name) {
    this.name = name;
  }
  public final Animation getImage() {
   return image;
 }
  public final void setImage(Animation image) {
    this.image = image;
  }
}
