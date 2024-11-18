package interface_adapter.talk_to_npc;

import interface_adapter.ViewManagerModel;
import interface_adapter.fall_for_trap.FallForTrapViewModel;
import interface_adapter.room_default.RoomDefaultState;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.fall_for_trap.FallForTrapOutputData;
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
        // On success, switch to the room default view.

        final RoomDefaultState roomDefaultState = roomDefaultViewModel.getState();
        this.roomDefaultViewModel.setState(roomDefaultState);
        this.roomDefaultViewModel.firePropertyChanged();

        this.viewManagerModel.setState(roomDefaultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // We're assuming that this never fails.
    }
}
