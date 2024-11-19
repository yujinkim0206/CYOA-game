package interface_adapter.character_creation;

/**
 * The state for the Character Creation View Model.
 */
public class CharacterCreationState {
    private String pClass;
    private String pRace;

    public String getPclass() {
        return pClass;
    }
    public void setPclass(String pClass) {
        this.pClass = pClass;
    }

    public String getPRace() {
        return pRace;
    }
    public void setPRace(String pRace) {
        this.pRace = pRace;
    }
}
