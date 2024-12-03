package interface_adapter.open_inventory;

import java.util.List;
import java.util.Map;

import entity.Item;

/**
 * State for the Open Inventory View Model.
 */
public class OpenInventoryState {
    private Map<String, List<String>> items;
    private String error;
    private String selectedItem;  // Store selected item name

    // Getters and Setters for items and error

    public void setItems(Map<String, List<String>> items) {
        this.items = items;
    }

    public Map<String, List<String>> getItems() {
        return items;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    // Getter and Setter for selectedItem
    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    // Logic to select an item and trigger the equip action
    public void selectItem(String itemName) {
        // Set the selected item
        this.selectedItem = itemName;

        // Log selection for debugging purposes
        System.out.println("[DEBUG] Item selected: " + itemName);

        // Here, you could add business logic related to equipping the item
        equipItem(itemName);
    }

    // Logic to "equip" the item (just a placeholder for now)
    private void equipItem(String itemName) {
        // This is where the business logic for equipping an item would go.
        // You could interact with the domain layer, update user stats, etc.

        System.out.println("[DEBUG] Equipping item: " + itemName);

        // For example, updating the item state, user stats, etc.
        // this could update the inventory or change the selected character's stats
    }
}
