package use_case.open_inventory;

/**
 * Input Boundary for actions which are related to opening the inventory.
 */
public interface OpenInventoryInputBoundary {

    /**
     * Executes the Open Inventory use case.
     * @param OpenInventoryInputData the input data
     */
    void execute(OpenInventoryInputData OpenInventoryInputData);
}
