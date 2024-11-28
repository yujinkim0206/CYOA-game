package view;

import interface_adapter.equip_item.EquipItemController;
import interface_adapter.equip_item.EquipItemState;
import interface_adapter.equip_item.EquipItemViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for equipping items.
 */
public class EquipItemView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "equip item";
    private final EquipItemViewModel viewModel;

    private final JLabel[] inventoryLabels; // Labels for slots
    private final JButton[] equipButtons; // Equip buttons for slots
    private final JButton closeButton; // Close button

    private EquipItemController controller;

    public EquipItemView(EquipItemViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Equip Item");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Initialize inventory labels and buttons
        inventoryLabels = new JLabel[3];
        equipButtons = new JButton[3];

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.X_AXIS));

        // Define slots for Armor, Weapon, and Buff
        String[] slotLabels = {"Armor", "Weapon", "Buff"};
        for (int i = 0; i < 3; i++) {
            JPanel itemBox = new JPanel();
            itemBox.setLayout(new BoxLayout(itemBox, BoxLayout.Y_AXIS));
            inventoryLabels[i] = new JLabel(slotLabels[i] + ": No Item");
            equipButtons[i] = new JButton("Equip");
            equipButtons[i].addActionListener(this);
            itemBox.add(inventoryLabels[i]);
            itemBox.add(equipButtons[i]);
            itemsPanel.add(itemBox);
        }

        closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        add(title);
        add(itemsPanel);
        add(closeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button triggered the action
        for (int i = 0; i < equipButtons.length; i++) {
            if (e.getSource() == equipButtons[i]) {
                String itemName = inventoryLabels[i].getText().split(": ")[1];
                if (!"No Item".equals(itemName)) {
                    controller.equipItem(itemName); // Pass the item name to the controller
                } else {
                    JOptionPane.showMessageDialog(this, "No item to equip in this slot.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == closeButton) {
            System.out.println("Closing Equip Item View");
            // Handle closing logic if necessary
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EquipItemState state = (EquipItemState) evt.getNewValue();

        // Update inventory display for slots
        String[] inventory = state.getInventory();
        String[] slotLabels = {"Armor", "Weapon", "Buff"};
        for (int i = 0; i < inventoryLabels.length; i++) {
            if (inventory != null && i < inventory.length && inventory[i] != null) {
                inventoryLabels[i].setText(slotLabels[i] + ": " + inventory[i]);
                equipButtons[i].setEnabled(true);
            } else {
                inventoryLabels[i].setText(slotLabels[i] + ": No Item");
                equipButtons[i].setEnabled(false);
            }
        }

        // Display messages or errors
        if (state.getMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getMessage(), "Equip Item", JOptionPane.INFORMATION_MESSAGE);
        } else if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(), "Equip Item Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setEquipItemController(EquipItemController controller) {
        this.controller = controller;
    }
}
