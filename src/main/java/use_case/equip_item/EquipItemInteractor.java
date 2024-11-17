package use_case.equip_item;

import use_case.equip_item.EquipItemOutputBoundary;
import use_case.equip_item.EquipItemOutputData;

/**
 * The Equip Item Interactor.
 */
public class EquipItemInteractor implements EquipItemInputBoundary {
    private final EquipItemDataAccessInterface dataAccess;
    private final EquipItemOutputBoundary presenter;

    public EquipItemInteractor(EquipItemDataAccessInterface dataAccess,
                               EquipItemOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(EquipItemInputData inputData) {
        String itemName = inputData.getItemName();
            dataAccess.equipItem(itemName);
            String[] updatedInventory = dataAccess.getInventoryItems();  // Fetch updated inventory
            EquipItemOutputData outputData = new EquipItemOutputData(updatedInventory);
            presenter.prepareSuccessView(outputData);
    }
}

