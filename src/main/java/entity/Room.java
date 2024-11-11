package entity;

public abstract class Room {
    public String getDescription() {
        return "description"; // This class is declared to return a String, even abstractly.
    }

    public int getRoomType() {
        return -1; // This class is declared to return an int, even abstractly.
    }
}
