package frEntity;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final ArrayList<Room> RoomList;

    /**
     * Constructor for the Floor class, each of the parameters in the room constructors
     * are random and will be instantiated when we start pulling from the API
     * Randomly populate the Rooms on the Floor with the various kinds of Room
     *
     */
    public Floor() {
        this.RoomList = new ArrayList<>();
        for (int i = 0; i < RoomSize.ROOM_SIZE; i++){
            int n = (int)(Math.random() * RoomSize.ROOM_SIZE);
            if (n < 4){
                Monster monster = new Monster();
                this.RoomList.add(new MonsterRoom(monster));
            }
            else if (n < 6){
                Item item = new Item();
                this.RoomList.add(new ItemRoom(item));
            }
            else if (n < 7){
                Npc npc = new Npc();
                this.RoomList.add(new NPCRoom(npc));
            }
            else{
                Trap trap = new Trap();
                this.RoomList.add(new TrapRoom(trap));
            }
        }
    }

    /** Returns the RoomList of the Floor
     *
     * @return the RoomList of this Floor
     */
    public List<Room> getRoomList() {
        return RoomList;
    }
}
