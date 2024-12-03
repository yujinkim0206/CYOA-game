package interface_adapter.open_inventory;

import interface_adapter.ViewModel;

import java.util.List;
import java.util.Map;

/**
 * The View Model for the Open Inventory View.
 */
public class OpenInventoryViewModel extends ViewModel<OpenInventoryState> {

    public OpenInventoryViewModel() {
        super("open inventory");
        setState(new OpenInventoryState());
    }

    public void updateInventory(Map<String, List<String>> items) {
        OpenInventoryState state = getState();
        state.setItems(items);
        setState(state);
        firePropertyChanged();
        System.out.println("[DEBUG] Inventory updated with items: " + items);
    }


    public void setError(String error) {
        OpenInventoryState state = getState();
        state.setItems(null); // Clear the current items
        setState(state);
        firePropertyChanged(); // Notify listeners about the state change
        System.out.println("[DEBUG] Error set in ViewModel: " + error);
    }
}
