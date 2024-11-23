package use_case.talk_to_npc;

import entity.Npc;

/**
 * DAO for the Talk To Npc Use Case.
 */
public interface TalkToNpcDataAccessInterface {

    /**
     * Returns the current NPC.
     * @param name the name of the NPC
     * @return the current NPC
     */
    Npc get(String name);

    /**
     * Returns the current NPC name.
     * @return the current NPC name
     */
    String getCurrentNpcName();

    /**
     * Sets the name of the new NPC.
     * @param name the name of the new NPC
     */
    void setCurrentNpcName(String name);
}

