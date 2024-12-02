package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.ViewManagerModel;
import interface_adapter.pickup_item.PickUpItemController;
import interface_adapter.pickup_item.PickUpItemViewModel;

/**
 * View for Picking Up Items.
 */
public class PickUpItemView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "pick up item";
    private final PickUpItemViewModel viewModel;
    // Displays the current item
    private final JLabel itemLabel;
    // Button to pick up the item
    private final JButton pickUpButton;
    // Button to close the view
    private final JButton closeButton;
    private PickUpItemController controller;
    private final ViewManagerModel viewManagerModel;

    public PickUpItemView(PickUpItemViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Initialize components
        String initialItemLabel = "No Item Available";
        if (viewModel.getState().getItems() != null && viewModel.getState().getItems().length > 0) {
            // Display the first item
            initialItemLabel = "Item: " + viewModel.getState().getItems()[0];
        }

        itemLabel = new JLabel(initialItemLabel);
        itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        pickUpButton = new JButton("Pick Up");
        pickUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pickUpButton.addActionListener(this);

        closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(this);

        // Add components to the panel (with spacing)
        add(itemLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(pickUpButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(closeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pickUpButton) {
            // Trigger the pick-up use case and retrieve the result directly
            if (viewModel.getState().getItems() != null && viewModel.getState().getItems().length > 0) {
                // Notify the interactor to pick up the item
                controller.pickUpItem();
                JOptionPane.showMessageDialog(
                        this, "Item picked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                itemLabel.setText("No Item Available");
            }
            else {
                JOptionPane.showMessageDialog(
                        this, "No item to pick up in this room.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == closeButton) {
            viewManagerModel.setState("room view");
            viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void setPickUpController(PickUpItemController newController) {
        this.controller = newController;
    }

    public String getViewName() {
        return viewName;
    }
}
