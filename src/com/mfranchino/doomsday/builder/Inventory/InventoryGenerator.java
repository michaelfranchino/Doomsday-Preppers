
package com.mfranchino.doomsday.builder.Inventory;

import javax.annotation.Generated;
import com.mfranchino.doomsday.builder.Inventory.InventoryBuilder.Start;
import unquietcode.tools.flapi.runtime.BlockInvocationHandler;
import unquietcode.tools.flapi.runtime.ExecutionListener;


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
public class InventoryGenerator {
    public static Start build(InventoryHelper helper, ExecutionListener... listeners) {
        if (helper == null) {
            throw new IllegalArgumentException("Helper cannot be null.");
        }
         
        BlockInvocationHandler handler = new BlockInvocationHandler(helper, null);
        handler.addListeners(listeners);
        return handler._proxy(Start.class);
    }
}
