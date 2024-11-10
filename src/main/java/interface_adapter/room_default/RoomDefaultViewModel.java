package interface_adapter.room_default;

import interface_adapter.ViewModel;

/**
 * The View Model for the Room Default View.
 */
public class RoomDefaultViewModel extends ViewModel<RoomDefaultState> {

    public RoomDefaultViewModel() {
        super("room default");
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

    public void updateRoomNumber(int roomNumber) {
        RoomDefaultState currentState = getState();
        currentState.setRoomNumber(roomNumber);
        setState(currentState);
    }

    public void loadRoom(String description, String content, int roomNumber, String roomType) {
        RoomDefaultState currentState = getState();
        currentState.setRoomDescription(description);
        currentState.setRoomContent(content);
        currentState.setRoomNumber(roomNumber);
        currentState.setRoomType(roomType);
        currentState.setErrorMessage("");  // Clear any previous errors
        setState(currentState);
    }
}
