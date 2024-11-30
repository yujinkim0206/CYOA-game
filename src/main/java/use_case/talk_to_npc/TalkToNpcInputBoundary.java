package use_case.talk_to_npc;

/**
 * Input Boundary for actions which are related to talking to NPC.
 */
public interface TalkToNpcInputBoundary {

    /**
     * Executes the talk to npc use case.
     */
    void execute();

    void moveToNextDialogue();

    void switchToMerchantView();

    void exitInteraction();
}
