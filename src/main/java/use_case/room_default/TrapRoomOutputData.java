package use_case.room_default;

public class TrapRoomOutputData extends RoomOutputData {
    private final String trapName;
    private final int damage;

    TrapRoomOutputData(String roomDescription, String trapName, int damage) {
        super(roomDescription, "TrapRoom");
        this.trapName = trapName;
        this.damage = damage;
    }

    public String getTrapName() {
        return trapName;
    }

    public int getDamage() {
        return damage;
    }
}
