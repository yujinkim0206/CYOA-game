package interface_adapter.pickup_item;

import javax.swing.JOptionPane;

import interface_adapter.ViewManagerModel;
import use_case.pickup_item.PickUpItemOutputBoundary;
import use_case.pickup_item.PickUpItemOutputData;

/**
 * Presenter for the Pick-Up Item Use Case.
 */
public class PickUpItemPresenter implements PickUpItemOutputBoundary {
    private final PickUpItemViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public PickUpItemPresenter(PickUpItemViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(PickUpItemOutputData response) {
        System.out.println("[DEBUG] Presenter updated ViewModel with item: " + response.getItemName());
        viewModel.updateItems(response.getItemName());
        viewModel.setMessage(response.getMessage());
        viewManagerModel.setState(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println("[DEBUG] Preparing fail view with error: " + error);
        viewModel.setError(error);
        viewManagerModel.setState("room view"); // Navigate back to the room view
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void clearItemState() {
        viewModel.clearItem(); // Clear the state in the view model
        viewManagerModel.setState(viewModel.getViewName()); // Ensure the view remains in PickUpItemView
        viewManagerModel.firePropertyChanged(); // Notify the UI to refresh
        System.out.println("[DEBUG] Cleared item state in ViewModel.");
    }





}
