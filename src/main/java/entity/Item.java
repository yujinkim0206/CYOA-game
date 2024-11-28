package entity;

import java.util.Random;

public class Item {

    private final String name;
    private final String category;
    private final String rarity;

    /**
     * Constructor for an Item.
     *
     * @param name     the name of the item
     * @param category the category of the item
     * @param rarity   the rarity of the item
     */
    public Item(String name, String category, String rarity) {
        this.name = name;
        this.category = category;
        this.rarity = rarity;
    }

    /**
     * Generates a random item.
     *
     * @return a randomly generated item (Weapon, Armor, or Buff)
     */
    public static Item generateRandomItem() {
        Random random = new Random();

        // Rarities
        String[] rarities = {"Common", "Rare", "Epic", "Legendary"};
        String rarity = rarities[random.nextInt(rarities.length)];

        // Categories
        int type = random.nextInt(3); // 0 = Weapon, 1 = Armor, 2 = Buff
        switch (type) {
            case 0:
                return new Weapon("Sword of Valor", rarity, random.nextInt(50) + 10); // Random damage
            case 1:
                return new Armor("Shield of Fortitude", rarity, random.nextInt(20) + 5); // Random armor value
            case 2:
                return new Buff("Potion of Healing", rarity, random.nextInt(20) + 10); // Random healing value
            default:
                throw new IllegalStateException("Unexpected item type: " + type);
        }
    }

    /**
     * Gets the name of the item.
     *
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the category of the item.
     *
     * @return the item's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the rarity of the item.
     *
     * @return the item's rarity
     */
    public String getRarity() {
        return rarity;
    }
}
