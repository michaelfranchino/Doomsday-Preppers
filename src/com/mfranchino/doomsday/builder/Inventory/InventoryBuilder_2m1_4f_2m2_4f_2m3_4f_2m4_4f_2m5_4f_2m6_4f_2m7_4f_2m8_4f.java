
package com.mfranchino.doomsday.builder.Inventory;

import javax.annotation.Generated;
import com.mfranchino.engine.framework.entities.inventory.InventoryItem;
import unquietcode.tools.flapi.runtime.MethodInfo;
import unquietcode.tools.flapi.runtime.TransitionType;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit https://github.com/UnquietCode/Flapi for more information.
 * 
 * 
 * Generated on January 07, 2014 22:34:13 PST using version 0.5-SNAPSHOT
 * @param <_ReturnType>
 */
@Generated(value = "unquietcode.tools.flapi", date = "January 07, 2014 22:34:13 PST", comments = "generated using Flapi, the fluent API generator for Java")
public interface InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> {
    /**
     * Will always show in the player's inventory even if fully depleted.
     * With icon, it will show disabled
	 * @param show
	 * @return 
     */
    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> alwaysShow(boolean show);

    /**
     * Sets the amount of inventory items given by this item. 
     * Mostly used for item types that give larger quantities.
     */
    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> amount(int amount);

    @MethodInfo(type = TransitionType.Terminal)
    InventoryItem create();

    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> description(String desc);

    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> icon(String iconPath);

    /**
     * Sets the maximum amount the player can carry of this item.
     */
    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> maxAmount(int max);

    /**
     * Message to appear when item is picked up
     */
    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> pickupMessage(String message);

    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> pickupSound(String soundPath);

    @MethodInfo(type = TransitionType.Recursive)
    InventoryBuilder_2m1_4f_2m2_4f_2m3_4f_2m4_4f_2m5_4f_2m6_4f_2m7_4f_2m8_4f<_ReturnType> useSound(String soundPath);
}
