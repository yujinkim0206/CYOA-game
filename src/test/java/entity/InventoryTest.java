package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inventory;
    private Item sword;
    private Item shield;
    private Item healingPotion;

    @BeforeEach
    public void setup() {
        inventory = new Inventory();
        sword = new Weapon("Sword", "Common", 10);
        shield = new Armor("Shield", "Rare", 5);
        healingPotion = new Buff("Healing Potion", "Common", 5);
    }

    @Test
    public void testAddItem() {
        inventory.addItem(sword.getName(), sword);

        assertEquals(1, inventory.getItems().get(sword.getName()).size());

        inventory.addItem(sword.getName(), sword);
        assertEquals(2, inventory.getItems().get(sword.getName()).size());
    }

    @Test
    public void testRemoveItem() {
        inventory.addItem(sword.getName(), sword);

        Item removedItem = inventory.removeItem(sword.getName());

        assertEquals(sword, removedItem);

        assertNull(inventory.getItem(sword.getName()));
    }

    @Test
    public void testGetItem() {
        inventory.addItem(sword.getName(), sword);

        Item retrievedItem = inventory.getItem(sword.getName());

        assertEquals(sword, retrievedItem);
    }

    @Test
    public void testEquipWeapon() {
        inventory.addItem(sword.getName(), sword);

        boolean equipped = inventory.equipItem(sword);
        assertTrue(equipped);
        assertEquals(sword, inventory.getEquippedWeapon());

        assertNull(inventory.getItem(sword.getName()));
    }

    @Test
    public void testEquipArmor() {
        inventory.addItem(shield.getName(), shield);
        boolean equipped = inventory.equipItem(shield);

        assertTrue(equipped);
        assertEquals(shield, inventory.getEquippedArmor());

        assertNull(inventory.getItem(shield.getName()));
    }

    @Test
    public void testEquipBuff() {
        Item buff = new Buff("Strength Buff" , "Common", 5);
        inventory.addItem(buff.getName(), buff);

        boolean equipped = inventory.equipItem(buff);

        assertTrue(equipped);
        assertEquals(buff, inventory.getEquippedBuff());
        assertNull(inventory.getItem(buff.getName()));
    }

    @Test
    public void testBuff() {
        inventory.addItem(healingPotion.getName(), healingPotion);

        boolean equipped = inventory.equipItem(healingPotion);


        assertTrue(equipped);
    }

    @Test
    public void testGetAllItems() {
        inventory.addItem(sword.getName(), sword);
        inventory.addItem(shield.getName(), shield);

        assertEquals(2, inventory.getAllItems().size());

        inventory.addItem(sword.getName(), sword);

        assertEquals(3, inventory.getAllItems().size());
    }

    @Test
    public void testEquipReplaceEquippedItem() {
        inventory.addItem(sword.getName(), sword);
        inventory.addItem(shield.getName(), shield);

        inventory.equipItem(sword);

        boolean equipped = inventory.equipItem(shield);

        assertTrue(equipped);
        assertEquals(shield, inventory.getEquippedArmor());

        assertEquals(0, inventory.getItems().get(sword.getName()).size());
    }
}
