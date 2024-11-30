package interface_adapter.talk_to_npc;

import use_case.talk_to_npc.TalkToNpcInputBoundary;

public class TalkToNpcController {

    private final TalkToNpcInputBoundary talkToNpcUseCaseInteractor;

    public TalkToNpcController(TalkToNpcInputBoundary talkToNpcUseCaseInteractor) {
        this.talkToNpcUseCaseInteractor = talkToNpcUseCaseInteractor;
    }

    /**
     * Executes the Talk To Npc Use Case.
     */
    public void execute() {
        talkToNpcUseCaseInteractor.execute();
    }

    public void moveToNextDialogue() {
        talkToNpcUseCaseInteractor.moveToNextDialogue();
    }

    public void switchToMerchantView() {
        talkToNpcUseCaseInteractor.switchToMerchantView();
    }

    public void exitInteraction() {
        talkToNpcUseCaseInteractor.exitInteraction();
    }
}
