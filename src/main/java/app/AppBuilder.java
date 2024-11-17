package app;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.InventoryDataAccessObject;
import data_access.RoomDataAccessObject;
import entity.Floor;
import entity.InventoryFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.talk_to_npc.TalkToNpcViewModel;
import interface_adapter.fall_for_trap.FallForTrapViewModel;
import interface_adapter.room_default.RoomDefaultViewModel;
import interface_adapter.open_inventory.OpenInventoryController;
import interface_adapter.open_inventory.OpenInventoryPresenter;
import interface_adapter.open_inventory.OpenInventoryViewModel;
import interface_adapter.room_default.RoomDefaultController;
import interface_adapter.room_default.RoomDefaultPresenter;
import use_case.open_inventory.OpenInventoryInputBoundary;
import use_case.open_inventory.OpenInventoryInteractor;
import use_case.open_inventory.OpenInventoryOutputBoundary;
import use_case.room_default.RoomInputBoundary;
import use_case.room_default.RoomInteractor;
import use_case.room_default.RoomOutputBoundary;
import view.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final InventoryFactory inventoryFactory = new InventoryFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final InventoryDataAccessObject inventoryDataAccessObject = new InventoryDataAccessObject();
    private final RoomDataAccessObject roomDataAccessObject = new RoomDataAccessObject();

    private TalkToNpcViewModel talkToNpcViewModel;
    private FallForTrapViewModel fallForTrapViewModel;
    private RoomDefaultViewModel roomDefaultViewModel;
    private OpenInventoryViewModel openInventoryViewModel;
    private OpenInventoryView openInventoryView;
    private RoomView roomView;
    private FallForTrapView fallForTrapView;
    private TalkToNpcView talkToNpcView;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the OpenInventory View to the application.
     * @return this builder
     */
    public AppBuilder addOpenInventoryView() {
        openInventoryViewModel = new OpenInventoryViewModel();
        openInventoryView = new OpenInventoryView(openInventoryViewModel);
        cardPanel.add(openInventoryView, openInventoryView.getViewName());
        return this;
    }

    /**
     * Adds the Room View to the application.
     * @return this builder
     */
    public AppBuilder addRoomView() {
        roomDefaultViewModel = new RoomDefaultViewModel();
        roomView = new RoomView(roomDefaultViewModel);
        cardPanel.add(roomView, roomDefaultViewModel.getViewName());
        return this;
    }

    /**
     * Adds the Fall For Trap View to the application.
     * @return this builder
     */
    public AppBuilder addFallForTrapView() {
        fallForTrapViewModel = new FallForTrapViewModel();
        fallForTrapView = new FallForTrapView(fallForTrapViewModel);
        cardPanel.add(fallForTrapView, fallForTrapViewModel.getViewName());
        return this;
    }

    /**
     * Adds the Talk To Npc View to the application.
     * @return this builder
     */
    public AppBuilder addTalkToNpcView() {
        talkToNpcViewModel = new TalkToNpcViewModel();
        talkToNpcView = new TalkToNpcView(talkToNpcViewModel);
        cardPanel.add(talkToNpcView, talkToNpcViewModel.getViewName());
        return this;
    }

    /**
     * Adds the Room Use Case to the application
     * @return this builder
     */
    public AppBuilder addRoomUseCase() {
        final RoomOutputBoundary roomOutputBoundary = new RoomDefaultPresenter(
                viewManagerModel, roomDefaultViewModel);

        final RoomInputBoundary roomInteractor = new RoomInteractor(
                roomOutputBoundary, roomDataAccessObject, new Floor());

        final RoomDefaultController roomDefaultController = new RoomDefaultController(roomInteractor);
        roomView.setRoomController(roomDefaultController);
        return this;
    }

    /**
     * Adds the OpenInventory Use Case to the application.
     * @return this builder
     */
    public AppBuilder addOpenInventoryUseCase() {
        final OpenInventoryOutputBoundary openInventoryOutputBoundary = new OpenInventoryPresenter(
                viewManagerModel, openInventoryViewModel, roomDefaultViewModel);

        final OpenInventoryInputBoundary openInventoryInteractor =
                new OpenInventoryInteractor(inventoryDataAccessObject, openInventoryOutputBoundary);

        final OpenInventoryController openInventoryController = new OpenInventoryController(openInventoryInteractor);
        openInventoryView.setOpenInventoryController(openInventoryController);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cardPanel.setPreferredSize(new Dimension(400, 200));
        application.add(cardPanel);

        viewManagerModel.setState(fallForTrapView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
