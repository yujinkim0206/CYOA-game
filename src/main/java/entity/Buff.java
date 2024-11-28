package entity;

/**
 * Buff restores health or provides temporary bonuses.
 */
public class Buff extends Item {
    private final int healthRestoration;

    public Buff(String name, String rarity, int healthRestoration) {
        super(name, "Buff", rarity); // Set category as "Buff"
        this.healthRestoration = healthRestoration;
    }

    public void applyEffect(Player player) {
        player.increaseHealthRegeneration(healthRestoration);
    }

    public int getHealthRestoration() {
        return healthRestoration;
    }
}

