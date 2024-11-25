package use_case.talk_to_npc;

import java.util.List;

/**
 * Output Data for the Talk To Npc Use Case.
 */
public class TalkToNpcOutputData {
    private final String name;
    private final String description;
    private final List<String> dialogue;
    private final int currentDialogueIndex;
    private final boolean hasNextDialogue;
    private final boolean isMerchant;

    public TalkToNpcOutputData(String name, String description, List<String> dialogue, int currentDialogueIndex,
                               boolean hasNextDialogue, boolean isMerchant) {
        this.name = name;
        this.description = description;
        this.dialogue = dialogue;
        this.currentDialogueIndex = currentDialogueIndex;
        this.hasNextDialogue = hasNextDialogue;
        this.isMerchant = isMerchant;
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

    public int getCurrentDialogueIndex() {
        return currentDialogueIndex;
    }

    public boolean hasNextDialogue() {
        return hasNextDialogue;
    }

    public boolean isMerchant() {
        return isMerchant;
    }
}
