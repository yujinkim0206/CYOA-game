package data_access;

import entity.Inventory;
import entity.Player;
import use_case.open_inventory.OpenInventoryDataAccessInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors; // Add this import
/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InventoryDataAccessObject implements OpenInventoryDataAccessInterface {
    // For now this is empty and only extends OpenInventoryDataAccessInterface
    // when more code is filled in, this should be filled in accordingly.

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
