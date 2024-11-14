package use_case.character_creation;

/**
 * The Character Creation Interactor.
 */
public class CharacterCreationInteractor implements CharacterCreationInputBoundary {
    private CharacterCreationDataAccessInterface characterDataAccessObject;
    private CharacterCreationOutputBoundary characterCreationPresenter;

    public CharacterCreationInteractor(CharacterCreationDataAccessInterface characterDataAccessInterface,
                                   CharacterCreationOutputBoundary characterCreationOutputBoundary) {
        this.characterDataAccessObject = characterDataAccessInterface;
        this.characterCreationPresenter = characterCreationOutputBoundary;
    }

    @Override
    public void execute(CharacterCreationInputData characterCreationInputData) {

        // This code has not been written yet.

        final CharacterCreationOutputData characterCreationOutputData = new CharacterCreationOutputData(false);
        characterCreationPresenter.prepareSuccessView(characterCreationOutputData);
    }
}

