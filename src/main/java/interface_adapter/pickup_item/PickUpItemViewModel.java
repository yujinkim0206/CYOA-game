package interface_adapter.pickup_item;

import interface_adapter.ViewModel;

/**
 * ViewModel for the Pick-Up Item Use Case.
 */
public class PickUpItemViewModel extends ViewModel<PickUpItemState> {
    public PickUpItemViewModel() {
        super("pick up item");
        setState(new PickUpItemState());
    }

    public void updateItems(String items) {
        PickUpItemState state = getState();
        state.setItems(items);
        setState(state);
        firePropertyChanged();
        System.out.println("[DEBUG] ViewModel updated with item: " + items);
    }


    public void setMessage(String message) {
        PickUpItemState state = getState();
        state.setMessage(message);
        setState(state);
    }

    public void setError(String error) {
        PickUpItemState state = getState();
        state.setError(error);
        setState(state);
    }
    public void clearItem() {
        PickUpItemState state = getState();
        state.setItems(null);
        state.setMessage("No item available in this room.");
        setState(state); // Update state
        firePropertyChanged(); // Notify listeners
        System.out.println("[DEBUG] Item cleared from state.");
    }
}
