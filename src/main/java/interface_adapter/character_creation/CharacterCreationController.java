package interface_adapter.character_creation;

import use_case.character_creation.CharacterCreationInputBoundary;
import use_case.character_creation.CharacterCreationInputData;

/**
 * The controller for the Character Creation Use Case.
 */
public class CharacterCreationController {

    private CharacterCreationInputBoundary characterCreationUseCaseInteractor;

    public CharacterCreationController(CharacterCreationInputBoundary characterCreationUseCaseInteractor) {
        this.characterCreationUseCaseInteractor = characterCreationUseCaseInteractor;
    }

    /**
     * Executes the Character Creation Use Case.
     */
    public void execute() {
        final CharacterCreationInputData characterCreationInputData = new CharacterCreationInputData();
        characterCreationUseCaseInteractor.execute(characterCreationInputData);
    }
}
