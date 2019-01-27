package vending;

class VendingMachineModel {

    private State state;
    private Beverage selectedBeverage;
    private int currentBalance;

    VendingMachineModel() {
        this.state = State.IDLE;
        this.selectedBeverage = Beverage.NOT_SELECTED;
        this.currentBalance = 0;
    }

    State getState() {
        return state;
    }

    void setState(State state) {
        this.state = state;
    }

    Beverage getSelectedBeverage() {
        return selectedBeverage;
    }

    void setSelectedBeverage(Beverage selectedBeverage) {
        this.selectedBeverage = selectedBeverage;
    }

    int getCurrentBalance() {
        return currentBalance;
    }

    void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    void addToBalance(int amount) {
        this.currentBalance += amount;
    }

    void updateStateIfTransactionComplete() {
        if (selectedBeverage != Beverage.NOT_SELECTED && currentBalance >= selectedBeverage.getPrice()) {
            state = State.PURCHASE_COMPLETE;
            System.out.println(String.format("Transaction is complete. Bought %s for %d krones", selectedBeverage, selectedBeverage.getPrice()));
        }
    }

    void calculateBalanceAfterPurchase() {
        currentBalance -= selectedBeverage.getPrice();
        System.out.println(String.format("Giving back change: %d krones", currentBalance));
    }

    void cancel() {
        System.out.println(String.format("Cancelling current transaction. Giving back change: %d krones", currentBalance));
        reset();
    }

    void reset() {
        currentBalance = 0;
        selectedBeverage = Beverage.NOT_SELECTED;
        state = State.IDLE;
        System.out.println("Vending machine is now ready for new purchase\n");
    }
}