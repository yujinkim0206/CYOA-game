package interface_adapter.monster;

import interface_adapter.ViewModel;

public class FightMonsterViewModel extends ViewModel<FightMonsterState> {

    public FightMonsterViewModel() {
        super("monster");
        setState(new FightMonsterState());
    }

}
