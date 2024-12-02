package entity;

/**
 * Buff restores health or provides temporary bonuses.
 */
public class Buff extends Item {
    private final int healthRestoration;

    public Buff(String name, String rarity, int healthRestoration) {
        // Set category as "Buff"
        super(name, "Buff", rarity);
        this.healthRestoration = healthRestoration;
    }

    /**
     * Apply the effect to the player.
     * @param player the player to apply the effect to
     */
    public void applyEffect(Player player) {
        player.increaseHealthRegeneration(healthRestoration);
    }

    public int getHealthRestoration() {
        return healthRestoration;
    }
}

