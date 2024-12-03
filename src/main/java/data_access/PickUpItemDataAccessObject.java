package data_access;

import entity.*;
import use_case.pickup_item.PickUpItemDataAccessInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * In-memory DAO for the Pick-Up Item Use Case.
 */
public class PickUpItemDataAccessObject implements PickUpItemDataAccessInterface {

    /**
     * Retrieves the item currently in the room.
     *
     * @return the item from the current room, or null if not an ItemRoom
     */
    @Override
    public Item getItem() {
        AbstractRoom currentRoom = Player.getInstance().getCurrentRoom();

        if (currentRoom == null) {
            throw new IllegalStateException("[ERROR] Current room is null.");
        }

        if (currentRoom instanceof ItemRoom) {
            Item item = ((ItemRoom) currentRoom).getItem();
            if (item == null) {
                System.out.println("[DEBUG] No item in ItemRoom.");
            }
            return item;
        }

        System.out.println("[DEBUG] Current room is not an ItemRoom.");
        return null;
    }



    /**
     * Adds the given item to the player's inventory.
     *
     * @param item The item to add
     */
    @Override
    public void addToInventory(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item to inventory.");
        }
        Player.getInstance().getInventory().addItem(item.getName(), item);
    }

    /**
     * Removes the item from the current room.
     */
    @Override
    public void clearRoomItem() {
        ((ItemRoom) Player.getInstance().getCurrentRoom()).setItem(null);
    }

    @Override
    public Map<String, List<String>> getInventory() {
        Inventory inventory = Player.getInstance().getInventory();
        Map<String, List<String>> itemDetails = new HashMap<>();

        inventory.getItems().forEach((name, items) -> {
            itemDetails.put(name, items.stream()
                    .map(item -> String.format("Name: %s, Rarity: %s, Category: %s",
                            item.getName(), item.getRarity(), item.getCategory()))
                    .collect(Collectors.toList()));
        });

        System.out.println("[DEBUG] Fetched inventory: " + itemDetails);
        return itemDetails;
    }

}
