package use_case.monster;

public interface FightMonsterInputBoundary  {
    void execute(FightMonsterInputData FightMonsterInputData);

    void hit(FightMonsterInputData FightMonsterInputData);
}
