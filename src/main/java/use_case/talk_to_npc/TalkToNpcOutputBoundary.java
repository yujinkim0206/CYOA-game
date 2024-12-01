package use_case.talk_to_npc;

/**
 * The output boundary for the Talk To Npc Use Case.
 */
public interface TalkToNpcOutputBoundary {

    void moveToNextDialogue(TalkToNpcOutputData outputData);

    void switchToMerchantView();

    void exitInteraction();
}
