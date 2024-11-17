package view;

import interface_adapter.talk_to_npc.TalkToNpcController;
import interface_adapter.talk_to_npc.TalkToNpcPresenter;
import interface_adapter.talk_to_npc.TalkToNpcState;
import interface_adapter.talk_to_npc.TalkToNpcViewModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The View for when the user talks to NPC.
 */
public class TalkToNpcView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "talk to NPC";
    private final TalkToNpcViewModel talkToNpcViewModel;

    private final JLabel name;
    private final JLabel description;
    private final JTextArea dialogue;
    private final JButton continueButton;
    private TalkToNpcController talkToNpcController;

    public TalkToNpcView(TalkToNpcViewModel talkToNpcViewModel) {

        this.talkToNpcViewModel = talkToNpcViewModel;
        this.talkToNpcViewModel.addPropertyChangeListener(this);

        name = new JLabel("ALCHEMIST");
        name.setAlignmentX(CENTER_ALIGNMENT);

        description = new JLabel("Medium humanoid (Artificer), any alignment");
        description.setAlignmentX(CENTER_ALIGNMENT);

        dialogue = new JTextArea("Careful! This one’s still untested. Oh well—guess you’ll help me find out what it does.", 3, 20);
        dialogue.setLineWrap(true);
        dialogue.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(dialogue);

        JPanel dialoguePanel = new JPanel();
        dialoguePanel.setLayout(new BoxLayout(dialoguePanel, BoxLayout.Y_AXIS));
        dialoguePanel.add(scrollPane);
        dialoguePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        continueButton = new JButton("Continue");

        final JPanel buttons = new JPanel();
        buttons.add(continueButton);
        buttons.setAlignmentX(CENTER_ALIGNMENT);

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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(name);
        this.add(description);
        this.add(dialoguePanel);
        this.add(buttons);
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
        final TalkToNpcState state = (TalkToNpcState) evt.getNewValue();
    }

    public String getViewName() {
        return viewName;
    }

    public void setTalkToNpcController(TalkToNpcController talkToNpcController) {
        this.talkToNpcController = talkToNpcController;
    }
}
