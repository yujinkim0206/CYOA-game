package use_case.room_default;

import entity.Floor;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of RoomDataAccessInterface.
 */
public class RoomDataAccess implements RoomDataAccessInterface {

    private final List<Room> rooms;

    /**
     * Constructor for RoomDataAccess.
     * Initializes the rooms with a random floor layout.
     */
    public RoomDataAccess() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    /**
     * Populates the rooms list with different room types.
     */
    private void initializeRooms() {
        // Example: Add predefined or randomly generated rooms
        Floor floor = new Floor(); // Uses your Floor logic
        rooms.addAll(floor.getRoomList());
    }

    /**
     * Fetches a room by its number.
     *
     * @param roomNumber the room number
     * @return the Room object or null if not found
     */
    @Override
    public Room getRoomByNumber(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < rooms.size()) {
            return rooms.get(roomNumber);
        }
        return null;
    }
}
