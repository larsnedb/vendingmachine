package vending;

public enum Beverage {

    WATER(10),
    SODA(25),
    BEER(45),
    NOT_SELECTED(0);

    private final int price;

    Beverage(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
