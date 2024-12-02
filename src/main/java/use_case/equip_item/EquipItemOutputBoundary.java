package use_case.equip_item;

/**
 * The output boundary for the Equip Item Use Case.
 */
public interface EquipItemOutputBoundary {
    /**
     * Prepares the success view.
     * @param outputData output data
     */
    void prepareSuccessView(EquipItemOutputData outputData);

    /**
     * Prepares the fail view.
     * @param errorMessage error message
     */
    void prepareFailView(String errorMessage);
}
