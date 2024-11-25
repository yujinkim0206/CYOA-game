package use_case.pickup_item;

import use_case.pickup_item.PickUpItemOutputBoundary;
import use_case.pickup_item.PickUpItemOutputData;

/**
 * The PickUp Item Interactor.
 */
public class PickUpItemInteractor implements PickUpItemInputBoundary {
    private final PickUpItemDataAccessInterface dataAccess;
    private final PickUpItemOutputBoundary presenter;

    public PickUpItemInteractor(PickUpItemDataAccessInterface dataAccess,
                                PickUpItemOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(PickUpItemInputData inputData) {
        String itemName = inputData.getItemName();

            dataAccess.addItemToInventory(itemName);
            String[] updatedItems = dataAccess.getAvailableItems();  // Fetch updated items in room
            PickUpItemOutputData outputData = new PickUpItemOutputData(updatedItems);
            presenter.prepareSuccessView(outputData);
    }
}
