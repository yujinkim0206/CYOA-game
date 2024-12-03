package use_case.room_default;

import java.util.List;

import entity.*;
import use_case.character_creation.CharacterCreationDataAccessInterface;


/**
 * The Room Default Interactor.
 */
public class RoomInteractor implements RoomInputBoundary {
    private final RoomOutputBoundary roomPresenter;
    private final RoomDataAccessInterface roomDataAccessObject;
    private final NpcRoomDataAccessInterface npcRoomDataAccessObject;
    private final TrapRoomDataAccessInterface trapRoomDataAccessObject;
    private final ItemRoomDataAccessInterface itemRoomDataAccessObject;
    private final CharacterCreationDataAccessInterface characterCreationDataAccessObject;

    public RoomInteractor(RoomOutputBoundary roomPresenter, RoomDataAccessInterface roomDataAccessInterface,
                          NpcRoomDataAccessInterface npcRoomDataAccessInterface,
                          TrapRoomDataAccessInterface trapRoomDataAccessInterface,
                            ItemRoomDataAccessInterface itemRoomDataAccessObject,
                          CharacterCreationDataAccessInterface characterCreationDataAccessInterface) {
        this.roomPresenter = roomPresenter;
        this.roomDataAccessObject = roomDataAccessInterface;
        this.npcRoomDataAccessObject = npcRoomDataAccessInterface;
        this.trapRoomDataAccessObject = trapRoomDataAccessInterface;
        this.itemRoomDataAccessObject = itemRoomDataAccessObject;
        this.characterCreationDataAccessObject = characterCreationDataAccessInterface;
    }

    @Override
    public void interactWithRoom() {
        final AbstractRoom abstractRoom = roomDataAccessObject.getCurrentRoom();

        if (abstractRoom == null) {
            roomPresenter.prepareFailView("Room not found.");
        }
        else if (abstractRoom instanceof NpcRoom) {
            final NpcRoom npcRoom = (NpcRoom) abstractRoom;
            npcRoomDataAccessObject.loadNpcs();
            final Npc npc = npcRoomDataAccessObject.generateRandomNpc();

            roomPresenter.prepareSuccessView(new NpcRoomOutputData(
                    npcRoom.getDescription(),
                    npc.getName(),
                    npc.getDescription(),
                    npc.getDialogue(),
                    npc.getCurrentDialogueIndex(),
                    npc.hasNextDialogue(),
                    npc.isMerchant()
            ));
        }
        else if (abstractRoom instanceof ItemRoom) {

            final ItemRoom itemRoom = (ItemRoom) abstractRoom;
            System.out.println("[DEBUG] Interacting with ItemRoom. Item: " + itemRoom.getItem().getName());
            String description = itemRoomDataAccessObject.getRoomDescription(itemRoom);
            Item item = itemRoomDataAccessObject.getItem(itemRoom);

            if (item == null) {
                roomPresenter.prepareFailView("No item to pick up in this room.");
            } else {
                System.out.println("[DEBUG] You reached here");
                roomPresenter.prepareSuccessView(new ItemRoomOutputData(
                        description,
                        item.getName(),
                        item.getRarity(),
                        item.getCategory()

                ));
            }
        }
        else if (abstractRoom instanceof TrapRoom) {
            final TrapRoom trapRoom = (TrapRoom) abstractRoom;
            trapRoomDataAccessObject.loadTraps();
            final Trap trap = trapRoomDataAccessObject.generateRandomTrap();
            trapRoomDataAccessObject.setCurrentTrapName(trap.getName());
            trapRoom.setTrap(trap);

            final int health = characterCreationDataAccessObject.getInstance().getHealth();
            characterCreationDataAccessObject.getInstance().setHealth(health - trap.getDamage());

            roomPresenter.prepareSuccessView(new TrapRoomOutputData(
                    trapRoom.getDescription(),
                    trap.getName(),
                    trap.getDamage(),
                    characterCreationDataAccessObject.getInstance().getHealth()
            ));
        }
        else {
            roomPresenter.prepareSuccessView(new RoomOutputData(abstractRoom.getDescription(),
                    abstractRoom.getClass().getSimpleName()));
        }
    }

    @Override
    public void goToNextRoom() {
        final List<AbstractRoom> rooms = roomDataAccessObject.getFloor().getRoomList();
        int currentIndex = roomDataAccessObject.getCurrentRoomIndex();

        if (currentIndex < rooms.size() - 1) {
            AbstractRoom nextRoom = rooms.get(++currentIndex);
            roomDataAccessObject.setCurrentRoomIndex(currentIndex);
            Player.getInstance().setCurrentRoom(nextRoom); // Update the player's current room
            roomPresenter.prepareNextRoomView(new RoomOutputData(nextRoom.getDescription(),
                    nextRoom.getClass().getSimpleName()));
        }
        else {
            Floor newFloor = roomDataAccessObject.makeNewFloor();
            roomDataAccessObject.setCurrentRoomIndex(0);
            final AbstractRoom newRoom = newFloor.getRoomList().get(0);
            roomPresenter.prepareNextRoomView(new RoomOutputData(newRoom.getDescription(),
                    newRoom.getClass().getSimpleName()));
        }
    }

    @Override
    public void returnToMainMenu() {
        roomPresenter.prepareInventoryView();
    }
}

