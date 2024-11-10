
package java.entity;

/**
 * Factory for creating Inventory.
 */
public class InventoryFactory {

    /**
     * Creates a new Inventory.
     * @return the new Inventory
     */
    public Inventory create() {
        return new Inventory();
    }
}
