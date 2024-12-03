package view;

import interface_adapter.pickup_item.PickUpItemController;
import interface_adapter.pickup_item.PickUpItemState;
import interface_adapter.pickup_item.PickUpItemViewModel;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * View for Picking Up Items.
 */
public class PickUpItemView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "pick up item";
    private final PickUpItemViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    private final JLabel itemNameLabel;       // Displays the item's name
    private final JLabel itemDescriptionLabel; // Displays the item's description
    private final JButton pickUpButton;       // Button to pick up the item
    private final JButton closeButton;        // Button to close the view
    private PickUpItemController controller;

    public PickUpItemView(PickUpItemViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title
        JLabel titleLabel = new JLabel("Pick Up Item");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Item name label
        itemNameLabel = new JLabel("Item: ");
        itemNameLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Item description label
        itemDescriptionLabel = new JLabel("Description: ");
        itemDescriptionLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Buttons
        pickUpButton = new JButton("Pick Up");
        pickUpButton.setAlignmentX(CENTER_ALIGNMENT);
        pickUpButton.addActionListener(this);

        closeButton = new JButton("Close");
        closeButton.setAlignmentX(CENTER_ALIGNMENT);
        closeButton.addActionListener(this);

        // Layout
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(itemNameLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(itemDescriptionLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(pickUpButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(closeButton);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            PickUpItemState state = (PickUpItemState) evt.getNewValue();
            System.out.println("[DEBUG] PickUpItemView updated with state: " + state);

            if (state != null) {
                itemNameLabel.setText("Item: " + state.getItems());
                itemDescriptionLabel.setText(state.getMessage());
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pickUpButton) {
            if (controller != null) {
                controller.pickUpItem();
            }
        } else if (e.getSource() == closeButton) {
            viewManagerModel.setState("room view");
            viewManagerModel.firePropertyChanged();
        }
    }

    public void setPickUpController(PickUpItemController controller) {
        this.controller = controller;
    }

    public String getViewName() {
        return viewName;
    }
}
