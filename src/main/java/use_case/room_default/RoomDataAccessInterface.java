package use_case.room_default;

import entity.Floor;
import entity.Room;

/**
 * Data Access Interface for Room Use Case.
 */
public interface RoomDataAccessInterface {

//    /**
//     * Populates the rooms list with different room types.
//     */
//    void initializeFloor();

    Floor getFloor();

    int getCurrentRoomIndex();

    void setCurrentRoomIndex(int currentRoomIndex);

    Room getCurrentRoom();
}
