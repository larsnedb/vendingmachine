package vending;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineController implements ActionListener {

    private final VendingMachineModel model;
    private final VendingMachineView view;

    VendingMachineController(VendingMachineModel model, VendingMachineView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("Cancel".equals(actionCommand)) {
            model.cancel();
            resetVendingMachine();
            return;
        }

        if (model.getState() != State.ONGOING_TRANSACTION) {
            model.setState(State.ONGOING_TRANSACTION);
        }

        Beverage beverage = getBeverageType(actionCommand);
        if (beverage != Beverage.NOT_SELECTED) {
            model.setSelectedBeverage(beverage);
            view.setPriceField(String.valueOf(beverage.getPrice()));
            model.updateStateIfTransactionComplete();
        }

        int krones = getKrones(actionCommand);
        if (krones != 0) {
            model.addToBalance(krones);
            view.setBalanceField(String.valueOf(model.getCurrentBalance()));
            model.updateStateIfTransactionComplete();
        }

        if (model.getState() == State.PURCHASE_COMPLETE) {
            model.calculateBalanceAfterPurchase();
            model.setState(State.RESET);
            model.reset();
            resetVendingMachine();
        }
    }

    private void resetVendingMachine() {
        view.setBalanceField(String.valueOf(model.getCurrentBalance()));
        view.setPriceField(String.valueOf(model.getSelectedBeverage().getPrice()));
    }

    private Beverage getBeverageType(String command) {
        Beverage beverage;
        switch (command) {
            case "Water":
                beverage = Beverage.WATER;
                break;
            case "Soda":
                beverage = Beverage.SODA;
                break;
            case "Beer":
                beverage = Beverage.BEER;
                break;
            default:
                beverage = Beverage.NOT_SELECTED;
        }
        return beverage;
    }

    private int getKrones(String command) {
        int amount;
        switch (command) {
            case "1":
                amount = 1; break;
            case "5":
                amount = 5; break;
            case "10":
                amount = 10; break;
            case "20":
                amount = 20; break;
            default:
                amount = 0;
        }
        return amount;
    }
}