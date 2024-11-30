package use_case.room_default;

/**
 * Output Data for the Room Default Use Case.
 */
public class RoomOutputData {
    private final String roomDescription;
    private final String roomType;

    /**
     * Constructor for RoomOutputData.
     *
     * @param roomDescription the description of the room
     * @param roomType        the type of the room
     */
    public RoomOutputData(String roomDescription, String roomType) {
        this.roomDescription = roomDescription;
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getRoomType() {
        return roomType;
    }
}
