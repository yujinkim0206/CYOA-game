package use_case.open_inventory;

import java.util.List;
import java.util.Map;

/**
 * The Open Inventory Interactor.
 */
public class OpenInventoryInteractor implements OpenInventoryInputBoundary {
    private OpenInventoryDataAccessInterface userDataAccessObject;
    private OpenInventoryOutputBoundary openInventoryPresenter;

    public OpenInventoryInteractor(OpenInventoryDataAccessInterface userDataAccessInterface,
                                   OpenInventoryOutputBoundary openInventoryOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.openInventoryPresenter = openInventoryOutputBoundary;
    }

    public void execute() {
        try {
            // Fetch inventory data from the repository
            Map<String, List<String>> inventory = userDataAccessObject.getInventory();

            // Create the output data
            OpenInventoryOutputData outputData = new OpenInventoryOutputData(inventory);

            // Pass the output data to the presenter
            openInventoryPresenter.prepareSuccessView(outputData);
        } catch (Exception e) {
            openInventoryPresenter.prepareFailView("Failed to load inventory: " + e.getMessage());
        }
    }

}

