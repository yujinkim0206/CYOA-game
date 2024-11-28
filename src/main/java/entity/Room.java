package entity;

public abstract class Room {
    public String getDescription() {
        return "description"; // This class is declared to return a String, even abstractly.
    }

    public int getRoomType() {
        return -1; // This class is declared to return an int, even abstractly.
    }

    /**
     * Returns the item in the room.
     * Default implementation returns null, as not all rooms contain items.
     *
     * @return the item in the room, or null if none
     */
    public Item getItem() {
        return null; // Default implementation
    }


}
