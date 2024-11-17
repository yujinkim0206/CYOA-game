package use_case.pickup_item;

/**
 * Input Boundary for actions related to picking up an item.
 */
public interface PickUpItemInputBoundary {
    /**
     * Executes the PickUp Item Use Case.
     * @param inputData the input data
     */
    void execute(PickUpItemInputData inputData);
}
