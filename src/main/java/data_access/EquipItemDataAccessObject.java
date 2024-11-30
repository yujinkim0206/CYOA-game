package data_access;

import entity.Inventory;
import entity.Item;
import entity.Player;

/**
 * DAO for managing equip item use cases.
 */
public class EquipItemDataAccessObject implements data_access.EquipItemDataAccessInterface {

    @Override
    public Inventory getInventory() {
        // Access the Player singleton's inventory
        return Player.getInstance().getInventory();
    }

    @Override
    public void updateInventory(Inventory inventory) {
        // Update the inventory in the Player singleton
        Player.getInstance().setInventory(inventory);
    }

    @Override
    public boolean itemExists(Item item) {
        // Check if the item exists in the player's inventory
        return getInventory().getItem(item.getName()) != null;
    }
}
