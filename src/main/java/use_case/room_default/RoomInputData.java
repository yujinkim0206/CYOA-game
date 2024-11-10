package use_case.room_default;

/**
 * Input Data for the Room Default Use Case.
 */
public class RoomInputData {

    private final int roomNumber;

    public RoomInputData(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
