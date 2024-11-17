package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.pickup_item.PickUpItemController;
import interface_adapter.pickup_item.PickUpItemState;
import interface_adapter.pickup_item.PickUpItemViewModel;

/**
 * The View for when the user is picking up items.
 */
public class PickUpItemView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "pick up item";
    private final PickUpItemViewModel pickUpItemViewModel;

    private final JLabel availableItem1;
    private final JLabel availableItem2;
    private final JLabel availableItem3;

    private final JButton pickUpItem1Button;
    private final JButton pickUpItem2Button;
    private final JButton pickUpItem3Button;
    private final JButton close;

    private PickUpItemController pickUpItemController;

    public PickUpItemView(PickUpItemViewModel pickUpItemViewModel) {
        this.pickUpItemViewModel = pickUpItemViewModel;
        this.pickUpItemViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Pick Up Item");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel for the first item
        final JPanel itemBox1 = new JPanel();
        itemBox1.setLayout(new BoxLayout(itemBox1, BoxLayout.Y_AXIS));
        availableItem1 = new JLabel("Item 1");
        pickUpItem1Button = new JButton("Pick Up");
        itemBox1.add(availableItem1);
        itemBox1.add(pickUpItem1Button);
        itemBox1.setBorder(BorderFactory.createLineBorder(Color.black));

        // Panel for the second item
        final JPanel itemBox2 = new JPanel();
        itemBox2.setLayout(new BoxLayout(itemBox2, BoxLayout.Y_AXIS));
        availableItem2 = new JLabel("Item 2");
        pickUpItem2Button = new JButton("Pick Up");
        itemBox2.add(availableItem2);
        itemBox2.add(pickUpItem2Button);
        itemBox2.setBorder(BorderFactory.createLineBorder(Color.black));

        // Panel for the third item
        final JPanel itemBox3 = new JPanel();
        itemBox3.setLayout(new BoxLayout(itemBox3, BoxLayout.Y_AXIS));
        availableItem3 = new JLabel("Item 3");
        pickUpItem3Button = new JButton("Pick Up");
        itemBox3.add(availableItem3);
        itemBox3.add(pickUpItem3Button);
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
        pickUpItem1Button.addActionListener(this);
        pickUpItem2Button.addActionListener(this);
        pickUpItem3Button.addActionListener(this);
        close.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(itemsPanel);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == pickUpItem1Button) {
            pickUpItemController.pickUpItem(availableItem1.getText());
        } else if (evt.getSource() == pickUpItem2Button) {
            pickUpItemController.pickUpItem(availableItem2.getText());
        } else if (evt.getSource() == pickUpItem3Button) {
            pickUpItemController.pickUpItem(availableItem3.getText());
        } else if (evt.getSource() == close) {
            // Close view logic
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final PickUpItemState state = (PickUpItemState) evt.getNewValue();
        availableItem1.setText(state.getItems()[0]);
        availableItem2.setText(state.getItems()[1]);
        availableItem3.setText(state.getItems()[2]);
    }

    public String getViewName() {
        return viewName;
    }

    public void setPickUpItemController(PickUpItemController controller) {
        this.pickUpItemController = controller;
    }
}
