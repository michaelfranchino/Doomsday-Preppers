
package com.mfranchino.doomsday.framework.entities.inventory;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

/**
 *
 * @author mfranchino
 */
public abstract class InventoryItem {
  /**
   * Does the inventory item automatically do action on pickup
   */
	private boolean autoActivate;
	/**
	 * Message to display when the inventory item is dropped
	 */
	private String  dropMessage;
	/**
	 * Path to the Audio to play when the inventory item is dropped
	 */
	private String dropSoundPath;
	/**
	 * Audio to play when an inventory item is dropped
	 */
	private Audio dropSound;
	/**
	 * Path to icon to display in inventory
	 */
	private String  iconPath;
	/**
	 * Icon image
	 */
	private Image   iconImage;
	/**
	 * Path to image to display for inventory item not in inventory
	 */
	private String  dropImagePath;
	/**
	 * Image to display for the inventory item not in inventory
	 */
	private Image   dropImage;
	/**
	 * Image to display for the inventory item that is being looted
	 */
	private String  lootImagePath;
	private Image		lootImage;
	/**
	 * Path to the image when the inventory item is used
	 */
	private String  useImagePath;
	/**
	 * Use image
	 */
	private Image   useImage;
	/**
	 * Maximum number of this inventory item that can be carried
	 */
	private int     maxCarryAmount;
	/**
	 * Number of items that can be stacked in inventory. Example:  if this is a raw material, you can specify how many can be stored in one slot.
	 */
	private int     maxStackAmount;
	/**
	 * Message to display when the inventory item is picked up
	 */
	private String  pickupMessage;
	/**
	 * Audio to play when the inventory item is picked up
	 */
	private Audio   pickupSound;
	/**
	 * Path to the Audio to play when the inventory item is picked up
	 */
	private String  pickupSoundPath;
	/**
	 * Special items that cannot be dropped
	 */
	private boolean unDroppable;
	/**
	 * Path to the Audio to play when the inventory item is used
	 */
	private String  useSoundPath;
	/**
	 * Audio to play when an inventory item is being used
	 */
	private Audio   useSound;

	//<editor-fold defaultstate="collapsed" desc="Getters/Setters">

	/**
	 *
	 * @return String Returns the message to display when the inventory item is dropped
	 */
		public final String getDropMessage() {
		return dropMessage;
	}
	
	/**
	 *
	 * @return Audio Returns the the Audio to play when the inventory item is dropped
	 */
	public final Audio getDropSound() {
		return dropSound;
	}
	
	/**
	 *
	 * @return String Returns the image for the inventory item icon
	 */
	public final Image getIconImage() {
		return iconImage;
	}
	
	/**
	 *
	 * @return Image Returns the dropped image for the inventory item
	 */
	public final Image getDropImage() {
		return dropImage;
	}
	
	/**
	 *
	 * @return Image Returns the loot image for the inventory item
	 */
	public final Image getLootImage() {
		return lootImage;
	}
	
	/**
	 *
	 * @return Image Returns the image when an inventory item is being used
	 */
	public final Image getUseImage() {
		return useImage;
	}
	
	/**
	 *
	 * @return
	 */
	public final int getMaxCarryAmount() {
		return maxCarryAmount;
	}
	
	/**
	 *
	 * @return
	 */
	public final int getMaxStackAmount() {
		return maxStackAmount;
	}
	
	/**
	 *
	 * @return
	 */
	public final String getPickupMessage() {
		return pickupMessage;
	}
	
	/**
	 *
	 * @return Audio Returns the Audio when an inventory item is being used
	 */
	public final Audio getUseSound() {
		return useSound;
	}
	
	/**
	 *
	 * @param autoActivate
	 */
	public final void setAutoActivate(boolean autoActivate) {
		this.autoActivate = autoActivate;
	}
	
	/**
	 *
	 * @param dropMessage
	 */
	public void setDropMessage(String dropMessage) {
		this.dropMessage = dropMessage;
	}
	
	/**
	 *
	 * @param dropSoundPath
	 */
	public void setDropSoundPath(String dropSoundPath) throws IOException {
		this.dropSoundPath = dropSoundPath;
    dropSound = loadAudioResource(dropSoundPath);

  }

  /**
   *
   * @param audioPath
   * @return
   * @throws IOException
   */
  private Audio loadAudioResource(String audioPath) throws IOException {
    try {
      return AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(audioPath));
    } catch (IOException e) {
        throw new IOException("Resource at path " + audioPath + " not found");
    }
  }

  /**
	 *
	 * @param iconPath
	 */
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
    try {
      iconImage = new Image(iconPath);
    } catch (SlickException e) {
        e.printStackTrace();
    }
  }
	
	/**
	 *
	 * @param dropImagePath
	 */
	public void setDropImagePath(String dropImagePath) {
		this.dropImagePath = dropImagePath;
    try {
      dropImage = new Image(dropImagePath);
    } catch (SlickException e) {
        e.printStackTrace();
    }
  }
	
	/**
	 *
	 * @param lootImagePath
	 */
	public void setLootImagePath(String lootImagePath) {
		this.lootImagePath = lootImagePath;
    try {
      lootImage = new Image(lootImagePath);
    } catch (SlickException e) {
        e.printStackTrace();
    }
  }
	
	/**
	 *
	 * @param useImagePath
	 */
	public void setUseImagePath(String useImagePath) {
		this.useImagePath = useImagePath;
    try {
      useImage = new Image(useImagePath);
    } catch (SlickException e) {
        e.printStackTrace();
    }
  }
	
	/**
	 *
	 * @param maxCarryAmount
	 */
	public final void setMaxCarryAmount(int maxCarryAmount) {
    if (maxCarryAmount < 0)
      throw new IllegalArgumentException("Max carry amount cannot be negative");
		this.maxCarryAmount = maxCarryAmount;
	}
	
	/**
	 *
	 * @param maxStackAmount
	 */
	public final void setMaxStackAmount(int maxStackAmount) {
    if (maxStackAmount < 0)
      throw new IllegalArgumentException("Max stack amount cannot be negative");
		this.maxStackAmount = maxStackAmount;
	}
	
	/**
	 *
	 * @param pickupMessage
	 */
	public final void setPickupMessage(String pickupMessage) {
		this.pickupMessage = pickupMessage;
	}
	
	/**
	 *
	 * @param pickupSoundPath
	 */
	public void setPickupSoundPath(String pickupSoundPath) throws IOException {
		this.pickupSoundPath = pickupSoundPath;
    pickupSound = loadAudioResource(pickupSoundPath);
	}
	
	/**
	 *
	 * @param unDroppable
	 */
	public final void setUnDroppable(boolean unDroppable) {
		this.unDroppable = unDroppable;
	}
	
	/**
	 *
	 * @param useSoundPath
	 */
	public final void setUseSoundPath(String useSoundPath) throws IOException {
		this.useSoundPath = useSoundPath;
    useSound = loadAudioResource(useSoundPath);
	}
//</editor-fold>

	/**
	 *
	 * @return boolean return true if the inventory item doesn't activate on pickup
	 */
	public final boolean isAutoActivate() {
		return autoActivate;
	}

	/**
	 *
	 * @return boolean Returns true if the inventory item is not drop-able
	 */
	public final boolean isUnDroppable() {
		return unDroppable;
	}
}
