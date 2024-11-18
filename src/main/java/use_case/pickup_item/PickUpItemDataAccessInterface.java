package use_case.pickup_item;

/**
 * DAO for the PickUp Item Use Case.
 */
public interface PickUpItemDataAccessInterface {
    String[] getAvailableItems();  // Fetches available items in the room
    void addItemToInventory(String itemName);  // Adds the picked item to the player's inventory
}
