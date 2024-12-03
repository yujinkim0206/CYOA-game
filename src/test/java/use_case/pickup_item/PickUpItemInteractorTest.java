package use_case.pickup_item;

import entity.Item;
import interface_adapter.open_inventory.OpenInventoryViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PickUpItemInteractorTest {

    private PickUpItemInteractor interactor;
    private TestPickUpItemDataAccess testDataAccess;
    private TestPickUpItemPresenter testPresenter;
    private TestOpenInventoryViewModel testOpenInventoryViewModel;

    @BeforeEach
    void setUp() {
        testDataAccess = new TestPickUpItemDataAccess();
        testPresenter = new TestPickUpItemPresenter();
        testOpenInventoryViewModel = new TestOpenInventoryViewModel();

        interactor = new PickUpItemInteractor(testDataAccess, testPresenter, testOpenInventoryViewModel);
    }


    @Test
    void testExecute_NoItemToPickUp() {
        // Arrange
        testDataAccess.setItem(null);

        // Act
        interactor.execute(new PickUpItemInputData());

        // Assert
        assertNull(testPresenter.outputData, "[DEBUG] outputData in presenter should be null.");
        assertEquals("No item to pick up in the room.", testPresenter.errorMessage);
        assertFalse(testDataAccess.isItemAddedToInventory(), "[DEBUG] No item should be added to inventory.");
        assertFalse(testDataAccess.isRoomCleared(), "[DEBUG] Room should not be cleared.");
        assertTrue(testOpenInventoryViewModel.getInventory().isEmpty(), "[DEBUG] Inventory should remain empty.");
    }

    // Test Implementations

    private static class TestPickUpItemDataAccess implements PickUpItemDataAccessInterface {
        private Item item;
        private boolean itemAddedToInventory = false;
        private boolean roomCleared = false;
        private final Map<String, List<String>> inventory = new HashMap<>();

        void setItem(Item item) {
            this.item = item;
        }

        boolean isItemAddedToInventory() {
            return itemAddedToInventory;
        }

        boolean isRoomCleared() {
            return roomCleared;
        }

        @Override
        public Item getItem() {
            return item;
        }

        @Override
        public void addToInventory(Item item) {
            if (item != null) {
                inventory.put(item.getName(), List.of(item.getCategory(), item.getRarity()));
                itemAddedToInventory = true;
            }
        }

        @Override
        public void clearRoomItem() {
            roomCleared = true;
        }

        @Override
        public Map<String, List<String>> getInventory() {
            return inventory;
        }
    }

    private static class TestPickUpItemPresenter implements PickUpItemOutputBoundary {
        PickUpItemOutputData outputData;
        String errorMessage;

        @Override
        public void prepareSuccessView(PickUpItemOutputData response) {
            this.outputData = response;
        }

        @Override
        public void prepareFailView(String error) {
            this.errorMessage = error;
        }

        @Override
        public void clearItemState() {
            // No-op for testing purposes
        }
    }

    private static class TestOpenInventoryViewModel extends OpenInventoryViewModel {
        private final Map<String, List<String>> inventory = new HashMap<>();

        @Override
        public void updateInventory(Map<String, List<String>> inventory) {
            this.inventory.clear();
            this.inventory.putAll(inventory);
        }

        public Map<String, List<String>> getInventory() {
            return inventory;
        }
    }
}
