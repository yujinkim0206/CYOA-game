package use_case.open_inventory;

import java.util.List;
import java.util.Map;

/**
 * DAO for the Open Inventory Use Case.
 */
public interface OpenInventoryDataAccessInterface {

    Map<String, List<String>> getInventory();
}
