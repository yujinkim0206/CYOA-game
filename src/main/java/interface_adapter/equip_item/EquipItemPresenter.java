package interface_adapter.equip_item;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.equip_item.EquipItemOutputBoundary;
import use_case.equip_item.EquipItemOutputData;

/**
 * Presenter for the Equip Item Use Case.
 */
public class EquipItemPresenter implements EquipItemOutputBoundary {
    private final EquipItemViewModel viewModel;
    private final RoomDefaultViewModel roomDefaultViewModel;
    private final ViewManagerModel viewManagerModel;

    public EquipItemPresenter(ViewManagerModel viewManagerModel,
                              EquipItemViewModel viewModel,
                              RoomDefaultViewModel roomDefaultViewModel) {
        this.viewModel = viewModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(EquipItemOutputData response) {
        // Update inventory with the newly equipped item
        viewModel.updateInventory(new String[]{response.getItemName()});

        // Set the view to reflect the success state
        viewManagerModel.setState(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Update the view model with the error message
        viewModel.setError(error);

        // Revert to the default view state (Room Default View)
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
