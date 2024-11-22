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
    private final JButton barbarian;
    private final JButton rogue;
    private final JButton cleric;
    private final JLabel barbarianDescription;
    private final JLabel rogueDescription;
    private final JLabel clericDescription;
    // Four sample races
    private final JButton human;
    private final JButton dwarf;
    private final JButton elf;
    private final JButton gnome;
    private final JLabel humanDescription;
    private final JLabel dwarfDescription;
    private final JLabel elfDescription;
    private final JLabel gnomeDescription;

    private final JButton next;
    private CharacterCreationController characterCreationController;

    public CharacterCreationView(CharacterCreationViewModel characterCreationViewModel) {

        this.characterCreationViewModel = characterCreationViewModel;
        this.characterCreationViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Character Creation Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel classes_title = new JLabel("Select Class");
        classes_title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO refactor all classes to one createClass(String className) method
        final JPanel barbarianBox = new JPanel();
        barbarianBox.setLayout(new BoxLayout(barbarianBox, BoxLayout.Y_AXIS));
        barbarianBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        barbarian = new JButton("Barbarian");
        barbarian.setAlignmentX(Component.CENTER_ALIGNMENT);
        barbarianDescription = new JLabel("Barbarian Description");
        barbarianDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        barbarianBox.add(barbarian);
        barbarianBox.add(barbarianDescription);
        barbarianBox.setBorder(BorderFactory.createLineBorder(Color.black));

        barbarian.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(barbarian)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPClass("barbarian");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPClass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the second sample class. Add API later.
        final JPanel rogueBox = new JPanel();
        rogueBox.setLayout(new BoxLayout(rogueBox, BoxLayout.Y_AXIS));
        rogueBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        rogue = new JButton("Rogue");
        rogue.setAlignmentX(Component.CENTER_ALIGNMENT);
        rogueDescription = new JLabel("Rogue Description");
        rogueDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        rogueBox.add(rogue);
        rogueBox.add(rogueDescription);
        rogueBox.setBorder(BorderFactory.createLineBorder(Color.black));

        rogue.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(rogue)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPClass("rogue");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPClass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the third sample class. Add API later.
        final JPanel clericBox = new JPanel();
        clericBox.setLayout(new BoxLayout(clericBox, BoxLayout.Y_AXIS));
        clericBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        cleric = new JButton("Cleric");
        cleric.setAlignmentX(Component.CENTER_ALIGNMENT);
        clericDescription = new JLabel("Cleric Description");
        clericDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        clericBox.add(cleric);
        clericBox.add(clericDescription);
        clericBox.setBorder(BorderFactory.createLineBorder(Color.black));

        cleric.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cleric)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPClass("cleric");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPClass(), currentState.getPRace());
                        }
                    }
                }
        );

        final JLabel races_title = new JLabel("Select Race");
        races_title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO refactor all race creation to one createRace(String raceName) method
        final JPanel humanBox = new JPanel();
        humanBox.setLayout(new BoxLayout(humanBox, BoxLayout.Y_AXIS));
        human = new JButton("Human");
        human.setAlignmentX(Component.CENTER_ALIGNMENT);
        humanDescription = new JLabel("Human Description");
        humanDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        humanBox.add(human);
        humanBox.add(humanDescription);
        humanBox.setBorder(BorderFactory.createLineBorder(Color.black));

        human.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(human)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("human");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPClass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the second sample race. Add API later.
        final JPanel dwarfBox = new JPanel();
        dwarfBox.setLayout(new BoxLayout(dwarfBox, BoxLayout.Y_AXIS));
        dwarf = new JButton("Dwarf");
        dwarf.setAlignmentX(Component.CENTER_ALIGNMENT);
        dwarfDescription = new JLabel("Dwarf Description");
        dwarfDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        dwarfBox.add(dwarf);
        dwarfBox.add(dwarfDescription);
        dwarfBox.setBorder(BorderFactory.createLineBorder(Color.black));

        dwarf.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(dwarf)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("dwarf");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPClass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the third sample race. Add API later.
        final JPanel elfBox = new JPanel();
        elfBox.setLayout(new BoxLayout(elfBox, BoxLayout.Y_AXIS));
        elf = new JButton("Elf");
        elf.setAlignmentX(Component.CENTER_ALIGNMENT);
        elfDescription = new JLabel("Elf Description");
        elfDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        elfBox.add(elf);
        elfBox.add(elfDescription);
        elfBox.setBorder(BorderFactory.createLineBorder(Color.black));

        elf.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(elf)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("elf");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPClass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Create panel for the fourth sample race. Add API later.
        final JPanel raceBox4 = new JPanel();
        raceBox4.setLayout(new BoxLayout(raceBox4, BoxLayout.Y_AXIS));
        gnome = new JButton("Gnome");
        gnome.setAlignmentX(Component.CENTER_ALIGNMENT);
        gnomeDescription = new JLabel("Gnome Description");
        gnomeDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        raceBox4.add(gnome);
        raceBox4.add(gnomeDescription);
        raceBox4.setBorder(BorderFactory.createLineBorder(Color.black));

        gnome.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(gnome)) {
                            final CharacterCreationState currentState = characterCreationViewModel.getState();
                            currentState.setPRace("gnome");
                            characterCreationViewModel.setState(currentState);

                            characterCreationController.execute(currentState.getPClass(), currentState.getPRace());
                        }
                    }
                }
        );

        // Place all three class panels in one horizontal panel for nice-looking display.
        final JPanel classes = new JPanel();
        classes.setLayout(new BoxLayout(classes, BoxLayout.X_AXIS));
        classes.add(barbarianBox);
        classes.add(rogueBox);
        classes.add(clericBox);

        // Place all four race panels in one horizontal panel for nice-looking display.
        final JPanel races = new JPanel();
        races.setLayout(new BoxLayout(races, BoxLayout.X_AXIS));
        races.add(humanBox);
        races.add(dwarfBox);
        races.add(elfBox);
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
