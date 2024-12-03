package interface_adapter.monster;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultState;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.monster.FightMonsterOutputBoundary;
import use_case.monster.FightMonsterOutputData;

/**
 * The Presenter for the Fight Monster Use Case.
 */
public class FightMonsterPresenter implements FightMonsterOutputBoundary {
    private FightMonsterViewModel fightMonsterViewModel;
    private ViewManagerModel viewManagerModel;
    private RoomDefaultViewModel roomDefaultViewModel;

    public FightMonsterPresenter(FightMonsterViewModel fightMonsterViewModel,
                                 ViewManagerModel viewManagerModel,
                                 RoomDefaultViewModel roomDefaultViewModel) {
        this.fightMonsterViewModel = fightMonsterViewModel;
        this.viewManagerModel = viewManagerModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
    }

    /**
     * Prepares the success view.
     * @param outputData the output data
     */
    public void prepareSuccessView(FightMonsterOutputData outputData) {
        final RoomDefaultState roomDefaultState = roomDefaultViewModel.getState();
        this.roomDefaultViewModel.setState(roomDefaultState);
        this.roomDefaultViewModel.firePropertyChanged();

        this.viewManagerModel.setState(roomDefaultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the hit view.
     * @param outputData the output data
     */
    public void prepareHitView(FightMonsterOutputData outputData) {
        final FightMonsterState fightMonsterState = fightMonsterViewModel.getState();
        fightMonsterState.hit();
        this.fightMonsterViewModel.setState(fightMonsterState);
        this.fightMonsterViewModel.firePropertyChanged();

        this.viewManagerModel.setState(fightMonsterViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
    }
}
