package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Item;
import interface_adapter.merchant.MerchantController;
import interface_adapter.merchant.MerchantState;
import interface_adapter.merchant.MerchantViewModel;

/**
 * The View for when the user interacts with a merchant.
 */
public class MerchantView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "merchant";
    private final MerchantViewModel merchantViewModel;

    private Map<String, List<Item>> itemsMap;
    private List<Item> itemList;

    // Sample items
    private final JLabel sampleItem1;
    private final JLabel sampleDescription1;
    private final JButton sampleBuyButton1;

    private final JLabel sampleItem2;
    private final JLabel sampleDescription2;
    private final JButton sampleBuyButton2;

    private final JLabel sampleItem3;
    private final JLabel sampleDescription3;
    private final JButton sampleBuyButton3;

    private final JButton close;
    private MerchantController merchantController;

    public MerchantView(MerchantViewModel merchantViewModel) {
        this.merchantViewModel = merchantViewModel;
        this.merchantViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Merchant Shop");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add all the items from the state
        this.itemsMap = merchantViewModel.getState().getItems();
        if (itemsMap != null) {
            for (String itemName : itemsMap.keySet()) {
                final List<Item> itemDescriptions = itemsMap.get(itemName);
                itemList.addAll(itemDescriptions);
            }
        }

        // Sample Item 1
        final JPanel itemBox1 = new JPanel();
        itemBox1.setLayout(new BoxLayout(itemBox1, BoxLayout.Y_AXIS));
        sampleItem1 = new JLabel("Sample Item 1");
        sampleItem1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleDescription1 = new JLabel("Sample Description 1");
        sampleDescription1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleBuyButton1 = new JButton("Buy");
        sampleBuyButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleBuyButton1.addActionListener(this);
        sampleBuyButton1.setActionCommand("Sample Item 1");
        itemBox1.add(sampleItem1);
        itemBox1.add(sampleDescription1);
        itemBox1.add(sampleBuyButton1);
        itemBox1.setBorder(BorderFactory.createLineBorder(Color.black));

        // Sample Item 2
        final JPanel itemBox2 = new JPanel();
        itemBox2.setLayout(new BoxLayout(itemBox2, BoxLayout.Y_AXIS));
        sampleItem2 = new JLabel("Sample Item 2");
        sampleItem2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleDescription2 = new JLabel("Sample Description 2");
        sampleDescription2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleBuyButton2 = new JButton("Buy");
        sampleBuyButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleBuyButton2.addActionListener(this);
        sampleBuyButton2.setActionCommand("Sample Item 2");
        itemBox2.add(sampleItem2);
        itemBox2.add(sampleDescription2);
        itemBox2.add(sampleBuyButton2);
        itemBox2.setBorder(BorderFactory.createLineBorder(Color.black));

        // Sample Item 3
        final JPanel itemBox3 = new JPanel();
        itemBox3.setLayout(new BoxLayout(itemBox3, BoxLayout.Y_AXIS));
        sampleItem3 = new JLabel("Sample Item 3");
        sampleItem3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleDescription3 = new JLabel("Sample Description 3");
        sampleDescription3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleBuyButton3 = new JButton("Buy");
        sampleBuyButton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sampleBuyButton3.addActionListener(this);
        sampleBuyButton3.setActionCommand("Sample Item 3");
        itemBox3.add(sampleItem3);
        itemBox3.add(sampleDescription3);
        itemBox3.add(sampleBuyButton3);
        itemBox3.setBorder(BorderFactory.createLineBorder(Color.black));

        // Place all three item panels in one horizontal panel for nice-looking display.
        final JPanel items = new JPanel();
        items.setLayout(new BoxLayout(items, BoxLayout.X_AXIS));
        items.add(itemBox1);
        items.add(itemBox2);
        items.add(itemBox3);

        // Create the close merchant button
        final JPanel buttons = new JPanel();
        close = new JButton("Close");
        buttons.add(close);

        close.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(close)) {
                            // Trigger controller logic for closing the merchant view
                            merchantController.execute(itemsMap);
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(items);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        final String command = evt.getActionCommand();
        if ("Sample Item 1".equals(command)) {
            System.out.println("Buying Sample Item 1");
            // Trigger merchantController logic to handle the purchase
        }
        else if ("Sample Item 2".equals(command)) {
            System.out.println("Buying Sample Item 2");
        }
        else if ("Sample Item 3".equals(command)) {
            System.out.println("Buying Sample Item 3");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final MerchantState state = (MerchantState) evt.getNewValue();
        // Update UI based on state changes
    }

    public String getViewName() {
        return viewName;
    }

    public void setMerchantController(MerchantController merchantController) {
        this.merchantController = merchantController;
    }
}
