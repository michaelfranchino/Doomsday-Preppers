
package com.mfranchino.doomsday.builder.Inventory;

import javax.annotation.Generated;
import com.mfranchino.engine.framework.entities.inventory.InventoryItem;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit https://github.com/UnquietCode/Flapi for more information.
 * 
 * 
 * Generated on January 07, 2014 22:34:13 PST using version 0.5-SNAPSHOT
 */
@Generated(value = "unquietcode.tools.flapi", date = "January 07, 2014 22:34:13 PST", comments = "generated using Flapi, the fluent API generator for Java")
public interface InventoryHelper {
    /**
     * Will always show in the player's inventory even if fully depleted.
     * With icon, it will show disabled
     */
    void alwaysShow(boolean show);

    /**
     * Sets the amount of inventory items given by this item. 
     * Mostly used for item types that give larger quantities.
     */
    void amount(int amount);

    InventoryItem create();

    void description(String desc);

    void icon(String iconPath);

    /**
     * Sets the maximum amount the player can carry of this item.
     */
    void maxAmount(int max);

    /**
     * Message to appear when item is picked up
     */
    void pickupMessage(String message);

    void pickupSound(String soundPath);

    void useSound(String soundPath);
}
