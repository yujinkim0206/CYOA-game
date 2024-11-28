package data_access;

import entity.Item;
import entity.Player;
import use_case.pickup_item.PickUpItemDataAccessInterface;

/**
 * In-memory implementation of the DAO for Pick Up Item Use Case.
 */
public class PickUpItemDataAccessObject implements PickUpItemDataAccessInterface {

    @Override
    public Item getItem() {
        // Assume the current room is already an ItemRoom
        return Player.getInstance().getCurrentRoom().getItem();
    }

    @Override
    public void addToInventory(Item item) {
        Player player = Player.getInstance(); // Assuming a singleton pattern for Player
        player.getInventory().addItem(item.getName(), item);
    }
}
