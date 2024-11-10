package interface_adapter.room_default;

import interface_adapter.ViewManagerModel;
import use_case.room_default.RoomOutputBoundary;
import use_case.room_default.RoomOutputData;

/**
 * The Presenter for the Room Default Use Case.
 */
public class RoomDefaultPresenter implements RoomOutputBoundary {

    private final RoomDefaultViewModel roomDefaultViewModel;
    private final ViewManagerModel viewManagerModel;

    public RoomDefaultPresenter(ViewManagerModel viewManagerModel, RoomDefaultViewModel roomDefaultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
    }

    @Override
    public void prepareSuccessView(RoomOutputData outputData) {
        RoomDefaultState currentState = roomDefaultViewModel.getState();

        currentState.setRoomDescription(outputData.getRoomDescription());
        currentState.setRoomContent(outputData.getRoomContent());

        roomDefaultViewModel.setState(currentState);
        roomDefaultViewModel.firePropertyChanged();
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        RoomDefaultState currentState = roomDefaultViewModel.getState();
        currentState.setErrorMessage(errorMessage);

        roomDefaultViewModel.setState(currentState);
        roomDefaultViewModel.firePropertyChanged();
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

