package entity;

/**
 * Weapon increases attack power.
 */
public class Weapon extends Item {
    private final int attackBoost;

    public Weapon(String name, String rarity, int attackBoost) {
        super(name, "Weapon", rarity);
        this.attackBoost = attackBoost;
    }

    /**
     * Apply the effect to the given player.
     * @param player player to apply the effect to
     */
    public void applyEffect(Player player) {
        player.increaseDamage(attackBoost);
    }

    public int getAttackBoost() {
        return attackBoost;
    }
}
