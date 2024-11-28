package use_case.equip_item;

import entity.Item;

/**
 * Input Data for the Equip Item Use Case.
 */
public class EquipItemInputData {
    private final Item item;

    public EquipItemInputData(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
