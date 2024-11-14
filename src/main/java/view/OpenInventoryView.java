package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import entity.Item;
import entity.Inventory;
import interface_adapter.open_inventory.OpenInventoryController;
import interface_adapter.open_inventory.OpenInventoryState;
import interface_adapter.open_inventory.OpenInventoryViewModel;

/**
 * The View for when the user is on the open inventory
 */
public class OpenInventoryView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "open inventory";
    private final OpenInventoryViewModel openInventoryViewModel;

    private Map<String, List<Item>> itemsMap;
    private List<Item> itemsList;

    // Three sample items, to show what the inventory screen will potentially look like.
    private final JLabel sampleItem1;
    private final JLabel sampleDescription1;
    private final JLabel sampleItem2;
    private final JLabel sampleDescription2;
    private final JLabel sampleItem3;
    private final JLabel sampleDescription3;

    private final JButton close;
    private OpenInventoryController openInventoryController;

    public OpenInventoryView(OpenInventoryViewModel openInventoryViewModel) {

        this.openInventoryViewModel = openInventoryViewModel;
        this.openInventoryViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Inventory Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add all the items from the State to the List "items"
        this.itemsMap = openInventoryViewModel.getState().getItems();
        for (String itemName : itemsMap.keySet()) {
            List<Item> itemList = itemsMap.get(itemName);
            itemsList.addAll(itemList);
        }

        /* TODO: implement this in a way that actually works and displays, after Item object is created
        for (Item item : itemsList) {
            final JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel itemName = new JLabel(item.toString()); // TODO: Add "get name" to Item object
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemPanel.add(itemName);
        } */

        // Create panel for the first item. For now it's just sample text, but will probably contain name & description
        final JPanel itemBox1 = new JPanel();
        itemBox1.setLayout(new BoxLayout(itemBox1, BoxLayout.Y_AXIS));
        sampleItem1 = new JLabel("Sample Item 1");
        sampleItem1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleDescription1 = new JLabel("Sample Description 1");
        sampleDescription1.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemBox1.add(sampleItem1);
        itemBox1.add(sampleDescription1);
        itemBox1.setBorder(BorderFactory.createLineBorder(Color.black));

        // Create panel for the second item. For now it's just sample text, but will probably contain name & description
        final JPanel itemBox2 = new JPanel();
        itemBox2.setLayout(new BoxLayout(itemBox2, BoxLayout.Y_AXIS));
        sampleItem2 = new JLabel("Sample Item 2");
        sampleItem2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleDescription2 = new JLabel("Sample Description 2");
        sampleDescription2.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemBox2.add(sampleItem2);
        itemBox2.add(sampleDescription2);
        itemBox2.setBorder(BorderFactory.createLineBorder(Color.black));

        // Create panel for the third item. For now it's just sample text, but will probably contain name & description
        final JPanel itemBox3 = new JPanel();
        itemBox3.setLayout(new BoxLayout(itemBox3, BoxLayout.Y_AXIS));
        sampleItem3 = new JLabel("Sample Item 3");
        sampleDescription3 = new JLabel("Sample Description 3");
        sampleDescription3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleItem3.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemBox3.add(sampleItem3);
        itemBox3.add(sampleDescription3);
        itemBox3.setBorder(BorderFactory.createLineBorder(Color.black));

        // Place all three item panels in one horizontal panel for nice-looking display.
        final JPanel items = new JPanel();
        items.setLayout(new BoxLayout(items, BoxLayout.X_AXIS));
        items.add(itemBox1);
        items.add(itemBox2);
        items.add(itemBox3);

        // Create the close inventory button
        final JPanel buttons = new JPanel();
        close = new JButton("Close");
        buttons.add(close);

        close.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(close)) {
                            final OpenInventoryState currentState = openInventoryViewModel.getState();

                            openInventoryController.execute( );
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(items);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final OpenInventoryState state = (OpenInventoryState) evt.getNewValue();
    }

    public String getViewName() {
        return viewName;
    }

    public void setOpenInventoryController(OpenInventoryController openInventoryController) {
        this.openInventoryController = openInventoryController;
    }
}
