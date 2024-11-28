package use_case.equip_item;

import entity.Inventory;
import entity.Item;

/**
 * DAO Interface for Equip Item Use Case.
 */
public interface EquipItemDataAccessInterface {

    /**
     * Retrieves the player's inventory.
     *
     * @return the player's inventory
     */
    Inventory getInventory();

    /**
     * Updates the player's inventory.
     *
     * @param inventory The updated inventory
     */
    void updateInventory(Inventory inventory);

    /**
     * Equips an item for the player.
     *
     * @param item The item to equip
     * @return A message indicating the result of the equip operation
     */
    String equipItem(Item item);
}
