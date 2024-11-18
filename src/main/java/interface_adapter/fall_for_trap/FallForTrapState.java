package interface_adapter.fall_for_trap;

/**
 * The state for the Fall For Trap View Model.
 */
public class FallForTrapState {
    private String name;
    private String damage;

    public String getName() {
        return name;
    }

    public String getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }
}
