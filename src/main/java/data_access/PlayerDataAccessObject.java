package data_access;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Player;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import use_case.character_creation.CharacterCreationDataAccessInterface;

/**
 * Player Data Access Object (also accesses dnd5eapi.
 */
public class PlayerDataAccessObject implements CharacterCreationDataAccessInterface {
    private Player player = Player.getInstance();

    /**
     * Setter for pclass.
     * @param pclass the class button the user clicked on
     */
    public void setPclass(String pclass) {
        player.setPclass(pclass);
    }

    /**
     * Setter for prace.
     * @param prace the race button the user clicked on
     */
    public void setPrace(String prace) {
        player.setPrace(prace);
    }

    public String getPclass() {
        return player.getPclass();
    }

    public String getPrace() {
        return player.getPrace();
    }

    public Player getInstance() {
        return player;
    }

    public int getRoomNumber() {
        return player.getCurrentRoom().getRoomNumber();
    }

    /**
     * Description Creators, accessing and analysing API data.
     * @return the class description (damage and armor)
     * @throws RuntimeException on failed API call
     */
    public String getPclassDescription() {
        String output = "";
        if (player.getPrace() != null) {
            try {
                final OkHttpClient client = new OkHttpClient().newBuilder().build();

                final Request request = new Request.Builder()
                        .url("https://www.dnd5eapi.co/api/classes/" + player.getPclass())
                        .get()
                        .addHeader("Accept", "application/json")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (response.isSuccessful() && response.body() != null) {
                        // Analyze JSON and update player entity
                        final Map<String, Integer> stats = analyzeClassJSON(response);
                        player.setClassDamage(stats.get("Damage"));
                        player.setClassArmor(stats.get("Armor"));
                        output = "Damage: " + player.getClassDamage() + ", Armor: " + player.getClassArmor();
                    }
                    else {
                        throw new IOException("Unexpected code " + response);
                    }
                }

            }
            catch (IOException error) {
                // Rethrow as an unchecked exception
                throw new RuntimeException(error);
            }
        }
        return output;
    }

    private static Map<String, Integer> analyzeClassJSON(Response response) throws IOException {
        // No need to check response.body() != null here since it's done in getPClassDescription()
        final JSONObject json = new JSONObject(response.body().string());

        // Find armor proficiencies and get a value using regex
        final JSONArray proficiencies = json.getJSONArray("proficiencies");
        int armorProf = 0;
        for (int i = 0; i < proficiencies.length(); i++) {
            final JSONObject proficiency = proficiencies.getJSONObject(i);
            if (proficiency.getString("name").matches(".*Armor")) {
                // No .* at start because string should be Light/Medium Armor exactly
                if (proficiency.getString("name").matches("Light.*")) {
                    armorProf += 1;
                }
                else {
                    armorProf += 0;
                }
                if (proficiency.getString("name").matches("Medium.*")) {
                    armorProf += 2;
                }
                else {
                    armorProf += 0;
                }
            }
        }

        // Get damage (translating hit_die directly)
        final int damage = json.getInt("hit_die");

        // Put stats in a HashMap and return
        final Map<String, Integer> stats = new HashMap<>();
        stats.put("Damage", damage);
        stats.put("Armor", armorProf);
        return stats;
    }

    /**
     * Description Creators, accessing and analysing API data.
     * @return the class description (damage and armor)
     * @throws RuntimeException on failed API call
     */
    public String getPraceDescription() {
        String output = "";
        if (player.getPrace() != null) {
            try {
                final OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();

                final Request request = new Request.Builder()
                        .url("https://www.dnd5eapi.co/api/races/" + player.getPrace())
                        .get()
                        .addHeader("Accept", "application/json")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (response.isSuccessful() && response.body() != null) {
                        // Analyze JSON and update player entity
                        final Map<String, Integer> bonuses = analyzeRaceJSON(response);
                        player.setRaceDamage(bonuses.get("Damage"));
                        player.setRaceArmor(bonuses.get("Armor"));
                        output = "Damage: " + player.getRaceDamage() + ", Armor: " + player.getRaceArmor();
                    }
                    else {
                        throw new IOException("Unexpected code " + response);
                    }
                }

            }
            catch (IOException error) {
                // Rethrow as an unchecked exception
                throw new RuntimeException(error);
            }
        }
        return output;
    }

    private Map<String, Integer> analyzeRaceJSON(Response response) throws IOException {
        // No need to check response.body() != null here since it's done in getPRaceDescription()
        final JSONObject json = new JSONObject(response.body().string());

        // Find ability bonuses and parse values into bonuses Map
        final JSONArray abilityBonuses = json.getJSONArray("ability_bonuses");
        final Map<String, Integer> bonuses = new HashMap<>();
        bonuses.put("Damage", 0);
        bonuses.put("Armor", 0);
        for (int i = 0; i < abilityBonuses.length(); i++) {
            final JSONObject abilityBonus = abilityBonuses.getJSONObject(i);
            final String abilityName = abilityBonus.getJSONObject("ability_score").getString("name");
            if ("STR".equals(abilityName)) {
                bonuses.put("Damage", abilityBonus.getInt("bonus"));
            }
            if ("CON".equals(abilityName)) {
                bonuses.put("Armor", abilityBonus.getInt("bonus"));
            }
        }

        return bonuses;
    }
}
