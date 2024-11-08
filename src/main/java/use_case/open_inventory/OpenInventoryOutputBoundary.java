package use_case.open_inventory;

/**
 * The output boundary for the Open Inventory Use Case.
 */
public interface OpenInventoryOutputBoundary {
    /**
     * Prepares the success view for the Open Inventory Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(OpenInventoryOutputData outputData);

    /**
     * Prepares the failure view for the Open Inventory Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
