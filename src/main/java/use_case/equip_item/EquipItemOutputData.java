package use_case.equip_item;

/**
 * Output Data for the Equip Item Use Case.
 */
public class EquipItemOutputData {
    private final String[] updatedInventory;

    public EquipItemOutputData(String[] updatedInventory) {
        this.updatedInventory = updatedInventory;
    }

    public String[] getUpdatedInventory() {
        return updatedInventory;
    }
}
