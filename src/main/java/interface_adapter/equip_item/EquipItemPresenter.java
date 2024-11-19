package interface_adapter.equip_item;

import interface_adapter.ViewManagerModel;
import use_case.equip_item.EquipItemOutputBoundary;
import use_case.equip_item.EquipItemOutputData;

/**
 * The Presenter for the Equip Item Use Case.
 */
public class EquipItemPresenter implements EquipItemOutputBoundary {

    private EquipItemViewModel equipItemViewModel;
    private ViewManagerModel viewManagerModel;

    public EquipItemPresenter(ViewManagerModel viewManagerModel,
                              EquipItemViewModel equipItemViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.equipItemViewModel = equipItemViewModel;
    }

    @Override
    public void prepareSuccessView(EquipItemOutputData response) {
        equipItemViewModel.updateInventory(response.getUpdatedInventory());
        viewManagerModel.setState(equipItemViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Handle errors appropriately
    }
}
