package use_case.talk_to_npc;

import java.util.List;

/**
 * Input Boundary for actions which are related to talking to NPC.
 */
public interface TalkToNpcInputBoundary {

    void moveToNextDialogue(String name, String description, List<String> dialogue,
                            int currentDialogueIndex, boolean hasNextDialogue, boolean isMerchant);

    void switchToMerchantView();

    void exitInteraction();
}
