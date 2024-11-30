package interface_adapter.equip_item;

/**
 * The state for the Equip Item View Model.
 * Holds data related to the current state of the Equip Item View.
 */
public class EquipItemState {
    private String[] inventory; // Represents items in slots (e.g., Armor, Weapon, Buff)
    private String error;       // Holds any error message for the view
    private String message;     // Holds success messages for the view

    /**
     * Gets the current inventory.
     *
     * @return the inventory
     */
    public String[] getInventory() {
        return inventory;
    }

    /**
     * Sets the inventory.
     *
     * @param inventory the inventory to set
     */
    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets the current error message.
     *
     * @return the error message
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message.
     *
     * @param error the error message to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Gets the current success message.
     *
     * @return the success message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the success message.
     *
     * @param message the success message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
