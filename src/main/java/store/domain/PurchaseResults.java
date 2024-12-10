package store.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseResults {

    private final List<PurchaseResult> purchaseResults;

    private PurchaseResults() {
        this.purchaseResults = new ArrayList<>();
    }

    public static PurchaseResults create() {
        return new PurchaseResults();
    }

    public void addPurchaseResult(PurchaseResult purchaseResult) {
        purchaseResults.add(purchaseResult);
    }

    public List<PurchaseResult> getPurchaseResults() {
        return Collections.unmodifiableList(purchaseResults);
    }
}
