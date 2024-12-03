package use_case.room_default;

public class MonsterRoomOutputData extends RoomOutputData {
    private final int health;
    private final String name;

    MonsterRoomOutputData(String roomDescription, int health, String name) {
        super(roomDescription, "MonsterRoom");
        this.health = health;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
