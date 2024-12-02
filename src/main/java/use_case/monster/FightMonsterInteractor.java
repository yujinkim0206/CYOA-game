package use_case.monster;

/**
 * Interactor for the Fight Monsters Use Case.
 */
public class FightMonsterInteractor implements FightMonsterInputBoundary {
    private FightMonsterDataAccessInterface fightMonsterDataAccessInterface;
    private FightMonsterOutputBoundary fightMonsterOutputBoundary;

    public FightMonsterInteractor(
            FightMonsterDataAccessInterface dataAccessInterface, FightMonsterOutputBoundary outputBoundary) {
        this.fightMonsterDataAccessInterface = dataAccessInterface;
        this.fightMonsterOutputBoundary = outputBoundary;
    }

    /**
     * Execute method.
     * @param openInventoryInputData input data
     */
    public void execute(FightMonsterInputData openInventoryInputData) {
        final FightMonsterOutputData openInventoryOutputData = new FightMonsterOutputData(false);
        fightMonsterOutputBoundary.prepareSuccessView(openInventoryOutputData);
    }

    /**
     * Hit method.
     * @param openInventoryInputData input data
     */
    public void hit(FightMonsterInputData openInventoryInputData) {
        final FightMonsterOutputData openInventoryOutputData = new FightMonsterOutputData(false);
    }
}
