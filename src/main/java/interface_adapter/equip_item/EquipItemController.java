package interface_adapter.equip_item;

import use_case.equip_item.EquipItemInputBoundary;
import use_case.equip_item.EquipItemInputData;

/**
 * The controller for the Equip Item Use Case.
 */
public class EquipItemController {

    private EquipItemInputBoundary equipItemUseCaseInteractor;

    public EquipItemController(EquipItemInputBoundary equipItemUseCaseInteractor) {
        this.equipItemUseCaseInteractor = equipItemUseCaseInteractor;
    }

    /**
     * Executes the Equip Item Use Case.
     * @param itemName the name of the item to equip
     */
    public void equipItem(String itemName) {
        final EquipItemInputData equipItemInputData = new EquipItemInputData(itemName);
        equipItemUseCaseInteractor.execute(equipItemInputData);
    }
}
