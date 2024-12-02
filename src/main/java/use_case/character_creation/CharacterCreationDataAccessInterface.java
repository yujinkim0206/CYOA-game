package use_case.character_creation;

import entity.Player;

/**
 * DAO for the Character Creation Use Case.
 */
public interface CharacterCreationDataAccessInterface {
    /**
     * Return the player instance.
     * @return the player instance
     */
    Player getInstance();

    /**
     * Set the class of the player.
     * @param pclass the class button the user clicked on
     */
    void setPclass(String pclass);

    /**
     * Set the race of the player.
     * @param prace the race button the user clicked on
     */
    void setPrace(String prace);

    /**
     * Return the current class of the player.
     * @return the current class of the player
     */
    String getPclass();

    /**
     * Return the current race of the player.
     * @return the current race of the player
     */
    String getPrace();

    /**
     * Create and return the damage and armor values of the class.
     * @return String formatted as "Damage: _, Armor: _" with correct values for the given class
     */
    String getPclassDescription();

    /**
     * Create and return the damage and armor values of the race.
     * @return String formatted as "Damage: _, Armor: _" with correct values for the given race
     */
    String getPraceDescription();
}
