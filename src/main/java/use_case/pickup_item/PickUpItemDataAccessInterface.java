package use_case.pickup_item;

import entity.Item;

/**
 * DAO Interface for Pick-Up Item Use Case.
 */
public interface PickUpItemDataAccessInterface {

    /**
     * Retrieves the item from the current room.
     *
     * @return the item, or null if no item is present
     */
    Item getItem();

    /**
     * Adds the given item to the player's inventory.
     *
     * @param item The item to add
     */
    void addToInventory(Item item);
}
