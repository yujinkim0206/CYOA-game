package use_case.open_inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OpenInventoryInteractorTest {

    private OpenInventoryInteractor interactor;
    private TestOpenInventoryDataAccess testDataAccess;
    private TestOpenInventoryPresenter testPresenter;

    @BeforeEach
    void setUp() {
        // Initialize test implementations of dependencies
        testDataAccess = new TestOpenInventoryDataAccess();
        testPresenter = new TestOpenInventoryPresenter();

        // Create the interactor with test dependencies
        interactor = new OpenInventoryInteractor(testDataAccess, testPresenter);
    }

    @Test
    void testExecute_WithItems() {
        // Arrange
        Map<String, List<String>> inventory = new HashMap<>();
        inventory.put("Sword", Arrays.asList("Name: Sword, Rarity: Common, Category: Weapon"));
        inventory.put("Potion", Arrays.asList("Name: Potion, Rarity: Rare, Category: Consumable"));
        testDataAccess.setInventory(inventory);

        OpenInventoryInputData inputData = new OpenInventoryInputData();

        // Act
        interactor.execute();

        // Assert
        assertNotNull(testPresenter.outputData);
        assertEquals(inventory, testPresenter.outputData.getInventory());
        assertNull(testPresenter.errorMessage);
    }

    @Test
    void testExecute_EmptyInventory() {
        // Arrange
        testDataAccess.setInventory(new HashMap<>()); // Empty inventory

        OpenInventoryInputData inputData = new OpenInventoryInputData();

        // Act
        interactor.execute();

        // Assert
        assertNotNull(testPresenter.outputData);
        assertTrue(testPresenter.outputData.getInventory().isEmpty());
        assertNull(testPresenter.errorMessage);
    }

    @Test
    void testExecute_Failure() {
        // Arrange
        testDataAccess.setShouldThrowException(true);

        OpenInventoryInputData inputData = new OpenInventoryInputData();

        // Act
        interactor.execute();

        // Assert
        assertNull(testPresenter.outputData);
        assertEquals("Failed to load inventory: Test exception", testPresenter.errorMessage);
    }

    // Test implementation of OpenInventoryDataAccessInterface
    private static class TestOpenInventoryDataAccess implements OpenInventoryDataAccessInterface {
        private Map<String, List<String>> inventory = new HashMap<>();
        private boolean shouldThrowException = false;

        void setInventory(Map<String, List<String>> inventory) {
            this.inventory = inventory;
        }

        void setShouldThrowException(boolean shouldThrowException) {
            this.shouldThrowException = shouldThrowException;
        }

        @Override
        public Map<String, List<String>> getInventory() {
            if (shouldThrowException) {
                throw new RuntimeException("Test exception");
            }
            return inventory;
        }
    }

    // Test implementation of OpenInventoryOutputBoundary
    private static class TestOpenInventoryPresenter implements OpenInventoryOutputBoundary {
        private OpenInventoryOutputData outputData;
        private String errorMessage;

        @Override
        public void prepareSuccessView(OpenInventoryOutputData outputData) {
            this.outputData = outputData;
        }

        @Override
        public void prepareFailView(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
