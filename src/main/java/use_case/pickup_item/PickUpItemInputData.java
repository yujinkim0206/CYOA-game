package use_case.pickup_item;

import entity.Player;

/**
 * Input Data for the Pick-Up Item Use Case.
 */
public class PickUpItemInputData {
    private final Player player;

    public PickUpItemInputData(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
