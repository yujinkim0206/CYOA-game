package interface_adapter.talk_to_npc;

import use_case.talk_to_npc.TalkToNpcInputBoundary;
import use_case.talk_to_npc.TalkToNpcInputData;

import java.util.List;

public class TalkToNpcController {

    private final TalkToNpcInputBoundary talkToNpcUseCaseInteractor;

    public TalkToNpcController(TalkToNpcInputBoundary talkToNpcUseCaseInteractor) {
        this.talkToNpcUseCaseInteractor = talkToNpcUseCaseInteractor;
    }

    /**
     * Executes the Talk To Npc Use Case.
     */
    public void execute(String name, String description, List<String> dialogue) {
        final TalkToNpcInputData talkToNpcInputData = new TalkToNpcInputData(name, description, dialogue);
        talkToNpcUseCaseInteractor.execute(talkToNpcInputData);
    }
}
