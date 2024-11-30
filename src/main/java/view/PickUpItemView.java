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
    private final JLabel itemLabel;       // Displays the current item
    private final JButton pickUpButton;  // Button to pick up the item
    private final JButton closeButton;   // Button to close the view
    private PickUpItemController controller;
    private final ViewManagerModel viewManagerModel;

    public PickUpItemView(PickUpItemViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Initialize components
        String initialItemLabel = "No Item Available"; // Default text
        if (viewModel.getState().getItems() != null && viewModel.getState().getItems().length > 0) {
            initialItemLabel = "Item: " + viewModel.getState().getItems()[0]; // Display the first item
        }

        itemLabel = new JLabel(initialItemLabel);
        itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        pickUpButton = new JButton("Pick Up");
        pickUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pickUpButton.addActionListener(this);

        closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(this);

        // Add components to the panel
        add(itemLabel);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        add(pickUpButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        add(closeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pickUpButton) {
            // Trigger the pick-up use case and retrieve the result directly
            if (viewModel.getState().getItems() != null && viewModel.getState().getItems().length > 0) {
                controller.pickUpItem(); // Notify the interactor to pick up the item
                JOptionPane.showMessageDialog(this, "Item picked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                itemLabel.setText("No Item Available");
            } else {
                JOptionPane.showMessageDialog(this, "No item to pick up in this room.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == closeButton) {
            viewManagerModel.setState("room view");
            viewManagerModel.firePropertyChanged();
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final PickUpItemViewModel state = (PickUpItemViewModel) evt.getNewValue();
    }

    public void setPickUpController(PickUpItemController controller) {
        this.controller = controller;
    }

    public String getViewName() {
        return viewName;
    }
}
