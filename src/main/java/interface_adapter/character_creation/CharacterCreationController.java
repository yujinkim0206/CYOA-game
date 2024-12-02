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
     * Executes the Character Creation Use Case to update the class or race.
     * @param pClass the class button the user selected
     * @param pRace the race button the user selected
     */
    public void execute(String pClass, String pRace) {
        final CharacterCreationInputData characterCreationInputData = new CharacterCreationInputData(pClass, pRace);
        characterCreationUseCaseInteractor.execute(characterCreationInputData);
    }

    /**
     * Executes the Character Creation Use Case to move to the next view.
     */
    public void execute() {
        characterCreationUseCaseInteractor.execute();
    }
}
