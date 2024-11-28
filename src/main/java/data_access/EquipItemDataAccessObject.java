package data_access;

import entity.Inventory;
import entity.Item;
import entity.Player;
import use_case.equip_item.EquipItemDataAccessInterface;

/**
 * In-memory implementation of the DAO for Equip Item Use Case.
 */
public class EquipItemDataAccessObject implements EquipItemDataAccessInterface {

    @Override
    public Inventory getInventory() {
        return Player.getInstance().getInventory(); // Assumes Player is a singleton
    }

    @Override
    public void updateInventory(Inventory inventory) {
        Player.getInstance().setInventory(inventory); // Updates the player's inventory
    }

    public String equipItem(Item item) {
        Player player = Player.getInstance();
        return player.equipItem(item); // Delegates the equip logic to the Player entity
    }
}
