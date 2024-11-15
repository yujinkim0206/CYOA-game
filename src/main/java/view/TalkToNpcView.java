package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.talk_to_npc.TalkToNpcController;
import interface_adapter.talk_to_npc.TalkToNpcPresenter;
import interface_adapter.talk_to_npc.TalkToNpcState;
import interface_adapter.talk_to_npc.TalkToNpcViewModel;

public class TalkToNpcView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "talk to NPC";
    private final TalkToNpcViewModel talkToNpcViewModel;

    private final JLabel name = new JLabel("Name");
    private final JTextArea dialogue = new JTextArea("Dialogue.");
    private final JButton continueButton;
    private TalkToNpcController talkToNpcController;

    public TalkToNpcView(TalkToNpcViewModel talkToNpcViewModel) {

        this.talkToNpcViewModel = talkToNpcViewModel;
        this.talkToNpcViewModel.addPropertyChangeListener(this);

        continueButton = new JButton("Continue");

        final JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(continueButton);

        continueButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(continueButton)) {
                            final TalkToNpcState currentState = talkToNpcViewModel.getState();

                            talkToNpcController.execute();
                        }
                    }
                }
        );

        JPanel dialoguePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dialoguePanel.add(name);
        dialoguePanel.add(dialogue);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(dialoguePanel);
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
        final TalkToNpcState state = (TalkToNpcState) evt.getNewValue();
    }

    public String getViewName() {
        return viewName;
    }

    public void setTalkToNpcController(TalkToNpcController talkToNpcController) {
        this.talkToNpcController = talkToNpcController;
    }
}
