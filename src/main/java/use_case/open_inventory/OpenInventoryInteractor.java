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
    public void execute(LogoutInputData logoutInputData) {
        // TODO: implement the logic of the Open Inventory use case
    }
}

