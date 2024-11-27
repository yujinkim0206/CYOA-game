package entity;

public class MerchantRoom extends Room {
    private Merchant merchant;

    /**
     * Creates a MerchantRoom.
     * @param merchant the merchant in the MerchantRoom.
     */

    public MerchantRoom(Merchant merchant) {
        this.merchant = merchant;
    }

    /**
     * Returns merchant.
     * @return the merchant in the MerchantRoom.
     */
    public Merchant getMerchant() {
        return merchant;
    }

    /**
     * Lets us set the merchant in the MerchantRoom.
     * @param merchant the merchant in the MerchantRoom.
     */
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
