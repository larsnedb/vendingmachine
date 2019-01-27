package vending;

class VendingMachineModel {

    private final State state;
    private final Beverage selectedBeverage;
    private final int currentBalance;

    VendingMachineModel() {
        this.state = State.IDLE;
        this.selectedBeverage = Beverage.NOT_SELECTED;
        this.currentBalance = 0;
    }

    public State getState() {
        return state;
    }

    public Beverage getSelectedBeverage() {
        return selectedBeverage;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}