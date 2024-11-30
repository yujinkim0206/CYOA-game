package use_case.equip_item;

/**
 * Output Data for the Equip Item Use Case.
 */
public class EquipItemOutputData {
    private final String itemName;
    private final String message;

    public EquipItemOutputData(String itemName, String message) {
        this.itemName = itemName;
        this.message = message;
    }

    public String getItemName() {
        return itemName;
    }

    public String getMessage() {
        return message;
    }
}
