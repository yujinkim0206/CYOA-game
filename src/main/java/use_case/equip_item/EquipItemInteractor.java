package use_case.equip_item;

import entity.Item;

/**
 * Interactor for the Equip Item Use Case.
 */
public class EquipItemInteractor implements EquipItemInputBoundary {
    private final EquipItemDataAccessInterface EquipItemDataAccessObject;
    private final EquipItemOutputBoundary presenter;

    /**
     * Constructor for EquipItemInteractor.
     *
     * @param dataAccessObject the DAO for accessing and updating inventory
     * @param presenter the output boundary for preparing views
     */
    public EquipItemInteractor(EquipItemDataAccessInterface dataAccessObject,
                               EquipItemOutputBoundary presenter) {
        this.EquipItemDataAccessObject = dataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(EquipItemInputData inputData) {
        Item itemToEquip = inputData.getItem();

        if (itemToEquip == null) {
            presenter.prepareFailView("No item selected to equip.");
            return;
        }

        String resultMessage = EquipItemDataAccessObject.equipItem(itemToEquip);

        if (resultMessage.startsWith("Equipped")) {
            presenter.prepareSuccessView(new EquipItemOutputData(itemToEquip.getName(), resultMessage));
        } else {
            presenter.prepareFailView(resultMessage);
        }
    }
}
