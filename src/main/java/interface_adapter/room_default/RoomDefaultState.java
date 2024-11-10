package interface_adapter.room_default;

/**
 * The state for the Room Default View Model.
 */
public class RoomDefaultState {
    private String roomDescription = "No description available.";
    private String roomContent = "No content available.";
    private String errorMessage = "";
    private int roomNumber = 1;  // Default to room 1
    private String roomType = "";  // e.g., Monster, Treasure, Trap

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomContent() {
        return roomContent;
    }

    public void setRoomContent(String roomContent) {
        this.roomContent = roomContent;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
