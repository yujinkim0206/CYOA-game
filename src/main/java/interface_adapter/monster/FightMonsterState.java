package interface_adapter.monster;

/**
 * State for the Fight Monster Use Case.
 */
public class FightMonsterState {
    public int health = 100;

    /**
     * Hit the monster.
     * @return damage
     */
    public int hit() {
        final int damage = (int) (Math.random() * 10) + 1;
        this.health -= damage;
        return damage;
    }
}
