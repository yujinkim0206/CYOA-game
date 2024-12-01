package interface_adapter.talk_to_npc;

import use_case.talk_to_npc.TalkToNpcInputBoundary;

import java.util.List;

public class TalkToNpcController {

    private final TalkToNpcInputBoundary talkToNpcUseCaseInteractor;

    public TalkToNpcController(TalkToNpcInputBoundary talkToNpcUseCaseInteractor) {
        this.talkToNpcUseCaseInteractor = talkToNpcUseCaseInteractor;
    }

    public void moveToNextDialogue(String name, String description, List<String> dialogue,
                                   int currentDialogueIndex, boolean hasNextDialogue, boolean isMerchant) {
        talkToNpcUseCaseInteractor.moveToNextDialogue(name, description, dialogue, currentDialogueIndex,
                hasNextDialogue, isMerchant);
    }

    public void switchToMerchantView() {
        talkToNpcUseCaseInteractor.switchToMerchantView();
    }

    public void exitInteraction() {
        talkToNpcUseCaseInteractor.exitInteraction();
    }
}
