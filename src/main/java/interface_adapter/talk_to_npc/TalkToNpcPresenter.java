package interface_adapter.talk_to_npc;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultState;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.talk_to_npc.TalkToNpcOutputBoundary;
import use_case.talk_to_npc.TalkToNpcOutputData;

/**
 * The Presenter for the Talk To Npc Use Case.
 */
public class TalkToNpcPresenter implements TalkToNpcOutputBoundary {

    private final TalkToNpcViewModel talkToNpcViewModel;
    private final RoomDefaultViewModel roomDefaultViewModel;
    private final ViewManagerModel viewManagerModel;

    public TalkToNpcPresenter(ViewManagerModel viewManagerModel,
                                TalkToNpcViewModel talkToNpcViewModel,
                                RoomDefaultViewModel roomDefaultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.talkToNpcViewModel = talkToNpcViewModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
    }

    @Override
    public void prepareSuccessView(TalkToNpcOutputData response) {

        TalkToNpcState talkToNpcState = talkToNpcViewModel.getState();
        talkToNpcState.setName(response.getName());
        talkToNpcState.setDescription(response.getDescription());
        talkToNpcState.setDialogue(response.getDialogue());
        talkToNpcState.setCurrentDialogueIndex(response.getCurrentDialogueIndex());
        talkToNpcState.setNextDialogue(response.hasNextDialogue());
        talkToNpcState.setMerchant(response.isMerchant());

        this.viewManagerModel.setState(this.talkToNpcViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void moveToNextDialogue() {
        TalkToNpcState talkToNpcState = this.talkToNpcViewModel.getState();

        if (talkToNpcState.hasNextDialogue()) {
            talkToNpcState.setCurrentDialogueIndex(talkToNpcState.getCurrentDialogueIndex() + 1);
        }

        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // We're assuming that this never fails.
    }

    @Override
    public void switchToMerchantView() {
//        this.viewManagerModel.setState(merchantViewModel.getViewName());
//        this.viewManagerModel.firePropertyChanged();
//         Update this later when merchant view is implemented
    }

    @Override
    public void exitInteraction() {
        final RoomDefaultState roomDefaultState = roomDefaultViewModel.getState();
        this.roomDefaultViewModel.setState(roomDefaultState);
        this.roomDefaultViewModel.firePropertyChanged();

        this.viewManagerModel.setState(roomDefaultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
