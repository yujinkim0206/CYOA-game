package use_case.equip_item;

import use_case.equip_item.EquipItemDataAccessInterface;
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
        String itemName = inputData.getItemName();

        if (itemName == null || itemName.isEmpty()) {
            presenter.prepareFailView("No item name provided to equip.");
            return;
        }

        // Retrieve inventory from DAO
        Inventory inventory = dataAccess.getInventory();

        // Fetch the item by name
        Item itemToEquip = inventory.getItem(itemName);

        if (itemToEquip == null) {
            presenter.prepareFailView("Item not found in inventory.");
            return;
        }

        // Equip the item to the appropriate slot
        String slotToEquip = itemToEquip.getCategory();

        switch (slotToEquip) {
            case "Armor":
                inventory.setArmor(itemToEquip);  // Equip item to Armor slot
                break;
            case "Weapon":
                inventory.setWeapon(itemToEquip); // Equip item to Weapon slot
                break;
            case "Buff":
                inventory.setBuff(itemToEquip);   // Equip item to Buff slot
                break;
            default:
                presenter.prepareFailView("Invalid item type.");
                return;
        }

        // Update the inventory in the DAO
        dataAccess.updateInventory(inventory);

        // Send success response
        presenter.prepareSuccessView(new EquipItemOutputData(itemToEquip.getName(), "Successfully equipped " + itemToEquip.getName() + "."));

//        // Update the view model to reflect the new inventory state
//        String[] updatedInventory = new String[3];
//        updatedInventory[0] = inventory.getArmor() != null ? inventory.getArmor().getName() : "No Item";
//        updatedInventory[1] = inventory.getWeapon() != null ? inventory.getWeapon().getName() : "No Item";
//        updatedInventory[2] = inventory.getBuff() != null ? inventory.getBuff().getName() : "No Item";
//
//        // Assume you have a viewModel reference
//        viewModel.updateInventory(updatedInventory);
//    }
}
}

