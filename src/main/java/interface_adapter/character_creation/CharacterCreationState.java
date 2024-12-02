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

    public String getPclass() {
        return pClass;
    }

    public void setPclass(String newpClass) {
        this.pClass = newpClass;
    }

    public String getPrace() {
        return pRace;
    }

    public void setPrace(String newpRace) {
        this.pRace = newpRace;
    }

    public String getPclassDescription() {
        return pClassDescription;
    }

    public void setPclassDescription(String newpClassDescription) {
        this.pClassDescription = newpClassDescription;
    }

    public String getPraceDescription() {
        return pRaceDescription;
    }

    public void setPraceDescription(String newpRaceDescription) {
        this.pRaceDescription = newpRaceDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
