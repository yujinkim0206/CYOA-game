package use_case.character_creation;

/**
 * The Input Data for the Character Creation Use Case.
 */
public class CharacterCreationInputData {
    private String pClass;
    private String pRace;

    public CharacterCreationInputData(String pClass, String pRace) {
        this.pClass = pClass;
        this.pRace = pRace;
    }

    public String getPclass() {
        return pClass;
    }
    public String getPrace() {
        return pRace;
    }
}
