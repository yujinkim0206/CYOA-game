package use_case.room_default;

import entity.*;
import java.util.List;

/**
 * The Room Default Interactor.
 */
public class RoomInteractor implements RoomInputBoundary {

    private final RoomOutputBoundary roomPresenter;
    private final RoomDataAccessInterface roomDataAccess;
    private final Floor floor;
    private int currentRoomIndex = 0;

    public RoomInteractor(RoomOutputBoundary roomPresenter, RoomDataAccessInterface roomDataAccess, Floor floor) {
        this.roomPresenter = roomPresenter;
        this.roomDataAccess = roomDataAccess;
        this.floor = floor;
    }

    @Override
    public void interactWithRoom(RoomInputData inputData) {
        Room room = floor.getRoomList().stream()
                .filter(r -> r.getRoomNumber() == inputData.getRoomNumber())
                .findFirst()
                .orElse(null);

        if (room == null) {
            roomPresenter.prepareFailView("Room not found.");
            return;
        }

        roomPresenter.prepareSuccessView(new RoomOutputData(room.getDescription(), room.getClass().getSimpleName()));
    }

    @Override
    public void goToNextRoom() {
        List<Room> rooms = floor.getRoomList();
        if (currentRoomIndex < rooms.size() - 1) {
            currentRoomIndex++;
            Room nextRoom = rooms.get(currentRoomIndex);
            roomPresenter.prepareSuccessView(new RoomOutputData(nextRoom.getDescription(), nextRoom.getClass().getSimpleName()));
        } else {
            roomPresenter.prepareFailView("You have reached the end of the floor.");
        }
    }

    @Override
    public void returnToMainMenu() {
        roomPresenter.prepareFailView("Returning to Open Inventory.");
    }
}
