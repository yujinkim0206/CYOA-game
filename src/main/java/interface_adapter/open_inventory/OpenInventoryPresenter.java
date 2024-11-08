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

    private OpenInventoryViewModel openInventoryViewModel;
    private ViewManagerModel viewManagerModel;
//    private LoginViewModel loginViewModel;   REPLACE THIS WITH THE SCREEN BEING TRANSITIONED TO
    private RoomDefaultViewModel roomDefaultViewModel;

    public OpenInventoryPresenter(ViewManagerModel viewManagerModel,
                          OpenInventoryViewModel openInventoryViewModel,
                           /*LoginViewModel loginViewModel  REPLACE THIS WITH THE SCREEN BEING TRANSITIONED TO*/
                          RoomDefaultViewModel roomDefaultViewModel) {
        this.openInventoryViewModel = openInventoryViewModel;
        this.viewManagerModel = viewManagerModel;
        //this.???ViewModel = ???ViewModel;   REPLACE THIS WITH THE SCREEN BEING TRANSITIONED TO
        this.roomDefaultViewModel = roomDefaultViewModel;
    }

    @Override
    public void prepareSuccessView(OpenInventoryOutputData response) {
//        final LoggedInState loggedInState = loggedInViewModel.getState();   REPLACE W/ CORRECT SCREEN
        final RoomDefaultState roomDefaultState = roomDefaultViewModel.getState();
//        this.loggedInViewModel.setState(loggedInState);   REPLACE W/ CORRECT SCREEN
        this.roomDefaultViewModel.setState(roomDefaultState);
//        this.loggedInViewModel.firePropertyChanged();   REPLACE W/ CORRECT SCREEN
        this.roomDefaultViewModel.firePropertyChanged();

        this.viewManagerModel.setState(/* loggedInViewModel.getViewName() REPLACE W/ CORRECT SCREEN*/
                                       roomDefaultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // We're assuming that this never fails.
    }
}
