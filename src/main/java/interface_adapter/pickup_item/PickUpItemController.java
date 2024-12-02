package interface_adapter.pickup_item;

import use_case.pickup_item.PickUpItemInputBoundary;
import use_case.pickup_item.PickUpItemInputData;

/**
 * Controller for the Pick-Up Item Use Case.
 */
public class PickUpItemController {
    private final PickUpItemInputBoundary pickUpItemInteractor;

    public PickUpItemController(PickUpItemInputBoundary pickUpItemInteractor) {
        this.pickUpItemInteractor = pickUpItemInteractor;
    }

    /**
     * Calls interactor execute method.
     */
    public void pickUpItem() {
        pickUpItemInteractor.execute(new PickUpItemInputData());
    }
}
