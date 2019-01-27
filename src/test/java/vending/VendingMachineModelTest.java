package vending;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendingMachineModelTest {

    private final VendingMachineModel model = new VendingMachineModel();

    @Test
    public void should_not_complete_purchase_if_drink_is_not_chosen() {
        model.setState(State.ONGOING_TRANSACTION);
        model.setCurrentBalance(100);

        model.updateStateIfTransactionComplete();

        assertSame(State.ONGOING_TRANSACTION, model.getState());
    }

    @Test
    public void should_not_change_state_if_balance_is_insufficient() {
        model.setState(State.ONGOING_TRANSACTION);
        model.setSelectedBeverage(Beverage.WATER);
        model.setCurrentBalance(0);

        model.updateStateIfTransactionComplete();

        assertSame(State.ONGOING_TRANSACTION, model.getState());
    }

    @Test
    public void should_complete_purchase_if_sufficient_balance() {
        model.setState(State.ONGOING_TRANSACTION);
        model.setSelectedBeverage(Beverage.WATER);
        model.setCurrentBalance(10);

        model.updateStateIfTransactionComplete();

        assertSame(State.PURCHASE_COMPLETE, model.getState());
    }
}