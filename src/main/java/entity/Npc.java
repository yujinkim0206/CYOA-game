package entity;

import java.util.List;

/**
 * The representation of an NPC.
 */
public class Npc {
    private int name;
    private String description;
    private List<String> dialogue;

    public Npc(int name, String description, List<String> dialogue) {
        this.setName(name);
        this.setDescription(description);
        this.setDialogue(dialogue);
    }

    public Npc() {}

    public int getName() {
        return name;
    }

    public void setName(int name) {
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
