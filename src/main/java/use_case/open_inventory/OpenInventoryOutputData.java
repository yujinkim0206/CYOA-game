package use_case.open_inventory;

import java.util.List;
import java.util.Map;

/**
 * Output Data for the Open Inventory Use Case.
 */
public class OpenInventoryOutputData {
    private final Map<String, List<String>> inventory;

    public OpenInventoryOutputData(Map<String, List<String>> inventory) {
        this.inventory = inventory;
    }

    /**
     * Returns the inventory data.
     * @return a map of inventory items and their details
     */
    public Map<String, List<String>> getInventory() {
        return inventory;
    }
}
