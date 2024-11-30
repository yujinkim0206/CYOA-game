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
 * View for equipping items.
 */
public class EquipItemView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "equip item";
    private final EquipItemViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    private final JLabel[] inventoryLabels;
    private final JButton[] equipButtons;
    private final JButton closeButton;
    private final String[] slotLabels = {"Armor", "Weapon", "Buff"};

    private EquipItemController controller;

    public EquipItemView(EquipItemViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;

        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Equip Item");
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);

        inventoryLabels = new JLabel[3];
        equipButtons = new JButton[3];

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.X_AXIS));

        for (int i = 0; i < slotLabels.length; i++) {
            JPanel slotPanel = new JPanel();
            slotPanel.setLayout(new BoxLayout(slotPanel, BoxLayout.Y_AXIS));

            inventoryLabels[i] = new JLabel(slotLabels[i] + ": No Item");
            equipButtons[i] = new JButton("Equip");
            equipButtons[i].addActionListener(this);

            slotPanel.add(inventoryLabels[i]);
            slotPanel.add(equipButtons[i]);
            itemsPanel.add(slotPanel);
        }

        add(itemsPanel);

        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        add(closeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < equipButtons.length; i++) {
            if (e.getSource() == equipButtons[i]) {
                String itemName = viewModel.getState().getInventory()[i];
                controller.equipItem(itemName);
                return;
            }
        }

        if (e.getSource() == closeButton) {
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
