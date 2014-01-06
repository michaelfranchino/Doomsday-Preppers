
package com.mfranchino.doomsday.inventory;

public abstract class InventoryItem {
	private boolean autoActivate;
	private String  dropMessage;
	private String  dropSoundpath;
	private String  iconPath;
	private String  imageDropPath;
	private String  imageLootPath;
	private String  imageUsePath;
	private int     maxCarryAmount;
	private int     maxStackAmount;
	private String  pickupMessage;
	private String  pickupSoundPath;
	private boolean unDroppable;
	private String  useSoundPath;

	//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
	public String getDropMessage() {
		return dropMessage;
	}
	
	public String getDropSoundpath() {
		return dropSoundpath;
	}
	
	public String getIconPath() {
		return iconPath;
	}
	
	public String getImageDropPath() {
		return imageDropPath;
	}
	
	public String getImageLootPath() {
		return imageLootPath;
	}
	
	public String getImageUsePath() {
		return imageUsePath;
	}
	
	public int getMaxCarryAmount() {
		return maxCarryAmount;
	}
	
	public int getMaxStackAmount() {
		return maxStackAmount;
	}
	
	public String getPickupMessage() {
		return pickupMessage;
	}
	
	public String getPickupSoundPath() {
		return pickupSoundPath;
	}
	
	public String getUseSoundPath() {
		return useSoundPath;
	}
	
	public void setAutoActivate(boolean autoActivate) {
		this.autoActivate = autoActivate;
	}
	
	public void setDropMessage(String dropMessage) {
		this.dropMessage = dropMessage;
	}
	
	public void setDropSoundpath(String dropSoundpath) {
		this.dropSoundpath = dropSoundpath;
	}
	
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	public void setImageDropPath(String imageDropPath) {
		this.imageDropPath = imageDropPath;
	}
	
	public void setImageLootPath(String imageLootPath) {
		this.imageLootPath = imageLootPath;
	}
	
	public void setImageUsePath(String imageUsePath) {
		this.imageUsePath = imageUsePath;
	}
	
	public void setMaxCarryAmount(int maxCarryAmount) {
		this.maxCarryAmount = maxCarryAmount;
	}
	
	public void setMaxStackAmount(int maxStackAmount) {
		this.maxStackAmount = maxStackAmount;
	}
	
	public void setPickupMessage(String pickupMessage) {
		this.pickupMessage = pickupMessage;
	}
	
	public void setPickupSoundPath(String pickupSoundPath) {
		this.pickupSoundPath = pickupSoundPath;
	}
	
	public void setUnDroppable(boolean unDroppable) {
		this.unDroppable = unDroppable;
	}
	
	public void setUseSoundPath(String useSoundPath) {
		this.useSoundPath = useSoundPath;
	}
//</editor-fold>

	public boolean isAutoActivate() {
		return autoActivate;
	}

	public boolean isUnDroppable() {
		return unDroppable;
	}
}
