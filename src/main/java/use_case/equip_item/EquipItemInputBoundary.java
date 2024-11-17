package use_case.equip_item;

/**
 * Input Boundary for actions related to equipping an item.
 */
public interface EquipItemInputBoundary {
    /**
     * Executes the Equip Item Use Case.
     * @param inputData the input data
     */
    void execute(EquipItemInputData inputData);
}
