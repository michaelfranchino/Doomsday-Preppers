package MichaelTestPackages;

import com.mfranchino.doomsday.inventory.InventoryItem;
import unquietcode.tools.flapi.Flapi;
import unquietcode.tools.flapi.Descriptor;
import org.junit.Test;

public class TestFlapi {
	
	@Test
	public void inventoryCreate() {
		Descriptor builder = Flapi.builder()
						.setDescriptorName("Inventory item")
						.setPackage("com.mfranchino.doomsday.inventory.builder.Inventory")
						.setStartingMethodName("createItem")
						.setReturnType(InventoryItem.class)
						
						.addMethod("description(String desc)").exactly(1)
						.addMethod("amount(int amount)")
						.withDocumentation("Sets the amount of inventory items given by this item. \nMostly used for item types that give larger quantities.")
						.atMost(1)
						.addMethod("maxAmount(int max)")
						.withDocumentation("Sets the maximum amount the player can carry of this item.")
						.atMost(1)
						.addMethod("icon(String iconPath").atMost(1)
						.addMethod("pickupMessage(String message)")
						.withDocumentation("Message to appear when item is picked up")
						.atMost(1)
						.addMethod("pickupSound(String soundPath)").atMost(1)
						.addMethod("useSound(String soundPath)").atMost(1)
						.addMethod("alwaysShow(boolean show)")
						.withDocumentation("Will always show in the player's inventory even if fully depleted.\nWith icon, it will show disabled")
						.atMost(1)
						
						.addMethod("create()").last(InventoryItem.class)
						.build();
		
		builder.writeToFolder("C:\\Users\\mfranchino\\workspace\\Doomsday Preppers\\src\\com\\mfranchino\\doomsday\\inventory");
		
	}

	@Test
	public void createBuilder() {
		Descriptor descriptor = Flapi.builder()
						.setDescriptorName("DateCreator")
						
						
						
						.build();
	}
}
