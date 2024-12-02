package interface_adapter.equip_item;

import use_case.equip_item.EquipItemInputBoundary;
import use_case.equip_item.EquipItemInputData;

/**
 * Controller for the Equip Item Use Case.
 */
public class EquipItemController {
    private final EquipItemInputBoundary interactor;

    public EquipItemController(EquipItemInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Equip the item by name.
     * @param itemName the item's name
     */
    public void equipItem(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            System.err.println("No item name provided to equip.");
        }
        else {
            final EquipItemInputData inputData = new EquipItemInputData(itemName);
            interactor.execute(inputData);
        }
    }
}
