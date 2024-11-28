package interface_adapter.pickup_item;

import entity.Player;
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

    public void pickUpItem() {
        Player player = Player.getInstance(); // Assuming Player is a singleton
        PickUpItemInputData inputData = new PickUpItemInputData(player);
        pickUpItemInteractor.execute(inputData);
    }
}
