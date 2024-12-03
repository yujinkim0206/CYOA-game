package use_case.pickup_item;

import entity.Item;
import interface_adapter.open_inventory.OpenInventoryViewModel;

import java.util.List;
import java.util.Map;

/**
 * Interactor for the Pick-Up Item Use Case.
 */
public class PickUpItemInteractor implements PickUpItemInputBoundary {
    private final PickUpItemDataAccessInterface dataAccessObject;
    private final PickUpItemOutputBoundary presenter;
    private final OpenInventoryViewModel openInventoryViewModel;

    public PickUpItemInteractor(PickUpItemDataAccessInterface dataAccessObject,
                                PickUpItemOutputBoundary presenter, OpenInventoryViewModel openInventoryViewModel) {
        this.dataAccessObject = dataAccessObject;
        this.presenter = presenter;
        this.openInventoryViewModel = openInventoryViewModel;
    }

    @Override
    public void execute(PickUpItemInputData inputData) {
        try {
            System.out.println("[DEBUG] Executing PickUpItemInteractor...");
            Item itemToPickUp = dataAccessObject.getItem();

            if (itemToPickUp == null) {
                System.out.println("[DEBUG] No item to pick up.");
                presenter.prepareFailView("No item to pick up in the room.");
                return;
            }

            System.out.println("[DEBUG] Item to pick up: " + itemToPickUp.getName());
            dataAccessObject.addToInventory(itemToPickUp);
            dataAccessObject.clearRoomItem();

            presenter.clearItemState();

            Map<String, List<String>> updatedInventory = dataAccessObject.getInventory();
            openInventoryViewModel.updateInventory(updatedInventory);


        } catch (IllegalStateException e) {
            System.out.println("[ERROR] Exception during item pick up: " + e.getMessage());
            presenter.prepareFailView(e.getMessage());
        }
    }

}
