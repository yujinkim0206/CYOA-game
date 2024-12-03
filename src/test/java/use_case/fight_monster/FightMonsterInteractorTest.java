package use_case.fight_monster;

import data_access.FightMonsterDataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.monster.*;

import static org.junit.jupiter.api.Assertions.fail;

public class FightMonsterInteractorTest {

    @Test
    void successTest() {
        FightMonsterInputData inputData = new FightMonsterInputData();
        FightMonsterDataAccessInterface monsterRepo = new FightMonsterDataAccessObject();

        FightMonsterOutputBoundary successPresenter = new FightMonsterOutputBoundary() {
            int monsterId = 1;
            @Override
            public void prepareSuccessView(FightMonsterOutputData outputData) {
                System.out.println("good");
            }
            @Override
            public void prepareFailView(String message) {
                fail("Failure with a 'fail' call is unexpected");
            }
            @Override
            public void prepareHitView(FightMonsterOutputData outputData) {
                System.out.println("good");
            }
        };
        FightMonsterInputBoundary interactor = new FightMonsterInteractor(monsterRepo, successPresenter);
        interactor.hit(inputData);
        interactor.execute(inputData);
    }
}
