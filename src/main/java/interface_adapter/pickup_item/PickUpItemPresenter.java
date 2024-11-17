package interface_adapter.pickup_item;

import interface_adapter.ViewManagerModel;
import use_case.pickup_item.PickUpItemOutputBoundary;
import use_case.pickup_item.PickUpItemOutputData;

/**
 * The Presenter for the PickUp Item Use Case.
 */
public class PickUpItemPresenter implements PickUpItemOutputBoundary {

    private PickUpItemViewModel pickUpItemViewModel;
    private ViewManagerModel viewManagerModel;

    public PickUpItemPresenter(ViewManagerModel viewManagerModel,
                               PickUpItemViewModel pickUpItemViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.pickUpItemViewModel = pickUpItemViewModel;
    }

    @Override
    public void prepareSuccessView(PickUpItemOutputData response) {
        pickUpItemViewModel.updateItems(response.getUpdatedItems());
        viewManagerModel.setState(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Handle any errors or failures here
    }
}
