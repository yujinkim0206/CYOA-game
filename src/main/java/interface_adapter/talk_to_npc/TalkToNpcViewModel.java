package interface_adapter.talk_to_npc;

import interface_adapter.ViewModel;

/**
 * The View Model for the Talk To NPC view.
 */
public class TalkToNpcViewModel extends ViewModel<TalkToNpcState> {

    public TalkToNpcViewModel() {
        super("talk to npc");
        setState(new TalkToNpcState());
    }
}
