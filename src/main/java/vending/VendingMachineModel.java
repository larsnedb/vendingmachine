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

    public Beverage getSelectedBeverage() {
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
            System.out.println("Transaction is complete");
        }
    }
}