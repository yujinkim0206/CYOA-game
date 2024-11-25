package use_case.character_creation;

/**
 * Input Boundary for actions which are related to creating the character.
 */
public interface CharacterCreationInputBoundary {

    /**
     * Executes the Character Creation use case.
     * @param CharacterCreationInputData the input data
     */
    void execute(CharacterCreationInputData CharacterCreationInputData);
    void execute();
}
