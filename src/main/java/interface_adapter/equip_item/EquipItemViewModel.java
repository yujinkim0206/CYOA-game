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

    public void updateInventory(String[] inventory) {
        EquipItemState state = getState();
        state.setInventory(inventory);
        setState(state);
    }

    public void setError(String error) {
        EquipItemState state = getState();
        state.setError(error);
        setState(state);
    }
}
