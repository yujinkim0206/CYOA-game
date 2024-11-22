package data_access;

import use_case.character_creation.CharacterCreationDataAccessInterface;
import entity.Player;

import okhttp3.*;
import java.io.IOException;

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
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            Request request = new Request.Builder()
                    .url("https://www.dnd5eapi.co/api/classes/" + player.getPclass())
                    .get() // Use the `.get()` method for GET requests
                    .addHeader("Accept", "application/json")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("CLASS: " + response);

        } catch (IOException e) {
            throw new RuntimeException(e); // Rethrow as an unchecked exception
        }


        return "";
    }
    public String getPRaceDescription() {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            Request request = new Request.Builder()
                    .url("https://www.dnd5eapi.co/api/races/" + player.getPrace())
                    .get() // Use the `.get()` method for GET requests
                    .addHeader("Accept", "application/json")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("RACE: " + response);

        } catch (IOException e) {
            throw new RuntimeException(e); // Rethrow as an unchecked exception
        }

        return "";
    }
}
