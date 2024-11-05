package interface_adapter.open_inventory;

import use_case.open_inventory.OpenInventoryInputBoundary;
import use_case.open_inventory.OpenInventoryInputData;

/**
 * The controller for the Open Inventory Use Case.
 */
public class OpenInventoryController {

    private OpenInventoryInputBoundary openInventoryUseCaseInteractor;

    public OpenInventoryController(OpenInventoryInputBoundary openInventoryUseCaseInteractor) {
        this.openInventoryUseCaseInteractor = openInventoryUseCaseInteractor;
    }

    /**
     * Executes the Open Inventory Use Case.
     */
    public void execute() {
        final OpenInventoryInputData openInventoryInputData = new OpenInventoryInputData();
        openInventoryUseCaseInteractor.execute(openInventoryInputData);
    }
}
