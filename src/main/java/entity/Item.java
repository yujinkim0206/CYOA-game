package entity;

import java.util.Random;

/**
 * Item entity.
 */
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
     * @return a randomly generated item (Weapon, Armor, or Buff)
     * @throws IllegalStateException on unexpected item type
     */
    public static Item generateRandomItem() {
        final Random random = new Random();

        // Item to be returned
        final Item item;

        // Rarities and their quality ranges
        final String common = "Common";
        final String rare = "Rare";
        final String epic = "Epic";
        final String legendary = "Legendary";
        final String[] rarities = {common, rare, epic, legendary};
        final int rarityIndex = random.nextInt(rarities.length);
        final String rarity = rarities[rarityIndex];
        final String unexpectedString = "Unexpected rarity: " + rarity;

        // 0 = Weapon, 1 = Armor, 2 = Buff
        final int type = random.nextInt(3);

        // Weapon
        if (type == 0) {
            final int bound = 10;
            final int range;
            final String name;
            switch (rarity) {
                case common:
                    name = "Common Sword";
                    range = 1;
                    break;
                case rare:
                    name = "Rare Blade";
                    range = 11;
                    break;
                case epic:
                    name = "Epic Greatsword";
                    range = 21;
                    break;
                case legendary:
                    name = "Legendary Excalibur";
                    range = 31;
                    break;
                default:
                    throw new IllegalStateException(unexpectedString);
            }
            item = new Weapon(name, rarity, random.nextInt(bound) + range);
        }
        // Armor
        else if (type == 1) {
            final int bound = 5;
            final int range;
            final String name;
            switch (rarity) {
                case common:
                    name = "Common Shield";
                    range = 1;
                    break;
                case rare:
                    name = "Rare Breastplate";
                    range = 6;
                    break;
                case epic:
                    name = "Epic Helm";
                    range = 11;
                    break;
                case legendary:
                    name = "Legendary Aegis";
                    range = 16;
                    break;
                default:
                    throw new IllegalStateException(unexpectedString);
            }
            item = new Armor(name, rarity, random.nextInt(bound) + range);
        }
        // Buff (type == 2)
        else {
            final int bound = 5;
            final int range;
            final String name;
            switch (rarity) {
                case common:
                    name = "Common Health Potion";
                    range = 3;
                    break;
                case rare:
                    name = "Rare Potion";
                    range = 8;
                    break;
                case epic:
                    name = "Epic Regeneration Potion";
                    range = 13;
                    break;
                case legendary:
                    name = "Legendary Vitality Potion";
                    range = 19;
                    break;
                default:
                    throw new IllegalStateException(unexpectedString);
            }
            item = new Buff(name, rarity, random.nextInt(bound) + range);
        }

        return item;
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
