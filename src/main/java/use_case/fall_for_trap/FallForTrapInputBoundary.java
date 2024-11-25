package use_case.fall_for_trap;

/**
 * Input Boundary for actions which are related to falling for trap.
 */
public interface FallForTrapInputBoundary {

    /**
     * Executes the fall for trap use case.
     * @param fallForTrapInputData the input data
     */
    void execute(FallForTrapInputData fallForTrapInputData);
}
