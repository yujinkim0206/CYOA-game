package use_case.fall_for_trap;

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
    public void execute(FallForTrapInputData fallForTrapInputData) {
        final String name = fallForTrapInputData.getName();
        final int damage = fallForTrapInputData.getDamage();
        final int difficulty = fallForTrapInputData.getDifficulty();

        fallForTrapDataAccessObject.setCurrentTrapName(fallForTrapInputData.getName());

        final FallForTrapOutputData fallForTrapOutputData = new FallForTrapOutputData(false);
        fallForTrapPresenter.prepareSuccessView(fallForTrapOutputData);
    }
}
