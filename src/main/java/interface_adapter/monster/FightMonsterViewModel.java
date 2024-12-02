package interface_adapter.monster;

import interface_adapter.ViewModel;

/**
 * The View Model for the Fight Monster View.
 */
public class FightMonsterViewModel extends ViewModel<FightMonsterState> {

    public FightMonsterViewModel() {
        super("monster");
        setState(new FightMonsterState());
    }

}
