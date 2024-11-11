package use_case.room_default;

import entity.MonsterRoom;
import entity.ItemRoom;
import entity.TrapRoom;
import entity.Room;
import entity.Monster;
import entity.Item;
import entity.Trap;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of RoomDataAccessInterface.
 * Fetches rooms by their number from an in-memory list.
 */
public class RoomDataAccess implements RoomDataAccessInterface {

    private final List<Room> rooms;

    /**
     * Constructor for RoomDataAccess.
     * Initializes a list of rooms with different types for demonstration.
     */
    public RoomDataAccess() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    /**
     * Populates the rooms list with various room types.
     */
    private void initializeRooms() {
        rooms.add(new MonsterRoom(new Monster())); // Room 0: Monster Room
        rooms.add(new ItemRoom(new Item()));       // Room 1: Item Room
        rooms.add(new TrapRoom(new Trap()));       // Room 2: Trap Room
        // Add more rooms as needed
    }

    /**
     * Fetches a room by its number from the in-memory list.
     * @param roomNumber the room number to fetch
     * @return the Room object, or null if not found
     */
    @Override
    public Room getRoomByNumber(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < rooms.size()) {
            return rooms.get(roomNumber);
        }
        return null; // Return null if room number is out of range
    }
}