package interface_adapter.character_creation;

import interface_adapter.ViewModel;

/**
 * The View Model for the Open Inventory View.
 */
public class CharacterCreationViewModel extends ViewModel<CharacterCreationState> {

    public CharacterCreationViewModel() {
        super("character creation");
        setState(new CharacterCreationState());
    }

}
