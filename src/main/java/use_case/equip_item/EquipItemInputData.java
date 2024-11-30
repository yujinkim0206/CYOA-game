package use_case.equip_item;

/**
 * Input Data for the Equip Item Use Case.
 */
public class EquipItemInputData {
    private final String itemName;

    public EquipItemInputData(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
