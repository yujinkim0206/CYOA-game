package use_case.equip_item;

import entity.Inventory;
import entity.Item;

/**
 * Interactor for the Equip Item Use Case.
 */
public class EquipItemInteractor implements EquipItemInputBoundary {
    private final EquipItemDataAccessInterface dataAccess;
    private final EquipItemOutputBoundary presenter;

    public EquipItemInteractor(EquipItemDataAccessInterface dataAccess, EquipItemOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(EquipItemInputData inputData) {
        final String itemName = inputData.getItemName();

        if (itemName == null || itemName.isEmpty()) {
            presenter.prepareFailView("No item name provided.");
        }
        else {
            // Retrieve inventory from DAO
            final Inventory inventory = dataAccess.getInventory();

            // Fetch the item by name
            final Item itemToEquip = inventory.getItem(itemName);

            if (itemToEquip == null) {
                presenter.prepareFailView("Item not found in inventory.");
            }
            else {
                // Equip the item and update inventory
                final boolean isEquipped = inventory.equipItem(itemToEquip);

                if (!isEquipped) {
                    presenter.prepareFailView("Failed to equip the item.");
                }
                else {
                    // Send success response
                    presenter.prepareSuccessView(new EquipItemOutputData(
                            itemToEquip.getName(),
                            "Equipped " + itemToEquip.getName() + " successfully."
                    ));

                    // Update the inventory in the DAO
                    dataAccess.updateInventory(inventory);
                }
            }
        }
    }
}
