package interface_adapter.open_inventory;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultViewModel;
import interface_adapter.room_default.RoomDefaultState;
import use_case.open_inventory.OpenInventoryOutputBoundary;
import use_case.open_inventory.OpenInventoryOutputData;

/**
 * The Presenter for the Open Inventory Use Case.
 */
public class OpenInventoryPresenter implements OpenInventoryOutputBoundary {

    private OpenInventoryViewModel openInventoryViewModel; // Would be used for fail view when implemented
    private ViewManagerModel viewManagerModel;
    private RoomDefaultViewModel roomDefaultViewModel;

    public OpenInventoryPresenter(ViewManagerModel viewManagerModel,
                          OpenInventoryViewModel openInventoryViewModel,
                          RoomDefaultViewModel roomDefaultViewModel) {
        this.openInventoryViewModel = openInventoryViewModel;
        this.viewManagerModel = viewManagerModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
    }

    @Override
    public void prepareSuccessView(OpenInventoryOutputData response) {
        final RoomDefaultState roomDefaultState = roomDefaultViewModel.getState();
        this.roomDefaultViewModel.setState(roomDefaultState);
        this.roomDefaultViewModel.firePropertyChanged();

        this.viewManagerModel.setState(roomDefaultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // We're assuming that this never fails.
    }
}
