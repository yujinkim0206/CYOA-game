package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.monster.FightMonsterController;
import interface_adapter.monster.FightMonsterState;
import interface_adapter.monster.FightMonsterViewModel;

/**
 * View for the Fight Monster Use Case.
 */
public class MonsterView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "monster";
    private final FightMonsterViewModel fightMonsterViewModel;
    private final FightMonsterState fightMonsterState = new FightMonsterState();

    private final JLabel monsterDescriptionLabel = new JLabel("You encountered a [Monster]!");
    private JLabel monsterHealth = new JLabel("Health: " + fightMonsterState.health);
    private JLabel damageDone = new JLabel("");

    private final JButton fightButton;
    private final JButton nextButton;

    private FightMonsterController fightMonsterController;

    public MonsterView(FightMonsterViewModel fightMonsterViewModel) {
        this.fightMonsterViewModel = fightMonsterViewModel;
        this.fightMonsterViewModel.addPropertyChangeListener(this);
        final JLabel title = new JLabel("Monster Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        fightButton = new JButton("Fight");
        nextButton = new JButton("Next");

        final JPanel buttons = new JPanel();
        buttons.add(nextButton);
        buttons.add(fightButton);

        fightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(fightButton)) {
                    final FightMonsterState currentState = fightMonsterViewModel.getState();
                    final int damage = currentState.hit();
                    monsterHealth.setText("Health: " + currentState.health);
                    damageDone.setText("Did " + damage + " damage");

                    if (currentState.health <= 0) {
                        fightMonsterController.execute();
                    }

                    fightMonsterController.hit();
                }
            }

        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(nextButton)) {
                    fightMonsterController.execute();
                }
            }

        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(monsterDescriptionLabel);
        this.add(monsterHealth);
        this.add(damageDone);
        this.add(buttons);
    }

    /**
     * Process actions (button clicks, usually).
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Change the view when an event occurs.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }

    public void setFightMonsterController(FightMonsterController controller) {
        this.fightMonsterController = controller;
    }
}
