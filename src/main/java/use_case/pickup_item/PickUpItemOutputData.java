package use_case.pickup_item;

/**
 * Output Data for the Pick-Up Item Use Case.
 */
public class PickUpItemOutputData {
    private final String itemName;
    private final String message;

    public PickUpItemOutputData(String itemName, String message) {
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
