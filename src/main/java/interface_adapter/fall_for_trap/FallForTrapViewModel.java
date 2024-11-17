package interface_adapter.fall_for_trap;

import interface_adapter.ViewModel;

/**
 * The View Model for the Trap Fallen View.
 */
public class FallForTrapViewModel extends ViewModel<FallForTrapState> {

    public FallForTrapViewModel() {
        super("fall for trap");
        setState(new FallForTrapState());
    }

}
