package use_case.fall_for_trap;

/**
 * The output boundary for the Fall For Trap Use Case.
 */
public interface FallForTrapOutputBoundary {

    /**
     * Prepares the success view for the Fall For Trap Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(FallForTrapOutputData outputData);

    void exitInteraction();
}
