package interface_adapter.pickup_item;

import interface_adapter.ViewModel;

/**
 * The View Model for the PickUp Item View.
 */
public class PickUpItemViewModel extends ViewModel<PickUpItemState> {

    public PickUpItemViewModel() {
        super("pick up item");
        setState(new PickUpItemState());
    }

    public void updateItems(String[] items) {
        PickUpItemState currentState = getState();
        currentState.setItems(items);
        setState(currentState);
    }
}
