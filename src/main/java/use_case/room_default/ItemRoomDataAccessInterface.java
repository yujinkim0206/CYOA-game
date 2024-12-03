package use_case.room_default;

import entity.Item;
import entity.ItemRoom;

/**
 * Interface for data access operations related to ItemRoom.
 */
public interface ItemRoomDataAccessInterface {
    /**
     * Retrieves the description of the ItemRoom.
     *
     * @param itemRoom the ItemRoom instance
     * @return the description of the ItemRoom
     */
    String getRoomDescription(ItemRoom itemRoom);

    /**
     * Retrieves the item details from the ItemRoom.
     *
     * @param itemRoom the ItemRoom instance
     * @return the item from the room
     */
    Item getItem(ItemRoom itemRoom);

    /**
     * Removes the item from the ItemRoom.
     *
     * @param itemRoom the ItemRoom instance
     */
    void removeItem(ItemRoom itemRoom);
}
