package data_access;

import entity.Floor;
import entity.Room;
import use_case.room_default.RoomDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing room data. This implementation does
 * NOT persist data between runs of the program.
 */
public class RoomDataAccessObject implements RoomDataAccessInterface {
    private Floor floor = new Floor();
    private int currentRoomIndex = 0;

    @Override
    public Floor getFloor() {
        return floor;
    }

    @Override
    public int getCurrentRoomIndex() {
        return currentRoomIndex;
    }

    @Override
    public void setCurrentRoomIndex(int currentRoomIndex) {
        this.currentRoomIndex = currentRoomIndex;
    }

    @Override
    public Room getCurrentRoom() {
        return floor.getRoomList().get(currentRoomIndex);
    }

//    public void initializeFloor() {
//        floor = new Floor();
//    }

//    /**
//     * Constructor for RoomDataAccess.
//     * Initializes the rooms with a random floor layout.
//     */
//    public RoomDataAccessObject() {
//        rooms = new ArrayList<>();
//        initializeRooms();
//    }

//    /**
//     * Fetches a room by its number.
//     *
//     * @param roomNumber the room number
//     * @return the Room object or null if not found
//     */
//    @Override
//    public Room getRoomByNumber(int roomNumber) {
//        if (roomNumber >= 0 && roomNumber < rooms.size()) {
//            return rooms.get(roomNumber);
//        }
//        return null;
//    }
}
