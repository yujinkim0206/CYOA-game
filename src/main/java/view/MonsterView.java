package view;

import interface_adapter.monster.FightMonsterController;
import interface_adapter.monster.FightMonsterState;
import interface_adapter.monster.FightMonsterViewModel;
import entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MonsterView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "monster";
    private final FightMonsterViewModel fightMonsterViewModel;
    private final FightMonsterState fightMonsterState = new FightMonsterState();

    private final JLabel monsterDescriptionLabel = new JLabel("You encountered a " + fightMonsterState.name + "!");
    private JLabel monsterHealth = new JLabel("Health: " + fightMonsterState.health);
    private JLabel playerHealth = new JLabel("");
    private JLabel damageDone = new JLabel("");
    private JLabel monsterDamage = new JLabel("");
    private JLabel victoryLabel = new JLabel("");
    private JLabel victoryResources = new JLabel("");
    private JLabel monsterVictory = new JLabel("");

    private final JButton fightButton;
    private final JButton nextButton;

    private FightMonsterController fightMonsterController;

    public MonsterView(FightMonsterViewModel fightMonsterViewModel) {
        this.fightMonsterViewModel = fightMonsterViewModel;
        this.fightMonsterViewModel.addPropertyChangeListener(this);
        Player player = Player.getInstance();
        int initHealth = fightMonsterState.health;
        int initPlayerHealth = player.getHealth();

        fightButton = new JButton("Fight");
        nextButton = new JButton("Next");

        final JPanel buttons = new JPanel();
        buttons.add(nextButton);
        buttons.add(fightButton);

        fightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(fightButton)) {
                    nextButton.setVisible(false);
                    int damage = fightMonsterState.hit(player.getTotalDamage());
                    monsterHealth.setText("Health: " + fightMonsterState.health);
                    damageDone.setText("Did " + damage + " damage!");
                    monsterDamage.setText(fightMonsterState.name + " did " + fightMonsterState.damage(player.getTotalArmor()) + " damage!");
                    player.setHealth(initPlayerHealth - damage);

                    if (fightMonsterState.health <= 0) {
                        nextButton.setVisible(true);
                        fightButton.setVisible(false);
                        monsterDescriptionLabel.setText("");
                        monsterHealth.setText("");
                        damageDone.setText("");
                        monsterDamage.setText("");
                        victoryLabel.setText("Congratulations! You defeated the " + fightMonsterState.name + "!");
                        victoryResources.setText("You gain " + (initHealth/10 + 1) + " gold");
                    }

                    if (player.getHealth() <= 0) {
                        nextButton.setVisible(true);
                        fightButton.setVisible(false);
                        monsterDescriptionLabel.setText("");
                        monsterHealth.setText("");
                        damageDone.setText("");
                        monsterDamage.setText("");
                        monsterVictory.setText("You died");
                    }

                    fightMonsterController.hit();
                }
            }

        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(nextButton)) {
                    final FightMonsterState currentState = fightMonsterViewModel.getState();

                    fightMonsterController.execute();
                }
            }

        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(monsterDescriptionLabel);
        this.add(monsterHealth);
        this.add(playerHealth);
        this.add(damageDone);
        this.add(monsterDamage);
        this.add(victoryLabel);
        this.add(victoryResources);
        this.add(monsterVictory);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public void propertyChange(PropertyChangeEvent evt) {
        final FightMonsterState state = (FightMonsterState) evt.getNewValue();
    }

    public String getViewName() {
        return viewName;
    }

    public void setFightMonsterController(FightMonsterController controller) {
        this.fightMonsterController = controller;
    }
}