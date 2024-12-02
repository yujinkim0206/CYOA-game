package interface_adapter.merchant;

import interface_adapter.ViewModel;

/**
 * The View Model for the Merchant View.
 */
public class MerchantViewModel extends ViewModel<MerchantState> {

    public MerchantViewModel() {
        super("merchant");
        setState(new MerchantState());
    }

}
