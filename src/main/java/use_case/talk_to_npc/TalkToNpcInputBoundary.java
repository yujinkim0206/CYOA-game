package use_case.talk_to_npc;

/**
 * Input Boundary for actions which are related to talking to NPC.
 */
public interface TalkToNpcInputBoundary {

    /**
     * Executes the talk to npc use case.
     * @param talkToNpcInputData the input data
     */
    void execute(TalkToNpcInputData talkToNpcInputData);

    void moveToNextDialogue();

    void switchToMerchantView();

    void exitInteraction();
}
