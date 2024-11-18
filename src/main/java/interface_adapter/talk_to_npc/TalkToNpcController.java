package interface_adapter.talk_to_npc;

import use_case.talk_to_npc.TalkToNpcInputBoundary;
import use_case.talk_to_npc.TalkToNpcInputData;

public class TalkToNpcController {

    private final TalkToNpcInputBoundary talkToNpcUseCaseInteractor;

    public TalkToNpcController(TalkToNpcInputBoundary talkToNpcUseCaseInteractor) {
        this.talkToNpcUseCaseInteractor = talkToNpcUseCaseInteractor;
    }

    /**
     * Executes the Talk To Npc Use Case.
     */
    public void execute() {
        final TalkToNpcInputData talkToNpcInputData = new TalkToNpcInputData();
        talkToNpcUseCaseInteractor.execute(talkToNpcInputData);
    }
}
