package interface_adapter.room_default;

import interface_adapter.ViewModel;

/**
 * View Model for the Room Default View.
 */
public class RoomDefaultViewModel extends ViewModel<RoomDefaultState> {

    public RoomDefaultViewModel() {
        super("room view");
        setState(new RoomDefaultState());
    }

    public void updateRoomDescription(String description) {
        RoomDefaultState currentState = getState();
        currentState.setRoomDescription(description);
        setState(currentState);
    }

    public void updateRoomContent(String content) {
        RoomDefaultState currentState = getState();
        currentState.setRoomContent(content);
        setState(currentState);
    }

    public void updateErrorMessage(String errorMessage) {
        RoomDefaultState currentState = getState();
        currentState.setErrorMessage(errorMessage);
        setState(currentState);
    }

    public void clearErrorMessage() {
        RoomDefaultState currentState = getState();
        currentState.setErrorMessage("");
        setState(currentState);
    }
}
