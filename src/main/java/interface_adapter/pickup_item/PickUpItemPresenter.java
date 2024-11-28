package interface_adapter.pickup_item;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.pickup_item.PickUpItemOutputBoundary;
import use_case.pickup_item.PickUpItemOutputData;

/**
 * Presenter for the Pick-Up Item Use Case.
 */
public class PickUpItemPresenter implements PickUpItemOutputBoundary {
    private final PickUpItemViewModel pickUpItemViewModel;
    private final RoomDefaultViewModel roomDefaultViewModel;
    private final ViewManagerModel viewManagerModel;

    public PickUpItemPresenter(ViewManagerModel viewManagerModel,
                               PickUpItemViewModel pickUpItemViewModel,
                               RoomDefaultViewModel roomDefaultViewModel) {
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(PickUpItemOutputData response) {
        pickUpItemViewModel.updateItems(new String[]{response.getItemName()});
        viewManagerModel.setState(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        pickUpItemViewModel.setError(error);
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
