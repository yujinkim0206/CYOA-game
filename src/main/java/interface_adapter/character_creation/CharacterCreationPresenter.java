package interface_adapter.character_creation;

import interface_adapter.ViewManagerModel;
//import interface_adapter.room_default.RoomDefaultState;
//import interface_adapter.room_default.RoomDefaultViewModel;
//import use_case.open_inventory.OpenInventoryOutputBoundary;
//import use_case.open_inventory.OpenInventoryOutputData;
import use_case.character_creation.CharacterCreationOutputBoundary;
import use_case.character_creation.CharacterCreationOutputData;

/**
 * The Presenter for the Open Inventory Use Case.
 */
public class CharacterCreationPresenter implements CharacterCreationOutputBoundary {
                    //TODO fix this later
//    private OpenInventoryViewModel openInventoryViewModel; // Would be used for fail view when implemented
    private ViewManagerModel viewManagerModel;
//    private RoomDefaultViewModel roomDefaultViewModel;

    public CharacterCreationPresenter(ViewManagerModel viewManagerModel
                          /* OpenInventoryViewModel openInventoryViewModel,
                          RoomDefaultViewModel roomDefaultViewModel */) {
//        this.openInventoryViewModel = openInventoryViewModel;
        this.viewManagerModel = viewManagerModel;
//        this.roomDefaultViewModel = roomDefaultViewModel;
    }

    @Override
    public void prepareSuccessView(CharacterCreationOutputData response) {
//        final RoomDefaultState roomDefaultState = roomDefaultViewModel.getState();
//        this.roomDefaultViewModel.setState(roomDefaultState);
//        this.roomDefaultViewModel.firePropertyChanged();

//        this.viewManagerModel.setState(/* roomDefaultViewModel.getViewName() */);
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // TODO this fails when the user has not selected both a class and a race
    }

    @Override
    public void getDescription(String pClassDescription, String pRaceDescription) {
        // TODO write this
    }
}
