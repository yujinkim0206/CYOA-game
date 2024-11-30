package use_case.fall_for_trap;

import entity.Trap;

/**
 * The Fall For Trap Interactor.
 */
public class FallForTrapInteractor implements FallForTrapInputBoundary{
    private FallForTrapDataAccessInterface fallForTrapDataAccessObject;
    private FallForTrapOutputBoundary fallForTrapPresenter;

    public FallForTrapInteractor(FallForTrapDataAccessInterface fallForTrapDataAccessInterface,
                                 FallForTrapOutputBoundary fallForTrapOutputBoundary) {
        this.fallForTrapDataAccessObject = fallForTrapDataAccessInterface;
        this.fallForTrapPresenter = fallForTrapOutputBoundary;
    }

    @Override
    public void execute() {
        fallForTrapDataAccessObject.loadTraps();
        Trap trap = fallForTrapDataAccessObject.generateRandomTrap();
        fallForTrapDataAccessObject.setCurrentTrapName(trap.getName());
        //trapRoom.setTrap(trap);

        final FallForTrapOutputData fallForTrapOutputData = new FallForTrapOutputData(
                trap.getName(),
                trap.getDamage()
        );

        fallForTrapPresenter.prepareSuccessView(fallForTrapOutputData);
    }

    @Override
    public void exitInteraction() {
        fallForTrapPresenter.exitInteraction();
    }
}
