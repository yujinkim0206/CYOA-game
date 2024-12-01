package use_case.room_default;

import entity.Trap;

public interface TrapRoomDataAccessInterface {

    /**
     * Returns the current trap.
     * @param name the name of the trap
     * @return the current trap
     */
    Trap getCurrentTrap(String name);

    /**
     * Returns the current trap name.
     * @return the current trap name
     */
    String getCurrentTrapName();

    /**
     * Sets the name of the new trap.
     * @param name the name of the new trap
     */
    void setCurrentTrapName(String name);

    Trap generateRandomTrap();

    void loadTraps();
}
