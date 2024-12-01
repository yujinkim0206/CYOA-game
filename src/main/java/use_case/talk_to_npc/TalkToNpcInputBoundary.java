package use_case.talk_to_npc;

import java.util.List;

/**
 * Input Boundary for actions which are related to talking to NPC.
 */
public interface TalkToNpcInputBoundary {

    /**
     * Moves to the next dialogue with the NPC.
     * @param name the name of the NPC.
     * @param description the description of the NPC.
     * @param dialogue the list of dialogues available for the NPC.
     * @param currentDialogueIndex the current dialogue index being displayed.
     * @param hasNextDialogue whether the NPC has more dialogue available.
     * @param isMerchant whether the NPC is a merchant.
     */
    void moveToNextDialogue(String name, String description, List<String> dialogue,
                            int currentDialogueIndex, boolean hasNextDialogue, boolean isMerchant);

    /**
     * Switches the view to the merchant interface if the NPC is a merchant.
     */
    void switchToMerchantView();

    /**
     * Exits the current interaction with the NPC.
     * Signals the interactor to end the ongoing interaction with the NPC and transition the game state as appropriate.
     */
    void exitInteraction();
}
