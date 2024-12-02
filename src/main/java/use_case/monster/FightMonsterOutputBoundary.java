package use_case.monster;

/**
 * Output Boundary for Fight Monsters Use Case.
 */
public interface FightMonsterOutputBoundary {

    /**
     * Prepares the success view for the Fight Monster Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(FightMonsterOutputData outputData);

    /**
     * Prepares the failure view for the Fight Monster Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Prepares the Hit view for the fight monsters use case.
     * @param outputData the output data
     */
    void prepareHitView(FightMonsterOutputData outputData);
}
