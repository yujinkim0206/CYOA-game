package use_case.talk_to_npc;

import entity.Npc;

/**
 * DAO for the Talk To Npc Use Case.
 */
public interface TalkToNpcDataAccessInterface {

    /**
     * Returns the current NPC.
     * @return the current NPC
     */
    Npc getCurrentNpc();

    /**
     * Sets the current NPC being interacted with.
     * @param npc the NPC to set as the current NPC.
     */
    void setCurrentNpc(Npc npc);

    /**
     * Generates a random NPC for interaction.
     * @return a randomly generated NPC.
     */
    Npc generateRandomNpc();

    /**
     * Loads all NPCs into the system.
     */
    void loadNpcs();
}

