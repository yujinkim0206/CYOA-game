package entity;

public class TrapRoom extends Room{
    private Trap trap;

    /**
     * Creates an TrapRoom
     */
    public TrapRoom(int roomNumber) {
        super(roomNumber);
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

    @Override
    public int getRoomType() {
        return 2; // Trap Room
    }

    @Override
    public String getDescription() {
        return "Room " + getRoomNumber() + ": The room appears empty and harmless.";
    }
}
