package data_access;

import entity.Room;
import use_case.room_default.RoomDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing room data. This implementation does
 * NOT persist data between runs of the program.
 */
public class RoomDataAccessObject implements RoomDataAccessInterface {
    // For now this has no code, it's just a placeholder.

    @Override
    public Room getRoomByNumber(int roomNumber) {
        return null;
    }
}
