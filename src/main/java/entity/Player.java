package entity;

/**
 * The representation of the player, which the user controls.
 */
public class Player {
    private String pclass;
    private String prace;
    private int classArmor;
    private int classDamage;

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

    /**
     * Getter and setter for classArmor.
     */
    public int getClassArmor() {
        return classArmor;
    }
    public void setClassArmor(int classArmor) {
        this.classArmor = classArmor;
    }

    /**
     * Getter and setter for classDamage.
     */
    public int getClassDamage() {
        return classDamage;
    }
    public void setClassDamage(int classDamage) {
        this.classDamage = classDamage;
    }
}
