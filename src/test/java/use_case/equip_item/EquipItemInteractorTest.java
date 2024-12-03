package use_case.equip_item;

import data_access.EquipItemDataAccessInterface;
import entity.Inventory;
import entity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipItemInteractorTest {

    private EquipItemInteractor interactor;
    private TestEquipItemDataAccess testDataAccess;
    private TestEquipItemPresenter testPresenter;

    @BeforeEach
    void setUp() {
        // Initialize test implementations of the dependencies
        testDataAccess = new TestEquipItemDataAccess();
        testPresenter = new TestEquipItemPresenter();

        // Create the interactor with test dependencies
        interactor = new EquipItemInteractor(testDataAccess, testPresenter);
    }

    @Test
    void testExecute_SuccessfulEquip() {
        // Arrange
        testDataAccess.addItemToInventory(new Item("Golden Sword", "Weapon", "Rare"));

        // Act
        interactor.execute(new EquipItemInputData("Golden Sword"));

        // Assert
        assertEquals("Golden Sword", testPresenter.outputData.getItemName());
        assertEquals("Successfully equipped Golden Sword.", testPresenter.outputData.getMessage());
        assertTrue(testDataAccess.isItemEquipped(), "[DEBUG] Item should be equipped successfully.");
    }

    @Test
    void testExecute_ItemNotFound() {
        // Arrange
        testDataAccess.addItemToInventory(new Item("Shield", "Armor", "Common"));

        // Act
        interactor.execute(new EquipItemInputData("Nonexistent Item"));

        // Assert
        assertEquals("Item not found in inventory.", testPresenter.errorMessage);
        assertFalse(testDataAccess.isItemEquipped(), "[DEBUG] Item should not be equipped.");
    }

    @Test
    void testExecute_NoItemNameProvided() {
        // Act
        interactor.execute(new EquipItemInputData(null));

        // Assert
        assertEquals("No item name provided to equip.", testPresenter.errorMessage);
        assertFalse(testDataAccess.isItemEquipped(), "[DEBUG] No item should be equipped.");
    }


    // Helper classes for testing

    private static class TestEquipItemDataAccess implements EquipItemDataAccessInterface {
        private Item item;
        private boolean itemEquipped = false;
        private boolean equipItemAllowed = true;

        void addItemToInventory(Item item) {
            this.item = item;
        }

        void setEquipItemAllowed(boolean equipItemAllowed) {
            this.equipItemAllowed = equipItemAllowed;
        }

        boolean isItemEquipped() {
            return itemEquipped;
        }

        @Override
        public Inventory getInventory() {
            Inventory inventory = new Inventory();
            if (item != null) {
                inventory.addItem(item.getName(), item);
            }
            return inventory;
        }

        @Override
        public void updateInventory(Inventory inventory) {
            if (equipItemAllowed) {
                itemEquipped = true;
            }
        }

        @Override
        public boolean itemExists(Item item) {
            return this.item != null && this.item.getName().equals(item.getName());
        }
    }

    private static class TestEquipItemPresenter implements EquipItemOutputBoundary {
        private EquipItemOutputData outputData;
        private String errorMessage;

        @Override
        public void prepareSuccessView(EquipItemOutputData outputData) {
            this.outputData = outputData;
        }

        @Override
        public void prepareFailView(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
