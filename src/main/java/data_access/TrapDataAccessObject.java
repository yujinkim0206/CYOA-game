package data_access;

import entity.Trap;
import use_case.fall_for_trap.FallForTrapDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory implementation of the DAO for storing trap data. This implementation does
 * NOT persist data between runs of the program.
 */
public class TrapDataAccessObject implements FallForTrapDataAccessInterface {
    private final Map<String, Trap> traps = new HashMap<>();
    private String currentTrapName;

    @Override
    public Trap get(String name) {
        return traps.get(name);
    }

    @Override
    public String getCurrentTrapName() {
        return currentTrapName;
    }

    @Override
    public void setCurrentTrapName(String name) {
        this.currentTrapName = name;
    }
}
