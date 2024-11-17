package use_case.pickup_item;

/**
 * The Input Data for the PickUp Item Use Case.
 */
public class PickUpItemInputData {
    private final String itemName;

    public PickUpItemInputData(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
