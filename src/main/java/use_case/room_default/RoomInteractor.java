package use_case.room_default;

import java.entity.Room;
import java.util.Random;

/**
 * The Room Default Interactor.
 */
public class RoomInteractor implements RoomInputBoundary {

    private final RoomOutputBoundary roomPresenter;
    private final RoomDataAccessInterface roomDataAccess;

    public RoomInteractor(RoomOutputBoundary roomPresenter, RoomDataAccessInterface roomDataAccess) {
        this.roomPresenter = roomPresenter;
        this.roomDataAccess = roomDataAccess;
    }

    @Override
    public void interactWithRoom(RoomInputData inputData) {
        Room room = roomDataAccess.getRoomByNumber(inputData.getRoomNumber());

        if (room == null) {
            roomPresenter.prepareFailView("Room not found.");
            return;
        }

        String roomContent;
        switch (room.getRoomType()) {
            case MONSTER:
                roomContent = "It's a monster";//monster descriptions, and it information
                break;
            case ITEM:
                roomContent = "You found treasure: "; // ITEM descriptions
                break;
            case TRAP:
                roomContent = "It's a trap" ;//trap name or descriptions
                break;
            default:
                roomContent = "You have cleared the floor";// You have passed all the rooms in the floor
        }

        RoomOutputData outputData = new RoomOutputData(room.getDescription(), roomContent);
        roomPresenter.prepareSuccessView(outputData);
    }
}
