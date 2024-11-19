package data_access;

import use_case.character_creation.CharacterCreationDataAccessInterface;
import entity.Player;

public class PlayerDataAccessObject implements CharacterCreationDataAccessInterface {
    private Player player = new Player();

    /**
     * Setters
     */
    public void setPclass(String pclass) {
        player.setPclass(pclass);
    }
    public void setPrace(String prace) {
        player.setPrace(prace);
    }

    /**
     * Getters
     */
    public String getPclass() {
        return player.getPclass();
    }
    public String getPrace() {
        return player.getPrace();
    }
}
