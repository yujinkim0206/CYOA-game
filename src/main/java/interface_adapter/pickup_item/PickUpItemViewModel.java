package interface_adapter.pickup_item;

import interface_adapter.ViewModel;

/**
 * ViewModel for the Pick-Up Item View.
 */
public class PickUpItemViewModel extends ViewModel<PickUpItemState> {
    public PickUpItemViewModel() {
        super("pick up item");
        setState(new PickUpItemState());
    }

    public void updateItems(String[] items) {
        PickUpItemState state = getState();
        state.setItems(items);
        setState(state);
    }

    public void setError(String error) {
        PickUpItemState state = getState();
        state.setError(error);
        setState(state);
    }
}
