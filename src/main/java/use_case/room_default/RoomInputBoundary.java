package use_case.room_default;

/**
 * Input Boundary for the Room Default Use Case.
 */
public interface RoomInputBoundary {

    /**
     * Executes the room interaction use case.
     * @param inputData the input data containing room details
     */
    void interactWithRoom(RoomInputData inputData);

    void goToNextRoom();

    void returnToMainMenu();
}
