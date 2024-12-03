package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The representation of an inventory that holds items.
 */
public class Inventory {

    // items is Map<String, List<Item>> instead of Map<String, Item> in order to allow duplicates.
    private final Map<String, List<Item>> items;
    private Item equippedArmor;
    private Item equippedWeapon;
    private Item equippedBuff;
    private Item armor;
    private Item weapon;
    private Item buff;

    public Inventory() {
        items = new HashMap<>();
    }

    /**
     * Returns a map containing all items in the inventory.
     *
     * @return a map containing all items in the inventory
     */
    public Map<String, List<Item>> getItems() {
        return items;
    }

    /**
     * Adds an item to the inventory, allowing duplicate items with the same name.
     *
     * @param name the name of the item to add
     * @param item the item to add
     */
    public void addItem(String name, Item item) {
        List<Item> itemList = items.get(name);

        if (itemList == null) {
            itemList = new ArrayList<>();
            items.put(name, itemList);
        }

        itemList.add(item);
    }

    /**
     * Removes an item from the inventory.
     *
     * @param name the name of the item to be removed
     * @return the item removed, or null if not found.
     */
    public Item removeItem(String name) {
        final List<Item> itemList = items.get(name);
        Item result = null;

        if (itemList != null && !itemList.isEmpty()) {
            result = itemList.remove(0);
        }

        return result;
    }

    /**
     * Returns an item from the inventory.
     *
     * @param name the name of the item
     * @return the item, or null if not found
     */
    public Item getItem(String name) {
        final List<Item> itemList = items.get(name);
        Item result = null;

        if (itemList != null && !itemList.isEmpty()) {
            result = itemList.get(0);
        }

        return result;
    }

    /**
     * Equips an item by type, replacing any currently equipped item of the same type.
     *
     * @param item the item to equip
     * @return true if the item was successfully equipped, false otherwise
     */
    public boolean equipItem(Item item) {
        boolean result = true;

        final String itemName = item.getName();
        if (!removeItem(itemName).equals(item)) {
            // Ensure the item is removed from inventory
            result = false;
        }

        if (item instanceof Armor) {
            equippedArmor = replaceEquippedItem(equippedArmor, item);
        }
        else if (item instanceof Weapon) {
            equippedWeapon = replaceEquippedItem(equippedWeapon, item);
        }
        else if (item instanceof Buff) {
            equippedBuff = replaceEquippedItem(equippedBuff, item);
        }
        else {
            // Unsupported item type
            result = false;
        }

        return result;
    }

    private Item replaceEquippedItem(Item currentEquipped, Item newItem) {
        if (currentEquipped != null) {
            // Return current item to inventory
            addItem(currentEquipped.getName(), currentEquipped);
        }
        return newItem;
    }

    /**
     * Getters and Setters for equipped items.
     * @return the equipped weapon
     */
    public Item getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Item weapon) {
        this.equippedWeapon = weapon;
    }

    public Item getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Item armor) {
        this.equippedArmor = armor;
    }

    public Item getEquippedBuff() {
        return equippedBuff;
    }

    public void setEquippedBuff(Item buff) {
        this.equippedBuff = buff;
    }

    /**
     * Returns a list of all items in the inventory, including duplicates.
     * @return a list of all items in the inventory, including duplicates.
     */
    public List<Item> getAllItems() {
        final List<Item> allItems = new ArrayList<>();
        for (List<Item> itemList : items.values()) {
            allItems.addAll(itemList);
        }
        return allItems;
    }

    /**
     * Getters and setters for equipped items
     */
    public Item getArmor() {
        return armor;
    }

    public void setArmor(Item armor) {
        this.armor = armor;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getBuff() {
        return buff;
    }

    public void setBuff(Item buff) {
        this.buff = buff;
    }
}
