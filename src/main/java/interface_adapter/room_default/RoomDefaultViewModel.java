package interface_adapter.room_default;

import interface_adapter.ViewModel;

/**
 * The View Model for the Room Default View.
 */
public class RoomDefaultViewModel extends ViewModel<RoomDefaultState> {

    public RoomDefaultViewModel() {
        super("room default");
        setState(new RoomDefaultState());
    }

}
