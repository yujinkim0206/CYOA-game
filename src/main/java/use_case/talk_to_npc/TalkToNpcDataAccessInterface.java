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

    void setCurrentNpc(Npc npc);

    Npc generateRandomNpc();

    void loadNpcs();
}

