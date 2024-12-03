package data_access;

import entity.Item;
import entity.ItemRoom;
import use_case.room_default.ItemRoomDataAccessInterface;

/**
 * Implementation of ItemRoomDataAccessInterface.
 */
public class ItemRoomDataAccessObject implements ItemRoomDataAccessInterface {

    @Override
    public String getRoomDescription(ItemRoom itemRoom) {
        return itemRoom.getDescription();
    }

    @Override
    public Item getItem(ItemRoom itemRoom) {
        return itemRoom.getItem();
    }

    @Override
    public void removeItem(ItemRoom itemRoom) {
        itemRoom.setItem(null);
    }
}
