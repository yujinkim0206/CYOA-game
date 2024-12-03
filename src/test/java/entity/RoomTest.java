package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    // For item room here only
    private Item item;

    @BeforeEach
    public void setup() {
        item = new Item("Healing Potion", "Consumable", "Common"); // Example item
    }


    @Test
    public void testItemRoom() {
        ItemRoom room = new ItemRoom(4, item);
        int roomType = room.getRoomType();
        Item roomItem = room.getItem();

        assertEquals(1, roomType);

        assertEquals("Healing Potion", roomItem.getName());


        assertEquals("Room 4: This room contains an item [Healing Potion]", room.getDescription());
    }

    @Test
    public void testAbstractRoomWithNoItem() {

        AbstractRoom room = new AbstractRoom(5) {};

        int roomType = room.getRoomType();
        Item roomItem = room.getItem();

        assertEquals(-1, roomType);

        assertNull(roomItem);

        assertEquals("description", room.getDescription());
    }
}

