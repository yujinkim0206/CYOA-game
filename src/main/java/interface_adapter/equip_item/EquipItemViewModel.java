package interface_adapter.equip_item;

import interface_adapter.ViewModel;

/**
 * ViewModel for the Equip Item View.
 */
public class EquipItemViewModel extends ViewModel<EquipItemState> {
    public EquipItemViewModel() {
        super("equip item");
        setState(new EquipItemState());
    }

    /**
     * Updates the inventory slots with the newly equipped item.
     *
     * @param inventory Array of items in inventory slots (Armor, Weapon, Buff)
     */
    public void updateInventory(String[] inventory) {
        EquipItemState state = getState();
        state.setInventory(inventory);
        setState(state);
    }

    /**
     * Sets an error message in the view model state.
     *
     * @param error The error message to display
     */
    public void setError(String error) {
        EquipItemState state = getState();
        state.setError(error);
        setState(state);
    }
}
