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
        characterDataAccessObject.setPclass(characterCreationInputData.getPclass());
        characterDataAccessObject.setPrace(characterCreationInputData.getPrace());

        String pClassDescription = characterDataAccessObject.getPClassDescription();
        String pRaceDescription = characterDataAccessObject.getPRaceDescription();

        characterCreationPresenter.getDescription(pClassDescription, pRaceDescription);
    }

    @Override
    public void execute() {
        if (characterDataAccessObject.getPclass() == null || characterDataAccessObject.getPrace() == null) {
            characterCreationPresenter.prepareFailView("Please Select Both a Class and a Race!");
        }
        else {
            final CharacterCreationOutputData characterCreationOutputData = new CharacterCreationOutputData(false);
            characterCreationPresenter.prepareSuccessView(characterCreationOutputData);
        }
    }
}

