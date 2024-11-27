package interface_adapter.monster;

public class FightMonsterState {
    public int health = 100;

    public int hit() {
        int damage = (int)(Math.random() * 10) + 1;
        this.health -= damage;
        return damage;
    }
}
