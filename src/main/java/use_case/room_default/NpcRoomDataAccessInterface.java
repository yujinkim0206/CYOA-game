package use_case.room_default;

import entity.Npc;

public interface NpcRoomDataAccessInterface {

    /**
     * Returns the current NPC.
     * @param name the name of the NPC
     * @return the current NPC
     */
    Npc getCurrentNpc(String name);

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

    Npc generateRandomNpc();

    void loadNpcs();
}