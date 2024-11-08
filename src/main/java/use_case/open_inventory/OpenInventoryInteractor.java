package use_case.open_inventory;

/**
 * The Open Inventory Interactor.
 */
public class OpenInventoryInteractor implements OpenInventoryInputBoundary {
    private OpenInventoryUserDataAccessInterface userDataAccessObject;
    private OpenInventoryOutputBoundary openInventoryPresenter;

    public OpenInventoryInteractor(OpenInventoryUserDataAccessInterface userDataAccessInterface,
                            OpenInventoryOutputBoundary openInventoryOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.openInventoryPresenter = openInventoryOutputBoundary;
    }

    @Override
    public void execute(OpenInventoryInputData openInventoryInputData) {
        // Data Access Object (if needed later)
        //final Inventory inventory = userDataAccessObject.get(openInventoryInputData.get___());

        // For now, this code will always prepare success when requesting the inventory.
        // Probably in the future this will be modified to only accept the command when on the correct view, but since
        // that view does not exist at the moment of writing this, for now it will always work.
        final OpenInventoryOutputData openInventoryOutputData = new OpenInventoryOutputData(false);
        openInventoryPresenter.prepareSuccessView(openInventoryOutputData);
    }
}

