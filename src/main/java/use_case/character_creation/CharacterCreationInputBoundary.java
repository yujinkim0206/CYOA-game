package use_case.character_creation;

/**
 * Input Boundary for actions which are related to creating the character.
 */
public interface CharacterCreationInputBoundary {

    /**
     * Executes the Character Creation use case (class/race descriptions).
     * @param CharacterCreationInputData the input data
     */
    void execute(CharacterCreationInputData CharacterCreationInputData);

    /**
     * Executes the Character Creation use case (go to dungeon).
     */
    void execute();
}
