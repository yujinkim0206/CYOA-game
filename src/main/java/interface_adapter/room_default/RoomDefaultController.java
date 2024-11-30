package interface_adapter.room_default;

import use_case.room_default.RoomInputBoundary;
import use_case.room_default.RoomInputData;

/**
 * Controller for the Room Default Use Case.
 */
public class RoomDefaultController {
    private final RoomInputBoundary interactor;

    /**
     * Constructor for RoomDefaultController.
     *
     * @param interactor the use case interactor for room interactions
     */
    public RoomDefaultController(RoomInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Executes interaction with the room.
     *
     * @param roomNumber the room number to interact with
     */
    public void interactWithRoom(int roomNumber) {
        interactor.interactWithRoom(new RoomInputData(roomNumber));
    }

    /**
     * Proceeds to the next room on the floor.
     */
    public void goToNextRoom() {
        interactor.goToNextRoom();
    }

    /**
     * Returns to the main menu (or inventory).
     */
    public void returnToMainMenu() {
        interactor.returnToMainMenu();
    }
}
