package interface_adapter.character_creation;

/**
 * The state for the Character Creation View Model.
 */
public class CharacterCreationState {
    private String pClass;
    private String pRace;
    private String pClassDescription = "Not Selected";
    private String pRaceDescription = "Not Selected";
    private String error = "";

    public String getPClass() {
        return pClass;
    }
    public void setPClass(String pClass) {
        this.pClass = pClass;
    }

    public String getPRace() {
        return pRace;
    }
    public void setPRace(String pRace) {
        this.pRace = pRace;
    }

    public String getPClassDescription() { return pClassDescription; }
    public void setPClassDescription(String pClassDescription) { this.pClassDescription = pClassDescription; }

    public String getPRaceDescription() { return pRaceDescription; }
    public void setPRaceDescription(String pRaceDescription) { this.pRaceDescription = pRaceDescription; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}
