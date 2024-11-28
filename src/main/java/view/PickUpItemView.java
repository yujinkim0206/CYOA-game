package view;

import interface_adapter.pickup_item.PickUpItemController;
import interface_adapter.pickup_item.PickUpItemState;
import interface_adapter.pickup_item.PickUpItemViewModel;

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
    private final JLabel itemLabel;
    private final JButton pickUpButton;
    private final JButton closeButton;
    private PickUpItemController controller;

    public PickUpItemView(PickUpItemViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        itemLabel = new JLabel("No Item");
        pickUpButton = new JButton("Pick Up");
        closeButton = new JButton("Close");

        pickUpButton.addActionListener(this);
        closeButton.addActionListener(this);

        add(itemLabel);
        add(pickUpButton);
        add(closeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pickUpButton) {
            controller.pickUpItem();
        } else if (e.getSource() == closeButton) {
            System.out.println("Closing Pick-Up Item View.");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PickUpItemState state = (PickUpItemState) evt.getNewValue();
        itemLabel.setText(state.getItems() != null && state.getItems().length > 0 ? state.getItems()[0] : "No Item");
        pickUpButton.setEnabled(state.getItems() != null && state.getItems().length > 0);

        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPickUpController(PickUpItemController controller) {
        this.controller = controller;
    }

    public String getViewName() {
        return viewName;
    }
}
