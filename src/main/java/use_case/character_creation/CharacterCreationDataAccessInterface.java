package use_case.character_creation;

/**
 * DAO for the Character Creation Use Case.
 */
public interface CharacterCreationDataAccessInterface {
    public void setPclass(String pclass);
    public void setPrace(String prace);
    public String getPclass();
    public String getPrace();
    public String getPClassDescription();
    public String getPRaceDescription();
}
