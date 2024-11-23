package use_case.talk_to_npc;

/**
 * Output Data for the Talk To Npc Use Case.
 */
public class TalkToNpcOutputData {
    private final boolean useCaseFailed;

    public TalkToNpcOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }
}
