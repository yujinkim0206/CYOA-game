package use_case.room_default;

import entity.Npc;

public interface NpcRoomDataAccessInterface {

    /**
     * Returns the current NPC.
     * @return the current NPC
     */
    Npc getCurrentNpc();

    void setCurrentNpc(Npc npc);

    Npc generateRandomNpc();

    void loadNpcs();
}