package entity;

/**
 * Merchant Room entity.
 */
public class MerchantRoom extends AbstractRoom {
    private Merchant merchant;

    /**
     * Creates a MerchantRoom.
     * @param roomNumber the room number
     * @param merchant the merchant in the MerchantRoom.
     */
    public MerchantRoom(int roomNumber, Merchant merchant) {
        super(roomNumber);
        this.merchant = merchant;
    }

    @Override
    public int getRoomType() {
        return 3;
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
