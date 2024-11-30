package entity;

/**
 * Armor increases health and defense.
 */
public class Armor extends Item {
    private final int ArmorBoost;

    public Armor(String name, String rarity, int armorboost) {
        super(name, "Armor", rarity); // Set category as "Armor"
        this.ArmorBoost = armorboost;
    }

    public void applyEffect(Player player) {
        player.increaseHealthLimit(ArmorBoost);
        player.increaseArmor(ArmorBoost);
    }

    public int getArmorBoost() {
        return ArmorBoost;
    }
}
