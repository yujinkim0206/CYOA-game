package interface_adapter.room_default;

import use_case.room_default.RoomInputBoundary;
import use_case.room_default.RoomInputData;

/**
 * The controller for the Room Default Use Case.
 */
public class RoomDefaultController {

    private final RoomInputBoundary roomUseCaseInteractor;

    public RoomDefaultController(RoomInputBoundary roomUseCaseInteractor) {
        this.roomUseCaseInteractor = roomUseCaseInteractor;
    }

    /**
     * Executes the Room Interaction Use Case.
     * @param roomNumber the current room number the player is in.
     */
    public void interactWithRoom(int roomNumber) {
        final RoomInputData roomInputData = new RoomInputData(roomNumber);
        roomUseCaseInteractor.interactWithRoom(roomInputData);
    }

    public void goToNextRoom() {
        roomUseCaseInteractor.goToNextRoom();
    }

    public void returnToMainMenu() {
        roomUseCaseInteractor.returnToMainMenu();
    }
}
