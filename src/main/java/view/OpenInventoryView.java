package view;

import interface_adapter.open_inventory.OpenInventoryController;
import interface_adapter.open_inventory.OpenInventoryState;
import interface_adapter.open_inventory.OpenInventoryViewModel;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;

/**
 * The View for when the user is on the open inventory.
 */
public class OpenInventoryView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "open inventory";
    private final OpenInventoryViewModel openInventoryViewModel;
    private final ViewManagerModel viewManagerModel;
    private OpenInventoryController openInventoryController;

    public OpenInventoryView(OpenInventoryViewModel openInventoryViewModel, ViewManagerModel viewManagerModel) {
        this.openInventoryViewModel = openInventoryViewModel;
        this.viewManagerModel = viewManagerModel;

        this.openInventoryViewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Inventory");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        // Container for all items
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        // Get inventory items from the view model
        Map<String, List<String>> items = openInventoryViewModel.getState().getItems();
        if (items != null) {
            for (Map.Entry<String, List<String>> entry : items.entrySet()) {
                String itemName = entry.getKey();
                List<String> itemDetails = entry.getValue();

                // Panel for each item
                JPanel itemPanel = new JPanel();
                itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
                itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Display item name
                JLabel nameLabel = new JLabel("Name: " + itemName);
                nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                itemPanel.add(nameLabel);

                // Display item details
                for (String detail : itemDetails) {
                    JLabel detailLabel = new JLabel(detail);
                    detailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    itemPanel.add(detailLabel);
                }

                // Add "Equip" button for each item
                JButton equipButton = new JButton("Equip");
                equipButton.setActionCommand(itemName);
                equipButton.addActionListener(this);
                equipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                itemPanel.add(equipButton);

                itemsPanel.add(itemPanel);
            }
        } else {
            JLabel emptyLabel = new JLabel("No items in inventory.");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemsPanel.add(emptyLabel);
        }

        add(itemsPanel);

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            viewManagerModel.setState("room view"); // Navigate back to room view
            viewManagerModel.firePropertyChanged();
        });
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(closeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton equipButton = (JButton) e.getSource(); // Explicit cast
            String itemName = equipButton.getActionCommand();

            // Transition to EquipItemView via state
            viewManagerModel.setState("equip item");
            viewManagerModel.firePropertyChanged();
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            OpenInventoryState state = (OpenInventoryState) evt.getNewValue();

            removeAll(); // Clear the existing UI components
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel("Inventory");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(title);

            // Create a new panel for items
            JPanel itemsPanel = new JPanel();
            itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

            Map<String, List<String>> items = state.getItems();
            if (items != null && !items.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : items.entrySet()) {
                    String itemName = entry.getKey();
                    List<String> itemDetails = entry.getValue();

                    JPanel itemPanel = new JPanel();
                    itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
                    itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    for (String detail : itemDetails) {
                        JLabel detailLabel = new JLabel(detail);
                        detailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        itemPanel.add(detailLabel);
                    }

                    JButton equipButton = new JButton("Equip");
                    equipButton.setActionCommand(itemName);
                    equipButton.addActionListener(this);
                    equipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                    itemPanel.add(equipButton);

                    itemsPanel.add(itemPanel);
                }
            } else {
                JLabel emptyLabel = new JLabel("No items in inventory.");
                emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                itemsPanel.add(emptyLabel);
            }

            add(itemsPanel);

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> {
                viewManagerModel.setState("room view");
                viewManagerModel.firePropertyChanged();
            });
            closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(closeButton);

            revalidate(); // Refresh the UI
            repaint();
        }
    }



    public void setOpenInventoryController(OpenInventoryController controller) {
        this.openInventoryController = controller;
    }

    public String getViewName() {
        return viewName;
    }
}
