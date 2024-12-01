package use_case.room_default;

import entity.*;
import use_case.fall_for_trap.FallForTrapOutputData;

import java.util.List;

/**
 * The Room Default Interactor.
 */
public class RoomInteractor implements RoomInputBoundary {
    private final RoomOutputBoundary roomPresenter;
    private final RoomDataAccessInterface roomDataAccessObject;
    private final NpcRoomDataAccessInterface npcRoomDataAccessObject;
    private final TrapRoomDataAccessInterface trapRoomDataAccessObject;;

    public RoomInteractor(RoomOutputBoundary roomPresenter, RoomDataAccessInterface roomDataAccessInterface,
                          NpcRoomDataAccessInterface npcRoomDataAccessInterface,
                          TrapRoomDataAccessInterface trapRoomDataAccessInterface) {
        this.roomPresenter = roomPresenter;
        this.roomDataAccessObject = roomDataAccessInterface;
        this.npcRoomDataAccessObject = npcRoomDataAccessInterface;
        this.trapRoomDataAccessObject = trapRoomDataAccessInterface;
    }

    @Override
    public void interactWithRoom(RoomInputData inputData) {
        Room room = roomDataAccessObject.getCurrentRoom();

        if (room == null) {
            roomPresenter.prepareFailView("Room not found.");
            return;
        }

        if (room instanceof NpcRoom) {
            NpcRoom npcRoom = (NpcRoom) room;
            npcRoomDataAccessObject.loadNpcs();
            Npc npc = npcRoomDataAccessObject.generateRandomNpc();

            roomPresenter.prepareSuccessView(new NpcRoomOutputData(
                    npcRoom.getDescription(),
                    npc.getName(),
                    npc.getDescription(),
                    npc.getDialogue(),
                    npc.getCurrentDialogueIndex(),
                    npc.hasNextDialogue(),
                    npc.isMerchant()
            ));
        } else if (room instanceof TrapRoom) {
            TrapRoom trapRoom = (TrapRoom) room;
            trapRoomDataAccessObject.loadTraps();
            Trap trap = trapRoomDataAccessObject.generateRandomTrap();
            trapRoomDataAccessObject.setCurrentTrapName(trap.getName());
            trapRoom.setTrap(trap);

            roomPresenter.prepareSuccessView(new TrapRoomOutputData(
                    trapRoom.getDescription(),
                    trap.getName(),
                    trap.getDamage()
            ));
        } else {
            roomPresenter.prepareSuccessView(new RoomOutputData(room.getDescription(), room.getClass().getSimpleName()));
        }
    }

    @Override
    public void goToNextRoom() {
        List<Room> rooms = roomDataAccessObject.getFloor().getRoomList();

        if (roomDataAccessObject.getCurrentRoomIndex() < rooms.size() - 1) {
            roomDataAccessObject.setCurrentRoomIndex(roomDataAccessObject.getCurrentRoomIndex() + 1);
            Room nextRoom = rooms.get(roomDataAccessObject.getCurrentRoomIndex());
            roomPresenter.prepareNextRoomView(new RoomOutputData(nextRoom.getDescription(), nextRoom.getClass().getSimpleName()));
        } else {
            roomPresenter.prepareFailView("You have reached the end of the floor.");
        }
    }

    @Override
    public void returnToMainMenu() {
        roomPresenter.prepareFailView("Returning to Open Inventory.");
    }
}
