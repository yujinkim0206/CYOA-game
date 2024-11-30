package interface_adapter.pickup_item;

/**
 * The state for the Pick-Up Item View Model.
 * Holds data related to the current state of the Pick-Up Item View.
 */
public class PickUpItemState {
    private String[] items;
    private String error;

    /**
     * Gets the list of items.
     *
     * @return the list of items
     */
    public String[] getItems() {
        return items;
    }

    /**
     * Sets the list of items.
     *
     * @param items the list of items to set
     */
    public void setItems(String[] items) {
        this.items = items;
    }

    /**
     * Gets the current error message.
     *
     * @return the error message
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message.
     *
     * @param error the error message to set
     */
    public void setError(String error) {
        this.error = error;
    }
}
