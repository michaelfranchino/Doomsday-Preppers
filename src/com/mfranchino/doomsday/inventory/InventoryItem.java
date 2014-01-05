/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mfranchino.doomsday.inventory;

/**
 *
 * @author mfranchino
 */
public abstract class InventoryItem {
	
	private int maxCarryAmount;
	private int maxStackAmount;
	
	private String iconPath;
	
	private String imageUsePath;
	private String imageDropPath;
	private String imageLootPath;
	
	private String pickupMessage;
	private String dropMessage;
	
	private String pickupSoundPath;
	private String useSoundPath;
	private String dropSoundpath;
	
	private boolean autoActivate;
	private boolean unDroppable;

	public int getMaxCarryAmount() {
		return maxCarryAmount;
	}

	public void setMaxCarryAmount(int maxCarryAmount) {
		this.maxCarryAmount = maxCarryAmount;
	}

	public int getMaxStackAmount() {
		return maxStackAmount;
	}

	public void setMaxStackAmount(int maxStackAmount) {
		this.maxStackAmount = maxStackAmount;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getImageUsePath() {
		return imageUsePath;
	}

	public void setImageUsePath(String imageUsePath) {
		this.imageUsePath = imageUsePath;
	}

	public String getImageDropPath() {
		return imageDropPath;
	}

	public void setImageDropPath(String imageDropPath) {
		this.imageDropPath = imageDropPath;
	}

	public String getImageLootPath() {
		return imageLootPath;
	}

	public void setImageLootPath(String imageLootPath) {
		this.imageLootPath = imageLootPath;
	}

	public String getPickupMessage() {
		return pickupMessage;
	}

	public void setPickupMessage(String pickupMessage) {
		this.pickupMessage = pickupMessage;
	}

	public String getDropMessage() {
		return dropMessage;
	}

	public void setDropMessage(String dropMessage) {
		this.dropMessage = dropMessage;
	}

	public String getPickupSoundPath() {
		return pickupSoundPath;
	}

	public void setPickupSoundPath(String pickupSoundPath) {
		this.pickupSoundPath = pickupSoundPath;
	}

	public String getUseSoundPath() {
		return useSoundPath;
	}

	public void setUseSoundPath(String useSoundPath) {
		this.useSoundPath = useSoundPath;
	}

	public String getDropSoundpath() {
		return dropSoundpath;
	}

	public void setDropSoundpath(String dropSoundpath) {
		this.dropSoundpath = dropSoundpath;
	}

	public boolean isAutoActivate() {
		return autoActivate;
	}

	public void setAutoActivate(boolean autoActivate) {
		this.autoActivate = autoActivate;
	}

	public boolean isUnDroppable() {
		return unDroppable;
	}

	public void setUnDroppable(boolean unDroppable) {
		this.unDroppable = unDroppable;
	}
}
