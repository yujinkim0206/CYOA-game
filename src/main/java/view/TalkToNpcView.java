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
    private final JButton exitButton;
    private final JButton buyButton;
    private final JButton closeButton;

    private final JPanel continueButtonPanel;
    private final JPanel merchantButtonPanel;
    private final JPanel closeButtonPanel;

    private TalkToNpcController talkToNpcController;

    public TalkToNpcView(TalkToNpcViewModel talkToNpcViewModel) {

        this.talkToNpcViewModel = talkToNpcViewModel;
        this.talkToNpcViewModel.addPropertyChangeListener(this);

        name = new JLabel();
        name.setAlignmentX(CENTER_ALIGNMENT);

        description = new JLabel();
        description.setAlignmentX(CENTER_ALIGNMENT);

        dialogue = new JTextArea(3, 20);
        dialogue.setLineWrap(true);
        dialogue.setWrapStyleWord(true);
        dialogue.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(dialogue);

        JPanel dialoguePanel = new JPanel();
        dialoguePanel.setLayout(new BoxLayout(dialoguePanel, BoxLayout.Y_AXIS));
        dialoguePanel.add(scrollPane);
        dialoguePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        continueButton = new JButton("Continue");

        continueButtonPanel = new JPanel();
        continueButtonPanel.add(continueButton);
        continueButtonPanel.setAlignmentX(CENTER_ALIGNMENT);

        exitButton = new JButton("Exit");
        buyButton = new JButton("Buy");

        merchantButtonPanel = new JPanel();
        merchantButtonPanel.add(exitButton);
        merchantButtonPanel.add(buyButton);
        merchantButtonPanel.setAlignmentX(CENTER_ALIGNMENT);

        closeButton = new JButton("Close");

        closeButtonPanel = new JPanel();
        closeButtonPanel.add(closeButton);
        closeButtonPanel.setAlignmentX(CENTER_ALIGNMENT);

        continueButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(continueButton)) {
                            final TalkToNpcState currentState = talkToNpcViewModel.getState();
                            talkToNpcController.moveToNextDialogue(
                                    currentState.getName(),
                                    currentState.getDescription(),
                                    currentState.getDialogue(),
                                    currentState.getCurrentDialogueIndex(),
                                    currentState.hasNextDialogue(),
                                    currentState.isMerchant());
                        }
                    }
                }
        );

        buyButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(buyButton)) {
                            talkToNpcController.switchToMerchantView();
                        }
                    }
                }
        );

        exitButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(exitButton)) {
                            talkToNpcController.exitInteraction();
                        }
                    }
                }
        );

        closeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(closeButton)) {
                            talkToNpcController.exitInteraction();
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
        this.add(continueButtonPanel);
        this.add(merchantButtonPanel);
        this.add(closeButtonPanel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(Box.createVerticalGlue());

        continueButtonPanel.setVisible(true);
        merchantButtonPanel.setVisible(false);
        closeButtonPanel.setVisible(false);
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

        name.setText(state.getName());
        description.setText(state.getDescription());
        dialogue.setText(state.getCurrentDialogue());

        if (state.hasNextDialogue()) {
            continueButtonPanel.setVisible(true);
            merchantButtonPanel.setVisible(false);
            closeButtonPanel.setVisible(false);
        } else if (state.isMerchant()) {
            continueButtonPanel.setVisible(false);
            merchantButtonPanel.setVisible(true);
            closeButtonPanel.setVisible(false);
        } else {
            continueButtonPanel.setVisible(false);
            merchantButtonPanel.setVisible(false);
            closeButtonPanel.setVisible(true);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setTalkToNpcController(TalkToNpcController talkToNpcController) {
        this.talkToNpcController = talkToNpcController;
    }
}
