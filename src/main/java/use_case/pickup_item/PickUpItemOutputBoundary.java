package use_case.pickup_item;

/**
 * The output boundary for the PickUp Item Use Case.
 */
public interface PickUpItemOutputBoundary {
    void prepareSuccessView(PickUpItemOutputData outputData);
    void prepareFailView(String errorMessage);

}
