package interface_adapter.open_inventory;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultState;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.open_inventory.OpenInventoryOutputBoundary;
import use_case.open_inventory.OpenInventoryOutputData;

/**
 * The Presenter for the Open Inventory Use Case.
 */
public class OpenInventoryPresenter implements OpenInventoryOutputBoundary {
    // Was to be used for fail view
    private OpenInventoryViewModel openInventoryViewModel;
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
        openInventoryViewModel.updateInventory(response.getInventory());
        viewManagerModel.setState(openInventoryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        openInventoryViewModel.setError(error);
        viewManagerModel.setState("room view");
        viewManagerModel.firePropertyChanged();
    }

}
