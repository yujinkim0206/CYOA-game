package use_case.monster;

public class FightMonsterOutputData {
    private boolean useCaseFailed;

    public FightMonsterOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
