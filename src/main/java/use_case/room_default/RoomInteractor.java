package use_case.room_default;

import entity.Floor;
import entity.Room;
import java.util.List;

/**
 * The Room Default Interactor.
 */
public class RoomInteractor implements RoomInputBoundary {

    private final RoomOutputBoundary roomPresenter;
    private final RoomDataAccessInterface roomDataAccess;
    private final Floor floor; // Added Floor as a dependency
    private int currentRoomIndex = 0; // Track the current room

    public RoomInteractor(RoomOutputBoundary roomPresenter, RoomDataAccessInterface roomDataAccess, Floor floor) {
        this.roomPresenter = roomPresenter;
        this.roomDataAccess = roomDataAccess;
        this.floor = floor;
    }

    @Override
    public void interactWithRoom(RoomInputData inputData) {
        Room room = roomDataAccess.getRoomByNumber(inputData.getRoomNumber());

        if (room == null) {
            roomPresenter.prepareFailView("Room not found.");
            return;
        }

        displayRoomDetails(room);
    }

    /**
     * Fetches the next room from the floor and displays it.
     */
    public void goToNextRoom() {
        List<Room> rooms = floor.getRoomList();

        if (currentRoomIndex < rooms.size()) {
            Room nextRoom = rooms.get(currentRoomIndex);
            displayRoomDetails(nextRoom);
            currentRoomIndex++;
        } else {
            roomPresenter.prepareFailView("You have reached the end of the floor.");
        }
    }

    @Override
    public void returnToMainMenu() {
    }

    /**
     * Helper method to prepare and display room details.
     * @param room the room to display
     */
    private void displayRoomDetails(Room room) {
        String roomContent;
        switch (room.getRoomType()) {
            // .getRoomType() returns an int. I don't think these correlate correctly here, but it runs.
            case 0:
                roomContent = "It's a monster!";
                break;
            case 1:
                roomContent = "You found a treasure!";
                break;
            case 2:
                roomContent = "It's a trap!";
                break;
            default:
                roomContent = "You have cleared the floor!";
        }

        RoomOutputData outputData = new RoomOutputData(room.getDescription(), roomContent);
        roomPresenter.prepareSuccessView(outputData);
    }
}