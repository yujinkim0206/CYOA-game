package interface_adapter.equip_item;

import entity.Inventory;
import entity.Item;
import entity.Player;
import use_case.equip_item.EquipItemInputBoundary;
import use_case.equip_item.EquipItemInputData;

/**
 * Controller for the Equip Item Use Case.
 */
public class EquipItemController {
    private final EquipItemInputBoundary equipItemInteractor;

    public EquipItemController(EquipItemInputBoundary equipItemInteractor) {
        this.equipItemInteractor = equipItemInteractor;
    }

    public void equipItem(String itemName) {
        Inventory inventory = Player.getInstance().getInventory(); // Fetch inventory
        Item item = inventory.getItem(itemName); // Retrieve item by name

        if (item == null) {
            System.err.println("Error: Item not found in inventory.");
            return;
        }

        EquipItemInputData inputData = new EquipItemInputData(item);
        equipItemInteractor.execute(inputData);
    }
}
