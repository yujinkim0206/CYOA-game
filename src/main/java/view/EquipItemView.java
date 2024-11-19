package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.equip_item.EquipItemController;
import interface_adapter.equip_item.EquipItemState;
import interface_adapter.equip_item.EquipItemViewModel;

/**
 * The View for when the user is equipping items.
 */
public class EquipItemView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "equip item";
    private final EquipItemViewModel equipItemViewModel;

    private final JLabel inventoryItem1;
    private final JLabel inventoryItem2;
    private final JLabel inventoryItem3;

    private final JButton equipItem1Button;
    private final JButton equipItem2Button;
    private final JButton equipItem3Button;
    private final JButton close;

    private EquipItemController equipItemController;

    public EquipItemView(EquipItemViewModel equipItemViewModel) {
        this.equipItemViewModel = equipItemViewModel;
        this.equipItemViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Equip Item");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel for the first inventory item
        final JPanel itemBox1 = new JPanel();
        itemBox1.setLayout(new BoxLayout(itemBox1, BoxLayout.Y_AXIS));
        inventoryItem1 = new JLabel("Inventory Item 1");
        equipItem1Button = new JButton("Equip");
        itemBox1.add(inventoryItem1);
        itemBox1.add(equipItem1Button);
        itemBox1.setBorder(BorderFactory.createLineBorder(Color.black));

        // Panel for the second inventory item
        final JPanel itemBox2 = new JPanel();
        itemBox2.setLayout(new BoxLayout(itemBox2, BoxLayout.Y_AXIS));
        inventoryItem2 = new JLabel("Inventory Item 2");
        equipItem2Button = new JButton("Equip");
        itemBox2.add(inventoryItem2);
        itemBox2.add(equipItem2Button);
        itemBox2.setBorder(BorderFactory.createLineBorder(Color.black));

        // Panel for the third inventory item
        final JPanel itemBox3 = new JPanel();
        itemBox3.setLayout(new BoxLayout(itemBox3, BoxLayout.Y_AXIS));
        inventoryItem3 = new JLabel("Inventory Item 3");
        equipItem3Button = new JButton("Equip");
        itemBox3.add(inventoryItem3);
        itemBox3.add(equipItem3Button);
        itemBox3.setBorder(BorderFactory.createLineBorder(Color.black));

        // Adding the item panels to a horizontal panel
        final JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.X_AXIS));
        itemsPanel.add(itemBox1);
        itemsPanel.add(itemBox2);
        itemsPanel.add(itemBox3);

        // Close button
        final JPanel buttons = new JPanel();
        close = new JButton("Close");
        buttons.add(close);

        // Add action listeners
        equipItem1Button.addActionListener(this);
        equipItem2Button.addActionListener(this);
        equipItem3Button.addActionListener(this);
        close.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(itemsPanel);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == equipItem1Button) {
            equipItemController.equipItem(inventoryItem1.getText());
        } else if (evt.getSource() == equipItem2Button) {
            equipItemController.equipItem(inventoryItem2.getText());
        } else if (evt.getSource() == equipItem3Button) {
            equipItemController.equipItem(inventoryItem3.getText());
        } else if (evt.getSource() == close) {
            // Close view logic
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final EquipItemState state = (EquipItemState) evt.getNewValue();
        inventoryItem1.setText(state.getInventory()[0]);
        inventoryItem2.setText(state.getInventory()[1]);
        inventoryItem3.setText(state.getInventory()[2]);
    }

    public String getViewName() {
        return viewName;
    }

    public void setEquipItemController(EquipItemController controller) {
        this.equipItemController = controller;
    }
}

