package use_case.talk_to_npc;

import entity.Npc;
import entity.NpcRoom;

import java.util.List;

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

    @Override
    public void execute(TalkToNpcInputData talkToNpcInputData) {
        final String name = talkToNpcInputData.getName();
        final String description = talkToNpcInputData.getDescription();
        final List<String> dialogue = talkToNpcInputData.getDialogue();

        talkToNpcDataAccessObject.setCurrentNpcName(talkToNpcInputData.getName());

        final TalkToNpcOutputData talkToNpcOutputData = new TalkToNpcOutputData(false);
        talkToNpcPresenter.prepareSuccessView(talkToNpcOutputData);
    }
}
