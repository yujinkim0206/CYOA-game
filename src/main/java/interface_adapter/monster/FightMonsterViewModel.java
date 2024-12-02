package interface_adapter.monster;

import interface_adapter.ViewModel;

/**
 * View Model for the Fight Monster Use Case.
 */
public class FightMonsterViewModel extends ViewModel<FightMonsterState> {

    public FightMonsterViewModel() {
        super("monster");
        setState(new FightMonsterState());
    }

}
