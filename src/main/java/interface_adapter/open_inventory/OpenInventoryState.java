package interface_adapter.open_inventory;

import java.util.List;
import java.util.Map;

import entity.Item;

/**
 * The state for the Open Inventory View Model.
 */
public class OpenInventoryState {
    private Map<String, List<Item>> items;

    public void setItems(Map<String, List<Item>> items) {
        this.items = items;
    }

    public Map<String, List<Item>> getItems() {
        return items;
    }
}
