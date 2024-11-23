package use_case.talk_to_npc;

import java.util.List;

/**
 * The input data for the Talk To Npc Use Case.
 */
public class TalkToNpcInputData {
    private String name;
    private String description;
    private List<String> dialogue;

    public TalkToNpcInputData(String name, String description, List<String> dialogue) {
        this.name = name;
        this.description = description;
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDialogue() {
        return dialogue;
    }
}

