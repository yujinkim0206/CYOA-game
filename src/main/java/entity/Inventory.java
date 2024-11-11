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

}
