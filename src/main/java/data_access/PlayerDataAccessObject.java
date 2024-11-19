package data_access;

import use_case.character_creation.CharacterCreationDataAccessInterface;
import entity.Player;
import okhttp3.OkHttpClient;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


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

    /**
     * Description Getters
     */
    public String getPClassDescription() {
        // TODO make API call here

        return "";
    }
    public String getPRaceDescription() {
        // TODO make API call here

        return "";
    }
}
