package interface_adapter.talk_to_npc;

import java.util.List;

/**
 * The state for the Talk To Npc View Model.
 */
public class TalkToNpcState {
    private String name;
    private String description;
    private List<String> dialogue;


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

    public List<String> getDialogue() {
        return dialogue;
    }

    public void setDialogue(List<String> dialogue) {
        this.dialogue = dialogue;
    }
}
