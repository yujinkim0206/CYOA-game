package use_case.pickup_item;


/**
 * Output Data for the PickUp Item Use Case.
 */
public class PickUpItemOutputData {
    private final String[] updatedItems;

    public PickUpItemOutputData(String[] updatedItems) {
        this.updatedItems = updatedItems;
    }

    public String[] getUpdatedItems() {
        return updatedItems;
    }
}