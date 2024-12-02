package use_case.pickup_item;

import entity.Item;

/**
 * The Pick-Up Item Interactor.
 */
public class PickUpItemInteractor implements PickUpItemInputBoundary {
    private final PickUpItemDataAccessInterface dataAccessObject;
    private final PickUpItemOutputBoundary presenter;

    public PickUpItemInteractor(PickUpItemDataAccessInterface dataAccessObject,
                                PickUpItemOutputBoundary presenter) {
        this.dataAccessObject = dataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(PickUpItemInputData inputData) {
        final Item itemToPickUp = dataAccessObject.getItem();
        if (itemToPickUp == null) {
            presenter.prepareFailView("No item to pick up in the room.");
        }
        else {
            dataAccessObject.addToInventory(itemToPickUp);
            presenter.prepareSuccessView(new PickUpItemOutputData(itemToPickUp.getName(),
                    "Picked up: " + itemToPickUp.getName()));
        }
    }

}
