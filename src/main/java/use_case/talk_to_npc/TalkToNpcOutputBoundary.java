package use_case.talk_to_npc;

/**
 * The output boundary for the Talk To Npc Use Case.
 */
public interface TalkToNpcOutputBoundary {

    /**
     * Prepares the success view for the Talk To Npc Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(TalkToNpcOutputData outputData);

    /**
     * Prepares the failure view for the Talk To Npc Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
