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

    /**
     * Update items state.
     * @param items items to update
     */
    public void updateItems(String[] items) {
        final PickUpItemState state = getState();
        state.setItems(items);
        setState(state);
    }

    /**
     * Set error in the state.
     * @param error error to set
     */
    public void setError(String error) {
        final PickUpItemState state = getState();
        state.setError(error);
        setState(state);
    }
}
