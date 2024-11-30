package use_case.talk_to_npc;

import entity.Npc;
import entity.NpcRoom;

/**
 * The Talk To Npc Interactor.
 */
public class TalkToNpcInteractor implements TalkToNpcInputBoundary{
    private TalkToNpcDataAccessInterface talkToNpcDataAccessObject;
    private TalkToNpcOutputBoundary talkToNpcPresenter;

    public TalkToNpcInteractor(TalkToNpcDataAccessInterface talkToNpcDataAccessInterface,
                               TalkToNpcOutputBoundary talkToNpcOutputBoundary) {
        this.talkToNpcDataAccessObject = talkToNpcDataAccessInterface;
        this.talkToNpcPresenter = talkToNpcOutputBoundary;
    }

    //this should be moved to room interactor later.
    @Override
    public void execute() {
        talkToNpcDataAccessObject.loadNpcs();
        Npc npc = talkToNpcDataAccessObject.generateRandomNpc();
        talkToNpcDataAccessObject.setCurrentNpcName(npc.getName());
        //npcRoom.setNpc(npc);

        final TalkToNpcOutputData talkToNpcOutputData = new TalkToNpcOutputData(
                npc.getName(),
                npc.getDescription(),
                npc.getDialogue(),
                npc.getCurrentDialogueIndex(),
                npc.hasNextDialogue(),
                npc.isMerchant()
        );

        talkToNpcPresenter.prepareSuccessView(talkToNpcOutputData);
    }

    @Override
    public void moveToNextDialogue() {
        Npc npc = talkToNpcDataAccessObject.getCurrentNpc(talkToNpcDataAccessObject.getCurrentNpcName());
        if (npc.hasNextDialogue()) {
            npc.moveToNextDialogue();
        }

        TalkToNpcOutputData talkToNpcOutputData = new TalkToNpcOutputData(
                npc.getName(),
                npc.getDescription(),
                npc.getDialogue(),
                npc.getCurrentDialogueIndex(),
                npc.hasNextDialogue(),
                npc.isMerchant()
        );

        talkToNpcPresenter.moveToNextDialogue(talkToNpcOutputData);
    }

    @Override
    public void switchToMerchantView() {
        talkToNpcPresenter.switchToMerchantView();
    }

    @Override
    public void exitInteraction() {
        talkToNpcPresenter.exitInteraction();
    }
}
