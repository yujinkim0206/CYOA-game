package entity;

/**
 * The representation of the player, which the user controls.
 */
public class Player {
    private String pclass;
    private String prace;

    public Player() {

    }

    /**
     * Getter and setter for pclass.
     */
    public String getPclass() {
        return pclass;
    }
    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    /**
     * Getter and setter for prace.
     */
    public String getPrace() {
        return prace;
    }
    public void setPrace(String race) {
        this.prace = race;
    }
}
