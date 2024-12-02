package use_case.open_inventory;

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

    @Override
    public void execute(OpenInventoryInputData openInventoryInputData) {
        // For now, this code will always prepare success when requesting the inventory.
        final OpenInventoryOutputData openInventoryOutputData = new OpenInventoryOutputData(false);
        openInventoryPresenter.prepareSuccessView(openInventoryOutputData);
    }
}

