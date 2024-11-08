package frEntity;

public class MonsterRoom extends Room{

    private Monster monster;

    /**
     * Creates an MonsterRoom
     * @param monster the monster in the MonsterRoom
     */

    public MonsterRoom(Monster monster){
        this.monster = monster;
    }

    /**
     * Returns the monster in the MonsterRoom
     * @return the monster in MonsterRoom
     */

    public Monster getMonster() {
        return monster;
    }

    /**
     * Allows us to set the monster in the MonsterRoom
     * @param monster the monster we want to set inside the MonsterRoom
     */

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
