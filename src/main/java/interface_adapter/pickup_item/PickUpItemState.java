package interface_adapter.pickup_item;

/**
 * State for the Pick-Up Item ViewModel.
 */
public class PickUpItemState {
    private String items;
    private String message;
    private String error;

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
