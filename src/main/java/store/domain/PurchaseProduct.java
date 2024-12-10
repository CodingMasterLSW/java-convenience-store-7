package store.domain;

public class PurchaseProduct {

    private final String name;
    private int quantity;

    private PurchaseProduct(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static PurchaseProduct of(String name, int quantity) {
        return new PurchaseProduct(name, quantity);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
