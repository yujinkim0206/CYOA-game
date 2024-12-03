package interface_adapter.pickup_item;

import use_case.pickup_item.PickUpItemDataAccessInterface;
import use_case.pickup_item.PickUpItemInputBoundary;
import use_case.pickup_item.PickUpItemInputData;

/**
 * Controller for the Pick-Up Item Use Case.
 */
public class PickUpItemController {
    private final PickUpItemInputBoundary interactor;

    public PickUpItemController(PickUpItemInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Calls interactor execute method.
     */
    public void pickUpItem() {
        interactor.execute(new PickUpItemInputData());
    }
}
