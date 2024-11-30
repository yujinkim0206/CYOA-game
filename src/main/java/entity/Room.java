package entity;

public abstract class Room {
    private final int roomNumber;

    public String getDescription() {
        return "description"; // This class is declared to return a String, even abstractly.
    }
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomType(){
        return -1;
    };
        //0: Monster, 1: Item, 2: Trap, 3: Merchant


    /**
     * Returns the room Number of the room.
     *
     * @return the number of room in the floor.
     */
    public int getRoomNumber() {
        return roomNumber;
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
