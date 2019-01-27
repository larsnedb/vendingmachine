package vending;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VendingMachineModelTest {

    private final VendingMachineModel model = new VendingMachineModel();

    @Test
    public void should_add_coin_insert_to_total_balance() {
        model.setCurrentBalance(100);

        model.addToBalance(50);

        assertEquals(150, model.getCurrentBalance());
    }

    @Test
    public void should_not_complete_purchase_if_drink_is_not_chosen() {
        model.setState(State.ONGOING_TRANSACTION);
        model.setCurrentBalance(100);

        model.updateStateIfTransactionComplete();

        assertEquals(State.ONGOING_TRANSACTION, model.getState());
    }

    @Test
    public void should_not_change_state_if_balance_is_insufficient() {
        model.setState(State.ONGOING_TRANSACTION);
        model.setSelectedBeverage(Beverage.WATER);
        model.setCurrentBalance(0);

        model.updateStateIfTransactionComplete();

        assertEquals(State.ONGOING_TRANSACTION, model.getState());
    }

    @Test
    public void should_complete_purchase_if_sufficient_balance() {
        model.setState(State.ONGOING_TRANSACTION);
        model.setSelectedBeverage(Beverage.WATER);
        model.setCurrentBalance(10);

        model.updateStateIfTransactionComplete();

        assertEquals(State.PURCHASE_COMPLETE, model.getState());
    }

    @Test
    public void should_calculate_balance_after_complete_purchase() {
        model.setState(State.PURCHASE_COMPLETE);
        model.setCurrentBalance(50);
        model.setSelectedBeverage(Beverage.BEER);

        model.calculateBalanceAfterPurchase();

        assertEquals(5, model.getCurrentBalance());
    }

    @Test
    public void should_reset_machine_after_complete_purhcase() {
        model.setState(State.PURCHASE_COMPLETE);
        model.setCurrentBalance(50);
        model.setSelectedBeverage(Beverage.BEER);

        model.reset();

        assertEquals(State.IDLE, model.getState());
        assertEquals(0, model.getCurrentBalance());
        assertEquals(Beverage.NOT_SELECTED, model.getSelectedBeverage());
    }

    @Test
    public void should_reset_machine_when_transaction_cancelled() {
        model.setState(State.PURCHASE_COMPLETE);
        model.setCurrentBalance(50);
        model.setSelectedBeverage(Beverage.BEER);

        model.cancel();

        assertEquals(State.IDLE, model.getState());
        assertEquals(0, model.getCurrentBalance());
        assertEquals(Beverage.NOT_SELECTED, model.getSelectedBeverage());
    }
}