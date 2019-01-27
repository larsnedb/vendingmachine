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

    VendingMachineView() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Welcome! Please choose your drink");
        label.setBounds(300, 20, 300, 30);
        label.setVisible(true);

        container.add(label);

        JPanel drinkPanel = createDrinkPanel();
        JPanel moneyPanel = createMoneyPanel();
        container.add(drinkPanel);
        container.add(moneyPanel);

        frame.setSize(new Dimension(900, 600));
        frame.add(container);
        frame.setVisible(true);

    }

    private JPanel createDrinkPanel() {
        JPanel panel = new JPanel();

        JButton water = new JButton("Water");
        JButton soda = new JButton("Soda");
        JButton beer = new JButton("Beer");

        JLabel priceLabel = new JLabel("Price in NOK");

        JTextField priceField = new JTextField("0");
        priceField.setColumns(3);

        panel.add(water);
        panel.add(soda);
        panel.add(beer);
        panel.add(priceLabel);
        panel.add(priceField);
        return panel;
    }

    private JPanel createMoneyPanel() {
        JPanel panel = new JPanel();

        JButton oneKrone = new JButton("1");
        JButton fiveKroner = new JButton("5");
        JButton tenKroner = new JButton("10");
        JButton twentyKroner = new JButton("20");

        JLabel balanceLabel = new JLabel("Current balance in NOK");

        JTextField balanceField = new JTextField("0");
        balanceField.setColumns(3);

        panel.add(oneKrone);
        panel.add(fiveKroner);
        panel.add(tenKroner);
        panel.add(twentyKroner);
        panel.add(balanceLabel);
        panel.add(balanceField);

        return panel;
    }
}
