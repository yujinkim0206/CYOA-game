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
        // Data Access Object (if needed later)
        // final Inventory inventory = userDataAccessObject.get(openInventoryInputData.get___());

        // For now, this code will always prepare success when requesting the inventory.
        // Probably in the future this will be modified to only accept the command when on the correct view, but since
        // that view does not exist at the moment of writing this, for now it will always work.
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
