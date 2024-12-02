package entity;

import java.util.List;

/**
 * Merchant entity.
 */
public class Merchant extends Npc {
    public Merchant(String name, String description, List<String> dialogue) {
        super(name, description, dialogue);
    }

    @Override
    public boolean isMerchant() {
        return true;
    }
}
