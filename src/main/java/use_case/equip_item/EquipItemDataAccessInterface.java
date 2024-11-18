package use_case.equip_item;

/**
 * DAO for the Equip Item Use Case.
 */
public interface EquipItemDataAccessInterface {
    String[] getInventoryItems();  // Fetches the player's inventory
    void equipItem(String itemName);  // Marks the item as equipped
}
