package view;

import interface_adapter.equip_item.EquipItemController;
import interface_adapter.equip_item.EquipItemState;
import interface_adapter.equip_item.EquipItemViewModel;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * View for equipping items with a single button.
 */
public class EquipItemView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "equip item";
    private final EquipItemViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    private final JLabel[] inventoryLabels;
    private final JButton equipButton;
    private final JButton closeButton;
    private final String[] slotLabels = {"Armor", "Weapon", "Buff"};

    private EquipItemController controller;
    private int selectedCategoryIndex = -1;  // Tracks the selected category for equipping
    private String selectedItem;  // To store the item that is selected

    public EquipItemView(EquipItemViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;

        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Equip Item");
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);

        inventoryLabels = new JLabel[3];

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.X_AXIS));

        for (int i = 0; i < slotLabels.length; i++) {
            JPanel slotPanel = new JPanel();
            slotPanel.setLayout(new BoxLayout(slotPanel, BoxLayout.Y_AXIS));

            inventoryLabels[i] = new JLabel(slotLabels[i] + ": No Item");

            // Add a click listener for selecting categories
            int categoryIndex = i;  // To know which category was selected
            JButton categoryButton = new JButton("Select " + slotLabels[i]);
            categoryButton.addActionListener(e -> selectCategory(categoryIndex));

            slotPanel.add(inventoryLabels[i]);
            slotPanel.add(categoryButton);
            itemsPanel.add(slotPanel);
        }

        add(itemsPanel);

        equipButton = new JButton("Equip Item");
        equipButton.addActionListener(this);
        add(equipButton);

        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        add(closeButton);
    }

    // This method allows us to initialize with the selected item
    public void initializeWithItem(String selectedItem) {
        this.selectedItem = selectedItem;
        System.out.println("[DEBUG] Initialized EquipItemView with item: " + selectedItem);

        // Update equip button label to reflect selected item
        updateEquipButtonLabel();
    }

    private void selectCategory(int categoryIndex) {
        selectedCategoryIndex = categoryIndex;
        updateEquipButtonLabel();
    }

    private void updateEquipButtonLabel() {
        // Change the label of the equip button to reflect the selected category
        if (selectedCategoryIndex != -1 && selectedItem != null && !selectedItem.isEmpty()) {
            equipButton.setText("Equip " + slotLabels[selectedCategoryIndex] + ": " + selectedItem);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == equipButton) {
            if (selectedCategoryIndex != -1 && selectedItem != null) {
                // Equip the selected item to the selected category
                controller.equipItem(selectedItem);
            } else {
                JOptionPane.showMessageDialog(this, "No item to equip in this slot.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == closeButton) {
            // Closing view, set state to "open inventory"
            viewManagerModel.setState("open inventory");
            viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EquipItemState state = (EquipItemState) evt.getNewValue();

        String[] inventory = state.getInventory();
        for (int i = 0; i < inventoryLabels.length; i++) {
            inventoryLabels[i].setText(slotLabels[i] + ": " + (inventory[i] != null ? inventory[i] : "No Item"));
        }

        if (state.getMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setEquipItemController(EquipItemController controller) {
        this.controller = controller;
    }

    public String getViewName() {
        return viewName;
    }
}
