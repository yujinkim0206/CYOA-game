package interface_adapter.talk_to_npc;

import interface_adapter.ViewModel;
import interface_adapter.talk_to_npc.TalkToNpcState;

/**
 * The View Model for the Trap Fallen View.
 */
public class TalkToNpcViewModel extends ViewModel<TalkToNpcState> {

    public TalkToNpcViewModel() {
        super("talk to npc");
        setState(new TalkToNpcState());
    }
}
