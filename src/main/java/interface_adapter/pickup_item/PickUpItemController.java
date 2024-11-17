package interface_adapter.pickup_item;

import use_case.pickup_item.PickUpItemInputBoundary;
import use_case.pickup_item.PickUpItemInputData;

/**
 * The controller for the PickUp Item Use Case.
 */
public class PickUpItemController {

    private PickUpItemInputBoundary pickUpItemUseCaseInteractor;

    public PickUpItemController(PickUpItemInputBoundary pickUpItemUseCaseInteractor) {
        this.pickUpItemUseCaseInteractor = pickUpItemUseCaseInteractor;
    }

    /**
     * Executes the Pick Up Item Use Case.
     * @param itemName the name of the item to pick up
     */
    public void pickUpItem(String itemName) {
        final PickUpItemInputData pickUpItemInputData = new PickUpItemInputData(itemName);
        pickUpItemUseCaseInteractor.execute(pickUpItemInputData);
    }
}
