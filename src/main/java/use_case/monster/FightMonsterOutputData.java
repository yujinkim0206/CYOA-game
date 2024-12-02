package use_case.monster;

/**
 * The Output Data for the Fight Monsters Use case.
 */
public class FightMonsterOutputData {
    private boolean useCaseFailed;

    public FightMonsterOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
