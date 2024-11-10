package use_case.room_default;

import java.entity.Room;

/**
 * Data Access Interface for Room Use Case.
 */
public interface RoomDataAccessInterface {

    /**
     * Fetches a room by its number.
     * @param roomNumber the room number
     * @return the Room object
     */
    Room getRoomByNumber(int roomNumber);
}
