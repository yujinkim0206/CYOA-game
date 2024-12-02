package use_case.equip_item;

import entity.Inventory;
import entity.Item;

/**
 * DAO Interface for Equip Item Use Case.
 */
public interface EquipItemDataAccessInterface {
    /**
     * Return the inventory.
     * @return the inventory
     */
    Inventory getInventory();

    /**
     * Update the inventory with the given inventory.
     * @param inventory the given inventory
     */
    void updateInventory(Inventory inventory);

    /**
     * Check if a given item exists in the inventory.
     * @param item the given item
     * @return whether the item exists or not
     */
    boolean itemExists(Item item);
}
