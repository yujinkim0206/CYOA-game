package entity;

public class NpcRoom extends Room{
    private Npc npc;

    /**
     * Creates an NPCRoom
     */
    public NpcRoom(int roomNumber){
        super(roomNumber);
    }

    /**
     * Returns the Npc in the NPCRoom
     * @return the Npc in NPCRoom
     */
    public Npc getNpc(){
        return npc;
    }

    /**
     * Allows us to set the Npc in the NPCRoom
     * @param npc the npc we want to set inside the NPCRoom
     */
    public void setNpc(Npc npc){
        this.npc = npc;
    }

    @Override
    public int getRoomType() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "Room " + getRoomNumber() + ": Someone is in this room.";
    }
}
