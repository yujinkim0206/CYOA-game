package use_case.character_creation;

/**
 * Output Data for the Character Creation Use Case.
 */
public class CharacterCreationOutputData {

    private boolean useCaseFailed;

    public CharacterCreationOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
