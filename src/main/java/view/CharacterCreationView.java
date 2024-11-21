package view;

import interface_adapter.character_creation.CharacterCreationController;
import interface_adapter.character_creation.CharacterCreationState;
import interface_adapter.character_creation.CharacterCreationViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is on the character creator
 */
public class CharacterCreationView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "character creation";
    private final CharacterCreationViewModel characterCreationViewModel;

    // Three sample classes
    private final JButton sampleClass1;
    private final JButton sampleClass2;
    private final JButton sampleClass3;
    private final JLabel sampleClassDescription1;
    private final JLabel sampleClassDescription2;
    private final JLabel sampleClassDescription3;
    // Four sample races
    private final JButton sampleRace1;
    private final JButton sampleRace2;
    private final JButton sampleRace3;
    private final JButton sampleRace4;
    private final JLabel sampleRaceDescription1;
    private final JLabel sampleRaceDescription2;
    private final JLabel sampleRaceDescription3;
    private final JLabel sampleRaceDescription4;

    private final JButton next;
    private CharacterCreationController characterCreationController;

    public CharacterCreationView(CharacterCreationViewModel characterCreationViewModel) {

        this.characterCreationViewModel = characterCreationViewModel;
        this.characterCreationViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Character Creation Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel classes_title = new JLabel("Select Class");
        classes_title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create panel for the first sample class. Add API later.
        final JPanel classBox1 = new JPanel();
        classBox1.setLayout(new BoxLayout(classBox1, BoxLayout.Y_AXIS));
        classBox1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleClass1 = new JButton("Sample Class 1");
        sampleClass1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleClassDescription1 = new JLabel("Sample Class Description 1");
        sampleClassDescription1.setAlignmentX(Component.CENTER_ALIGNMENT);
        classBox1.add(sampleClass1);
        classBox1.add(sampleClassDescription1);
        classBox1.setBorder(BorderFactory.createLineBorder(Color.black));

        sampleClass1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(sampleClass1)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPclass("Class 1");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPclass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the second sample class. Add API later.
        final JPanel classBox2 = new JPanel();
        classBox2.setLayout(new BoxLayout(classBox2, BoxLayout.Y_AXIS));
        classBox2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleClass2 = new JButton("Sample Class 2");
        sampleClass2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleClassDescription2 = new JLabel("Sample Class Description 2");
        sampleClassDescription2.setAlignmentX(Component.CENTER_ALIGNMENT);
        classBox2.add(sampleClass2);
        classBox2.add(sampleClassDescription2);
        classBox2.setBorder(BorderFactory.createLineBorder(Color.black));

        sampleClass2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(sampleClass2)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPclass("Class 2");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPclass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the third sample class. Add API later.
        final JPanel classBox3 = new JPanel();
        classBox3.setLayout(new BoxLayout(classBox3, BoxLayout.Y_AXIS));
        classBox3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleClass3 = new JButton("Sample Class 3");
        sampleClass3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleClassDescription3 = new JLabel("Sample Class Description 3");
        sampleClassDescription3.setAlignmentX(Component.CENTER_ALIGNMENT);
        classBox3.add(sampleClass3);
        classBox3.add(sampleClassDescription3);
        classBox3.setBorder(BorderFactory.createLineBorder(Color.black));

        sampleClass3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(sampleClass3)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPclass("Class 3");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPclass(), currentState.getPRace());
                        }
                    }
                }
        );

        final JLabel races_title = new JLabel("Select Race");
        races_title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create panel for the first sample race. Add API later.
        final JPanel raceBox1 = new JPanel();
        raceBox1.setLayout(new BoxLayout(raceBox1, BoxLayout.Y_AXIS));
        sampleRace1 = new JButton("Sample Race 1");
        sampleRace1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleRaceDescription1 = new JLabel("Sample Race Description 1");
        sampleRaceDescription1.setAlignmentX(Component.CENTER_ALIGNMENT);
        raceBox1.add(sampleRace1);
        raceBox1.add(sampleRaceDescription1);
        raceBox1.setBorder(BorderFactory.createLineBorder(Color.black));

        sampleRace1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(sampleRace1)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("Race 1");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPclass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the second sample race. Add API later.
        final JPanel raceBox2 = new JPanel();
        raceBox2.setLayout(new BoxLayout(raceBox2, BoxLayout.Y_AXIS));
        sampleRace2 = new JButton("Sample Race 2");
        sampleRace2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleRaceDescription2 = new JLabel("Sample Race Description 2");
        sampleRaceDescription2.setAlignmentX(Component.CENTER_ALIGNMENT);
        raceBox2.add(sampleRace2);
        raceBox2.add(sampleRaceDescription2);
        raceBox2.setBorder(BorderFactory.createLineBorder(Color.black));

        sampleRace2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(sampleRace2)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("Race 2");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPclass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the third sample race. Add API later.
        final JPanel raceBox3 = new JPanel();
        raceBox3.setLayout(new BoxLayout(raceBox3, BoxLayout.Y_AXIS));
        sampleRace3 = new JButton("Sample Race 3");
        sampleRace3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleRaceDescription3 = new JLabel("Sample Race Description 3");
        sampleRaceDescription3.setAlignmentX(Component.CENTER_ALIGNMENT);
        raceBox3.add(sampleRace3);
        raceBox3.add(sampleRaceDescription3);
        raceBox3.setBorder(BorderFactory.createLineBorder(Color.black));

        sampleRace3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(sampleRace3)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("Race 3");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPclass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the fourth sample race. Add API later.
        final JPanel raceBox4 = new JPanel();
        raceBox4.setLayout(new BoxLayout(raceBox4, BoxLayout.Y_AXIS));
        sampleRace4 = new JButton("Sample Race 4");
        sampleRace4.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleRaceDescription4 = new JLabel("Sample Race Description 4");
        sampleRaceDescription4.setAlignmentX(Component.CENTER_ALIGNMENT);
        raceBox4.add(sampleRace4);
        raceBox4.add(sampleRaceDescription4);
        raceBox4.setBorder(BorderFactory.createLineBorder(Color.black));

        sampleRace4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(sampleRace4)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("Race 4");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPclass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Place all three class panels in one horizontal panel for nice-looking display.
        final JPanel classes = new JPanel();
        classes.setLayout(new BoxLayout(classes, BoxLayout.X_AXIS));
        classes.add(classBox1);
        classes.add(classBox2);
        classes.add(classBox3);

        // Place all four race panels in one horizontal panel for nice-looking display.
        final JPanel races = new JPanel();
        races.setLayout(new BoxLayout(races, BoxLayout.X_AXIS));
        races.add(raceBox1);
        races.add(raceBox2);
        races.add(raceBox3);
        races.add(raceBox4);

        // Create the close inventory button
        final JPanel buttons = new JPanel();
        next = new JButton("Continue");
        buttons.add(next);

        next.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(next)) {
                            // TODO: make this actually go to next page
                            characterCreationController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(classes_title);
        this.add(classes);
        this.add(races_title);
        this.add(races);
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
        final CharacterCreationState state = (CharacterCreationState) evt.getNewValue();
    }

    public String getViewName() {
        return viewName;
    }

    public void setCharacterCreationController(CharacterCreationController characterCreationController) {
        this.characterCreationController = characterCreationController;
    }
}
