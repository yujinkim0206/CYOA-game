package view;

import interface_adapter.fall_for_trap.FallForTrapController;
import interface_adapter.fall_for_trap.FallForTrapState;
import interface_adapter.fall_for_trap.FallForTrapViewModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The View for when the user fell for a trap.
 */
public class FallForTrapView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "fall for trap";
    private final FallForTrapViewModel fallForTrapViewModel;

    private final JLabel title;
    private final JTextArea description;
    private final JButton moveOn;

    private FallForTrapController fallForTrapController;

    public FallForTrapView(FallForTrapViewModel fallForTrapViewModel) {

        this.fallForTrapViewModel = fallForTrapViewModel;
        this.fallForTrapViewModel.addPropertyChangeListener(this);

        title = new JLabel();
        title.setAlignmentX(CENTER_ALIGNMENT);

        description = new JTextArea( 3, 20);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(description);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.add(scrollPane);
        descriptionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        moveOn = new JButton("Move On");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(moveOn);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

        moveOn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(moveOn)) {
                            fallForTrapController.execute();
                        }
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(title);
        this.add(descriptionPanel);
        this.add(buttonPanel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(Box.createVerticalGlue());

    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final FallForTrapState state = (FallForTrapState) evt.getNewValue();

        title.setText("You got hit by [" + state.getName() + "]");
        description.setText(String.format("It dealt %d damage to you.", state.getDamage()));
    }

    public String getViewName() {
        return viewName;
    }

    public void setFallForTrapController(FallForTrapController fallForTrapController) {
        this.fallForTrapController = fallForTrapController;
    }
}
