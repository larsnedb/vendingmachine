package vending;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class VendingMachineView extends JPanel {

    private final JFrame frame = new JFrame("Vending machine");
    private final JTextField priceField = new JTextField("0");
    private final JTextField balanceField = new JTextField("0");


    void createView() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JLabel label = createWelcomeLabel();

        VendingMachineModel model = new VendingMachineModel();
        VendingMachineController controller = new VendingMachineController(model, this);
        JPanel drinkPanel = createDrinkPanel(controller);
        JPanel moneyPanel = createMoneyPanel(controller);
        JButton cancel = createCancelButton(model);

        container.add(label);
        container.add(drinkPanel);
        container.add(moneyPanel);
        container.add(cancel);

        frame.setSize(new Dimension(900, 600));
        frame.add(container);
        frame.setVisible(true);

    }

    private JButton createCancelButton(VendingMachineModel model) {
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new VendingMachineController(model, this));
        return cancel;
    }

    private JLabel createWelcomeLabel() {
        JLabel label = new JLabel("Welcome! Please choose your drink");
        label.setBounds(300, 20, 300, 30);
        label.setVisible(true);
        return label;
    }

    private JPanel createDrinkPanel(VendingMachineController controller) {
        JPanel panel = new JPanel();

        JButton water = new JButton("Water");
        JButton soda = new JButton("Soda");
        JButton beer = new JButton("Beer");

        water.addActionListener(controller);
        soda.addActionListener(controller);
        beer.addActionListener(controller);

        JLabel priceLabel = new JLabel("Price in NOK");

        priceField.setColumns(3);

        panel.add(water);
        panel.add(soda);
        panel.add(beer);
        panel.add(priceLabel);
        panel.add(priceField);
        return panel;
    }

    private JPanel createMoneyPanel(VendingMachineController controller) {
        JPanel panel = new JPanel();

        JButton oneKrone = new JButton("1");
        JButton fiveKroner = new JButton("5");
        JButton tenKroner = new JButton("10");
        JButton twentyKroner = new JButton("20");

        oneKrone.addActionListener(controller);
        fiveKroner.addActionListener(controller);
        tenKroner.addActionListener(controller);
        twentyKroner.addActionListener(controller);


        JLabel balanceLabel = new JLabel("Current balance in NOK");
        balanceField.setColumns(3);

        panel.add(oneKrone);
        panel.add(fiveKroner);
        panel.add(tenKroner);
        panel.add(twentyKroner);
        panel.add(balanceLabel);
        panel.add(balanceField);

        return panel;
    }

    void setPriceField(String price) {
        this.priceField.setText(price);
    }

    void setBalanceField(String balance) {
        this.balanceField.setText(balance);
    }
}
