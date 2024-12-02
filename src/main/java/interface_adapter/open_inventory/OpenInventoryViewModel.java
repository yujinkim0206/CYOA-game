package interface_adapter.open_inventory;

import interface_adapter.ViewModel;

/**
 * The View Model for the Open Inventory View.
 */
public class OpenInventoryViewModel extends ViewModel<OpenInventoryState> {

    public OpenInventoryViewModel() {
        super("open inventory");
        setState(new OpenInventoryState());
    }

}
