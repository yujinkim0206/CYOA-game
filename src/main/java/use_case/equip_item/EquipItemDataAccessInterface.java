package data_access;

import entity.Inventory;
import entity.Item;

/**
 * DAO Interface for Equip Item Use Case.
 */
public interface EquipItemDataAccessInterface {
    Inventory getInventory();
    void updateInventory(Inventory inventory);
    boolean itemExists(Item item);
}
