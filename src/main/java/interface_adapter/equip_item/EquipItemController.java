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

    public void equipItem(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            System.err.println("No item name provided to equip.");
            return;
        }

        EquipItemInputData inputData = new EquipItemInputData(itemName);
        interactor.execute(inputData);
    }
}
