package interface_adapter.merchant;

import java.util.List;
import java.util.Map;

import entity.Item;
import use_case.merchant.MerchantInputBoundary;
import use_case.merchant.MerchantInputData;

/**
 * The controller for the Merchant use case.
 */
public class MerchantController {

    private final MerchantInputBoundary merchantUseCaseInteractor;

    public MerchantController(MerchantInputBoundary merchantUseCaseInteractor) {
        this.merchantUseCaseInteractor = merchantUseCaseInteractor;
    }

    /**
     * Execute method.
     * @param items items
     */
    public void execute(Map<String, List<Item>> items) {
        final MerchantInputData merchantInputData = new MerchantInputData(items);
        merchantUseCaseInteractor.execute(merchantInputData);
    }
}
