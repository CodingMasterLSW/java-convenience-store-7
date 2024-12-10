package store.domain;

public class PurchaseResult {

    private final Product product;
    private int quantity;

    private PurchaseResult(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public static PurchaseResult of(Product product, int quantity) {
        return new PurchaseResult(product, quantity);
    }

    public String getProductName() {
        return product.getName();
    }

    public int getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
