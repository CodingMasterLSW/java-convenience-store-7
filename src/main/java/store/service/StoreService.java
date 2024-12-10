package store.service;


import store.creator.StoreCreator;
import store.domain.Products;
import store.domain.Promotions;
import store.domain.PurchaseProducts;

public class StoreService {

    private final StoreCreator storeCreator;

    public StoreService(StoreCreator storeCreator) {
        this.storeCreator = storeCreator;
    }

    public Promotions createPromotions() {
        return storeCreator.createPromotions();
    }

    public Products createProducts(Promotions promotions) {
        return storeCreator.createProducts(promotions);
    }

    public PurchaseProducts createPurchaseProducts(String userInput) {
        return storeCreator.createPurchaseProducts(userInput);
    }

}
