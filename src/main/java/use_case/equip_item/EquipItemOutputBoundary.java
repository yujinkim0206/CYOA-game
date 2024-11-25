package use_case.equip_item;

/**
 * The output boundary for the Equip Item Use Case.
 */
public interface EquipItemOutputBoundary {
    void prepareSuccessView(EquipItemOutputData outputData);
    void prepareFailView(String errorMessage);
}
