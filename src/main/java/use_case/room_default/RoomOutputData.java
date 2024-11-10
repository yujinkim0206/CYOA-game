package use_case.room_default;

/**
 * Output Data for the Room Default Use Case.
 */
public class RoomOutputData {

    private final String roomDescription;
    private final String roomContent;

    public RoomOutputData(String roomDescription, String roomContent) {
        this.roomDescription = roomDescription;
        this.roomContent = roomContent;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getRoomContent() {
        return roomContent;
    }
}
