package interface_adapter.fall_for_trap;

import use_case.fall_for_trap.FallForTrapInputBoundary;
import use_case.fall_for_trap.FallForTrapInputData;

/**
 * The controller for the Fall For Trap Use Case.
 */
public class FallForTrapController {

    private final FallForTrapInputBoundary fallForTrapUseCaseInteractor;

    public FallForTrapController(FallForTrapInputBoundary fallForTrapUseCaseInteractor) {
        this.fallForTrapUseCaseInteractor = fallForTrapUseCaseInteractor;
    }

    /**
     * Executes the Fall For Trap Use Case.
     */
    public void execute() {
        fallForTrapUseCaseInteractor.execute();
    }

    public void exitInteraction() {
        fallForTrapUseCaseInteractor.exitInteraction();
    }
}
