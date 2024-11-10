package entity;

public class ItemRoom extends Room{

    private Item item;

    /**
     * Creates an ItemRoom
     * @param item the item in the ItemRoom
     */

    public ItemRoom(Item item){
        this.item = item;
    }

    /**
     * Returns the item in the ItemRoom
     * @return the item in ItemRoom
     */

    public Item getItem() {
        return item;
    }

    /**
     * Allows us to set the item in the ItemRoom
     * @param item the item we want to set inside the ItemRoom
     */

    public void setItem(Item item) {
        this.item = item;
    }
}
