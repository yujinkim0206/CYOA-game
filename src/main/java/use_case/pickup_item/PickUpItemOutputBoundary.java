package use_case.pickup_item;

/**
 * Output Boundary for the Pick-Up Item Use Case.
 */
public interface PickUpItemOutputBoundary {
    /**
     * Prepare the success view.
     * @param outputData output data
     */
    void prepareSuccessView(PickUpItemOutputData outputData);

    /**
     * Prepare the fail view.
     * @param errorMessage error message
     */
    void prepareFailView(String errorMessage);

    void clearItemState();
}
