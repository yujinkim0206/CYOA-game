package entity;

/**
 * The representation of the player, which the user controls.
 */
public class Player {
    private String pclass;
    private String prace;
    private int classArmor;
    private int classDamage;
    private int raceArmor;
    private int raceDamage;
    private int totalArmor;
    private int totalDamage;

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
    public void setClassArmor(int classArmor) { this.classArmor = classArmor; this.setTotalArmor(); }

    /**
     * Getter and setter for classDamage.
     */
    public int getClassDamage() {
        return classDamage;
    }
    public void setClassDamage(int classDamage) { this.classDamage = classDamage; this.setTotalDamage(); }

    /**
     * Getter and setter for raceArmor.
     */
    public int getRaceArmor() { return raceArmor; }
    public void setRaceArmor(int raceArmor) { this.raceArmor = raceArmor; this.setTotalArmor(); }

    /**
     * Getter and setter for raceDamage.
     */
    public int getRaceDamage() { return raceDamage; }
    public void setRaceDamage(int raceDamage) { this.raceDamage = raceDamage; this.setTotalDamage(); }

    /**
     * Getter and setter for totalArmor.
     */
    public int getTotalArmor() { return totalArmor; }
    public void setTotalArmor() { totalArmor = classArmor + raceArmor; }

    /**
     * Getter and setter for totalDamage.
     */
    public int getTotalDamage() { return totalDamage; }
    public void setTotalDamage() { totalDamage = classDamage + raceDamage; }
}
