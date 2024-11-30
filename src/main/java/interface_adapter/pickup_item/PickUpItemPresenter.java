package interface_adapter.pickup_item;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.pickup_item.PickUpItemOutputBoundary;
import use_case.pickup_item.PickUpItemOutputData;

import javax.swing.JOptionPane;

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
        // Update the Pick-Up Item ViewModel with the picked-up item
        pickUpItemViewModel.updateItems(new String[]{response.getItemName()});

        // Navigate to the Pick-Up Item view
        viewManagerModel.setState(pickUpItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        pickUpItemViewModel.setError(error);

        JOptionPane.showMessageDialog(null, error, "Pick-Up Item Error", JOptionPane.ERROR_MESSAGE);
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
