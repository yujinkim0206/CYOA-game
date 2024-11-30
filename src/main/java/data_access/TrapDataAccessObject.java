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
    public Trap getCurrentTrap(String name) {
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

    @Override
    public Trap generateRandomTrap() {
        if (traps.isEmpty()) {
            return null;
        }

        // Retrieves the set of keys from traps and convert it into an array
        String keys[] = traps.keySet().toArray(new String[0]);
        // Pick a number between 0 and keys.length and cast to an int
        String randomKey = keys[(int) (Math.random() * keys.length)];
        setCurrentTrapName(randomKey);

        return traps.remove(randomKey);
    }

    @Override
    public void loadTraps() {
        traps.put("Pendulums", new Trap("Pendulums", 10));
        traps.put("Call Of Distress", new Trap("Call Of Distress", 5));
        traps.put("Snares", new Trap("Snares", 3));
        traps.put("Mimic", new Trap("Mimic", 8));
        traps.put("Bear Traps", new Trap("Bear Traps", 6));
        traps.put("Gelatinous Cube", new Trap("Gelatinous Cube", 12));
        traps.put("The False Adventure", new Trap("The False Adventure", 4));
        traps.put("The Rolling Boulder", new Trap("The Rolling Boulder", 10));
        traps.put("The Trusty Pit Trap", new Trap("The Trusty Pit Trap", 7));
        traps.put("The Duplicate Mirror", new Trap("The Duplicate Mirror", 6));
        traps.put("Teleport Doorway", new Trap("Teleport Doorway", 5));
        traps.put("Glyph Of Warding And Fire Trap Spells", new Trap("Glyph Of Warding And Fire Trap Spells", 15));
        traps.put("Web Of Flames", new Trap("Web Of Flames", 14));
        traps.put("Pressure Plated Items", new Trap("Pressure Plated Items", 4));
        traps.put("The Statues Are Alive", new Trap("The Statues Are Alive", 9));
        traps.put("The Compactor", new Trap("The Compactor", 13));
        traps.put("Greased Slide", new Trap("Greased Slide", 4));
        traps.put("Polymorph Trap", new Trap("Polymorph Trap", 6));
        traps.put("Poison Needles", new Trap("Poison Needles", 5));
        traps.put("Fun With Magnets", new Trap("Fun With Magnets", 7));
        traps.put("Let’s Go Fishing", new Trap("Let’s Go Fishing", 8));
        traps.put("Umber Hulk Ambush", new Trap("Umber Hulk Ambush", 12));
        traps.put("The Furnace", new Trap("The Furnace", 15));
        traps.put("The Magic Mouth", new Trap("The Magic Mouth", 3));
        traps.put("Portable Hole Into The Bag Of Holding", new Trap("Portable Hole Into The Bag Of Holding", 20));
    }
}
