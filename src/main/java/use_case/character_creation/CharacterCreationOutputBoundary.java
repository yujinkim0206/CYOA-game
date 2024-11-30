package use_case.character_creation;

/**
 * The output boundary for the Character Creation Use Case.
 */
public interface CharacterCreationOutputBoundary {
    /**
     * Prepares the success view for the Character Creation Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(CharacterCreationOutputData outputData);

    /**
     * Prepares the failure view for the Character Creation Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Fetches the description of the class/race from the API call (in the interactor).
     * @param pClassDescription the class description
     * @param pRaceDescription the race description
     */
    void getDescription(String pClassDescription, String pRaceDescription);
}
