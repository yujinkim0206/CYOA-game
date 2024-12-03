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
        viewModel.updateInventory(new String[]{response.getItemName()});
        viewManagerModel.setState(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        viewModel.setError(error);
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
