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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.open_inventory.OpenInventoryController;
import interface_adapter.open_inventory.OpenInventoryState;
import interface_adapter.open_inventory.OpenInventoryViewModel;

/**
 * The View for when the user is on the open inventory
 */
public class OpenInventoryView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "open inventory";
    private final OpenInventoryViewModel openInventoryViewModel;

//    private final JTextField usernameInputField = new JTextField(15);
//    private final JLabel usernameErrorField = new JLabel();
//
//    private final JPasswordField passwordInputField = new JPasswordField(15);
//    private final JLabel passwordErrorField = new JLabel();
//
//    private final JButton logIn;
//    private final JButton cancel;

    private final JButton close;
    private OpenInventoryController openInventoryController;

    public OpenInventoryView(OpenInventoryViewModel openInventoryViewModel) {

        this.openInventoryViewModel = openInventoryViewModel;
        this.openInventoryViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Inventory Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

//        final LabelTextPanel usernameInfo = new LabelTextPanel(
//                new JLabel("Username"), usernameInputField);
//        final LabelTextPanel passwordInfo = new LabelTextPanel(
//                new JLabel("Password"), passwordInputField);
//
//        final JPanel buttons = new JPanel();
//        logIn = new JButton("log in");
//        buttons.add(logIn);
//        cancel = new JButton("cancel");
//        buttons.add(cancel);

        final JPanel buttons = new JPanel();
        close = new JButton("Close");
        buttons.add(close);

        close.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(close)) {
                            final OpenInventoryState currentState = openInventoryViewModel.getState();

                            openInventoryController.execute( );
                        }
                    }
                }
        );

//        cancel.addActionListener(this);
//
//        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {
//
//            private void documentListenerHelper() {
//                final LoginState currentState = loginViewModel.getState();
//                currentState.setUsername(usernameInputField.getText());
//                loginViewModel.setState(currentState);
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
//
//            private void documentListenerHelper() {
//                final LoginState currentState = loginViewModel.getState();
//                currentState.setPassword(new String(passwordInputField.getPassword()));
//                loginViewModel.setState(currentState);
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//        });

        this.add(title);
//        this.add(usernameInfo);
//        this.add(usernameErrorField);
//        this.add(passwordInfo);
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
        final OpenInventoryState state = (OpenInventoryState) evt.getNewValue();
        setFields(state);
//        usernameErrorField.setText(state.getLoginError());
    }

    private void setFields(OpenInventoryState state) {
//        usernameInputField.setText(state.getUsername());
//        passwordInputField.setText(state.getPassword());
    }

    public String getViewName() {
        return viewName;
    }

    public void setOpenInventoryController(OpenInventoryController openInventoryController) {
        this.openInventoryController = openInventoryController;
    }
}
