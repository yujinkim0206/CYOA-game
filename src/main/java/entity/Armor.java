package entity;

/**
 * Armor increases health and defense.
 */
public class Armor extends Item {
    private final int armorBoost;

    public Armor(String name, String rarity, int armorboost) {
        // Set category as "Armor"
        super(name, "Armor", rarity);
        this.armorBoost = armorboost;
    }

    /**
     * Apply the effect to the player.
     * @param player the player to apply the effect to
     */
    public void applyEffect(Player player) {
        player.increaseHealthLimit(armorBoost);
        player.increaseArmor(armorBoost);
    }

    public int getArmorBoost() {
        return armorBoost;
    }
}
