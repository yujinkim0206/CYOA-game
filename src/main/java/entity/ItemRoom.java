package entity;

public class ItemRoom extends Room {
    private final Item item; // Single item in the room

    /**
     * Creates an ItemRoom with a single item.
     *
     * @param item the item in the room
     */
    public ItemRoom(Item item) {
        this.item = item;
    }

    /**
     * Gets the item in the room.
     *
     * @return the item
     */
    @Override
    public Item getItem() {
        return item;
    }

    /**
     * Interaction logic for the ItemRoom.
     * Displays the item's name, category, and rarity.
     */
    public void interact() {
        if (item != null) {
            System.out.println("You see an item: " + item.getName() + " [" + item.getCategory() + " - " + item.getRarity() + "]");
        } else {
            System.out.println("This room is empty. (Unexpected state)");
        }
    }
}
