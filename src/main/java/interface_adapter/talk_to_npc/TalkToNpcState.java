package interface_adapter.talk_to_npc;

/**
 * The state for the Talk To Npc View Model.
 */
public class TalkToNpcState {
    private String name;
    private String description;
    private String dialogue;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }
}
