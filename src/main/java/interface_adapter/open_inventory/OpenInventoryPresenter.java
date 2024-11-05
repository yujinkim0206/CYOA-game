package interface_adapter.open_inventory;

import interface_adapter.ViewManagerModel;
// Import view model of screen being transitioned to
//import interface_adapter.___;
import interface_adapter.change_password.LoggedInState;
import use_case.open_inventory.OpenInventoryOutputBoundary;
import use_case.open_inventory.OpenInventoryOutputData;

/**
 * The Presenter for the Open Inventory Use Case.
 */
public class OpenInventoryPresenter implements OpenInventoryOutputBoundary {

    private OpenInventoryViewModel openInventoryViewModel;
    private ViewManagerModel viewManagerModel;
//    private LoginViewModel loginViewModel;   REPLACE THIS WITH THE SCREEN BEING TRANSITIONED TO

    public OpenInventoryPresenter(ViewManagerModel viewManagerModel,
                          OpenInventoryViewModel openInventoryViewModel
                           /*LoginViewModel loginViewModel  REPLACE THIS WITH THE SCREEN BEING TRANSITIONED TO*/) {
        this.openInventoryViewModel = openInventoryViewModel;
        this.viewManagerModel = viewManagerModel;
        //this.???ViewModel = ???ViewModel;   REPLACE THIS WITH THE SCREEN BEING TRANSITIONED TO
    }

    @Override
    public void prepareSuccessView(OpenInventoryOutputData response) {
//        final LoggedInState loggedInState = loggedInViewModel.getState();   REPLACE W/ CORRECT SCREEN
//        this.loggedInViewModel.setState(loggedInState);   REPLACE W/ CORRECT SCREEN
//        this.loggedInViewModel.firePropertyChanged();   REPLACE W/ CORRECT SCREEN

        this.viewManagerModel.setState(/* loggedInViewModel.getViewName() REPLACE W/ CORRECT SCREEN*/);
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // We're assuming that this never fails.
    }
}
