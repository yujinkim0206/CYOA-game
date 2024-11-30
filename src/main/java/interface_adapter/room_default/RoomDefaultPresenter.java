package interface_adapter.room_default;

import interface_adapter.ViewManagerModel;
import use_case.room_default.RoomOutputBoundary;
import use_case.room_default.RoomOutputData;

/**
 * Presenter for the Room Default Use Case.
 */
public class RoomDefaultPresenter implements RoomOutputBoundary {
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructor for RoomDefaultPresenter.
     *
     * @param viewManagerModel the model managing view states
     */
    public RoomDefaultPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RoomOutputData outputData) {
        String roomType = outputData.getRoomType();
        switch (roomType) {
            case "ItemRoom":
                viewManagerModel.setState("pick up item");
                break;
            case "TrapRoom":
                viewManagerModel.setState("fall for trap");
                break;
            case "MonsterRoom":
                viewManagerModel.setState("fight monster");
                break;
            case "MerchantRoom":
                viewManagerModel.setState("merchant");
                break;
            default:
                viewManagerModel.setState("room view");
        }
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewManagerModel.setState("room view");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareMainMenuView() {
        viewManagerModel.setState("open inventory");
        viewManagerModel.firePropertyChanged();
    }
}
