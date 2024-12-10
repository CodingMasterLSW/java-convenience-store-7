package store.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseProducts {

    private final List<PurchaseProduct> purchaseProducts;

    private PurchaseProducts() {
        this.purchaseProducts = new ArrayList<>();
    }

    public static PurchaseProducts create() {
        return new PurchaseProducts();
    }

    public void addPurchaseProduct(PurchaseProduct purchaseProduct) {
        purchaseProducts.add(purchaseProduct);
    }

    public List<PurchaseProduct> getPurchaseProducts() {
        return Collections.unmodifiableList(purchaseProducts);
    }

}
