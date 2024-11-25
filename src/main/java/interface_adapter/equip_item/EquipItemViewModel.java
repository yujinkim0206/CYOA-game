package interface_adapter.equip_item;

import interface_adapter.ViewModel;

/**
 * The View Model for the Equip Item View.
 */
public class EquipItemViewModel extends ViewModel<EquipItemState> {

    public EquipItemViewModel() {
        super("equip item");
        setState(new EquipItemState());
    }

    public void updateInventory(String[] inventory) {
        EquipItemState currentState = getState();
        currentState.setInventory(inventory);
        setState(currentState);
    }
}
