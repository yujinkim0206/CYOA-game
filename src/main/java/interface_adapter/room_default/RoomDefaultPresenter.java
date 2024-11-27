package interface_adapter.room_default;

import interface_adapter.ViewManagerModel;
import interface_adapter.monster.FightMonsterState;
import interface_adapter.monster.FightMonsterViewModel;
import use_case.room_default.RoomOutputBoundary;
import use_case.room_default.RoomOutputData;

/**
 * The Presenter for the Room Default Use Case.
 */
public class RoomDefaultPresenter implements RoomOutputBoundary {

    private final RoomDefaultViewModel roomDefaultViewModel;
    private final ViewManagerModel viewManagerModel;
    private final FightMonsterViewModel fightMonsterViewModel;

    public RoomDefaultPresenter(ViewManagerModel viewManagerModel, RoomDefaultViewModel roomDefaultViewModel, FightMonsterViewModel fightMonsterViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
        this.fightMonsterViewModel = fightMonsterViewModel;
    }

    @Override
    public void prepareSuccessView(RoomOutputData outputData) {
        RoomDefaultState currentState = roomDefaultViewModel.getState();

        currentState.setRoomDescription(outputData.getRoomDescription());
        currentState.setRoomContent(outputData.getRoomContent());

        roomDefaultViewModel.setState(currentState);
        roomDefaultViewModel.firePropertyChanged();
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        RoomDefaultState currentState = roomDefaultViewModel.getState();
        currentState.setErrorMessage(errorMessage);

        roomDefaultViewModel.setState(currentState);
        roomDefaultViewModel.firePropertyChanged();
        viewManagerModel.setState(roomDefaultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void prepareInteractView(RoomOutputData outputData) {
        final FightMonsterState fightMonsterState = fightMonsterViewModel.getState();
        this.fightMonsterViewModel.setState(fightMonsterState);
        this.fightMonsterViewModel.firePropertyChanged();

        this.viewManagerModel.setState(fightMonsterViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

