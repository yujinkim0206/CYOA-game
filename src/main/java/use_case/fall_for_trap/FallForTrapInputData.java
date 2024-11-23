package use_case.fall_for_trap;

/**
 * The input data for the Fall For Trap Use Case.
 */
public class FallForTrapInputData {
    private String name;
    private int damage;
    private int difficulty;

    public FallForTrapInputData(String name, int damage, int difficulty) {
        this.name = name;
        this.damage = damage;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
