package entity;

public class TrapRoom extends Room{
    private Trap trap;

    @Override
    public int getRoomType() {
        return 2; // Trap Room
    }
    /**
     * Creates an TrapRoom
     * @param trap the trap in the TrapRoom
     */

    public TrapRoom(int roomNumber, Trap trap) {
        super(roomNumber);
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
