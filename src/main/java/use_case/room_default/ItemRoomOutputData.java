package use_case.room_default;

/**
 * Represents the output data for an item room.
 * This includes information about the item present in the room, such as its name, rarity, and category.
 */
public class ItemRoomOutputData extends RoomOutputData {
    private final String itemName;
    private final String rarity;
    private final String category;

    /**
     * Constructs an ItemRoomOutputData object with the given details.
     *
     * @param roomDescription the description of the room
     * @param itemName        the name of the item in the room
     * @param rarity          the rarity of the item
     * @param category        the category of the item
     */
    public ItemRoomOutputData(String roomDescription, String itemName, String rarity, String category) {
        super(roomDescription, "ItemRoom");
        this.itemName = itemName;
        this.rarity = rarity;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public String getRarity() {
        return rarity;
    }

    public String getCategory() {
        return category;
    }
}
