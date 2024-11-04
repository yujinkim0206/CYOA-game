package use_case.open_inventory;

/**
 * Output Data for the Open Inventory Use Case.
 */
public class OpenInventoryOutputData {

    private boolean useCaseFailed;

    public LogoutOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
