package use_case.talk_to_npc;

import entity.Npc;
import entity.NpcRoom;
import use_case.open_inventory.OpenInventoryOutputData;

import java.util.List;

/**
 * The Talk To Npc Interactor.
 */
public class TalkToNpcInteractor implements TalkToNpcInputBoundary{
    private TalkToNpcDataAccessInterface talkToNpcDataAccessObject;
    private TalkToNpcOutputBoundary talkToNpcPresenter;
    private Npc npc;


    public TalkToNpcInteractor(TalkToNpcDataAccessInterface talkToNpcDataAccessInterface,
                               TalkToNpcOutputBoundary talkToNpcOutputBoundary) {
        this.talkToNpcDataAccessObject = talkToNpcDataAccessInterface;
        this.talkToNpcPresenter = talkToNpcOutputBoundary;
    }

    @Override
    public void execute(TalkToNpcInputData talkToNpcInputData) {
        npc = new Npc(talkToNpcInputData.getName(), talkToNpcInputData.getDescription(), talkToNpcInputData.getDialogue());

        talkToNpcDataAccessObject.setCurrentNpcName(npc.getName());

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

        talkToNpcPresenter.prepareSuccessView(talkToNpcOutputData);
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
