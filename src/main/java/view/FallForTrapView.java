package view;

import interface_adapter.fall_for_trap.FallForTrapController;
import interface_adapter.fall_for_trap.FallForTrapState;
import interface_adapter.fall_for_trap.FallForTrapViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The View for when the user fell for a trap.
 */
public class FallForTrapView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "fall for trap";
    private final FallForTrapViewModel fallForTrapViewModel;

    private final JLabel description1 = new JLabel("You got hit by a [Poison Trap]!");
    private final JLabel description2 = new JLabel("It dealt 2 damage to you and corroded your [Rusty Breastplate].");
    private final JButton moveOn;
    private FallForTrapController fallForTrapController;

    public FallForTrapView(FallForTrapViewModel fallForTrapViewModel) {

        this.fallForTrapViewModel = fallForTrapViewModel;
        this.fallForTrapViewModel.addPropertyChangeListener(this);

        moveOn = new JButton("Move On");

        final JPanel buttons = new JPanel();
        buttons.add(moveOn);

        moveOn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(moveOn)) {
                            final FallForTrapState currentState = fallForTrapViewModel.getState();

                            fallForTrapController.execute();
                        }
                    }
                }
        );

        description1.setAlignmentX(CENTER_ALIGNMENT);
        description2.setAlignmentX(CENTER_ALIGNMENT);
        buttons.setAlignmentX(CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(description1);
        this.add(description2);
        this.add(buttons);

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
    }

    public String getViewName() {
        return viewName;
    }

    public void setFallForTrapController(FallForTrapController fallForTrapController) {
        this.fallForTrapController = fallForTrapController;
    }
}
