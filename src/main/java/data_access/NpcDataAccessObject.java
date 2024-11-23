package data_access;

import entity.Npc;
import entity.Trap;
import use_case.talk_to_npc.TalkToNpcDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory implementation of the DAO for storing NPC data. This implementation does
 * NOT persist data between runs of the program.
 */
public class NpcDataAccessObject implements TalkToNpcDataAccessInterface {
    private final Map<String, Npc> npcs = new HashMap<>();
    private String currentNpcName;

    @Override
    public Npc get(String name) {
        return npcs.get(name);
    }

    @Override
    public String getCurrentNpcName() {
        return currentNpcName;
    }

    @Override
    public void setCurrentNpcName(String name) {
        this.currentNpcName = name;
    }
}
