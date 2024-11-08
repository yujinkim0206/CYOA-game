package FloorRoomEntities;

public class TrapRoom extends Room{
    private Trap trap;

    /**
     * Creates an TrapRoom
     * @param trap the trap in the TrapRoom
     */

    public TrapRoom(Trap trap) {
        this.trap = trap;
    }

    /**
     * Returns the trap in the TrapRoom
     * @return the trap in TrapRoom
     */

    public Trap getTrap() {
        return trap;
    }

    /**
     * Allows us to set the trap in the TrapRoom
     * @param trap the trap we want to set inside the TrapRoom
     */

    public void setTrap(Trap trap) {
        this.trap = trap;
    }
}
