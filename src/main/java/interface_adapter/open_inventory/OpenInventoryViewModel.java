package interface_adapter.open_inventory;

import interface_adapter.ViewModel;
import interface_adapter.open_inventory.OpenInventoryState;

/**
 * The View Model for the Open Inventory View.
 */
public class OpenInventoryViewModel extends ViewModel<OpenInventoryState> {

    public OpenInventoryViewModel() {
        super("open inventory");
        setState(new OpenInventoryState());
    }

}
