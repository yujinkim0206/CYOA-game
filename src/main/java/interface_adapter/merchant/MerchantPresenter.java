package interface_adapter.merchant;

import interface_adapter.ViewManagerModel;
import interface_adapter.room_default.RoomDefaultViewModel;
import use_case.merchant.MerchantOutputBoundary;
import view.MerchantView;

public class MerchantPresenter implements MerchantOutputBoundary {
    private final MerchantViewModel merchantViewModel;
    private final RoomDefaultViewModel roomDefaultViewModel;
    private final ViewManagerModel viewManagerModel;

    public MerchantPresenter(MerchantViewModel merchantViewModel,
                             RoomDefaultViewModel roomDefaultViewModel,
                             ViewManagerModel viewManagerModel) {
        this.merchantViewModel = merchantViewModel;
        this.roomDefaultViewModel = roomDefaultViewModel;
        this.viewManagerModel = viewManagerModel;
    }
}
