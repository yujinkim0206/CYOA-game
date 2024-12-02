package use_case.monster;

/**
 * Input Boundary Interface for Fight Monsters Use Case.
 */
public interface FightMonsterInputBoundary {
    /**
     * Execute method.
     * @param FightMonsterInputData input data
     */
    void execute(FightMonsterInputData FightMonsterInputData);

    /**
     * Hit method.
     * @param FightMonsterInputData input data
     */
    void hit(FightMonsterInputData FightMonsterInputData);
}
