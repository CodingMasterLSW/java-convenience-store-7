package store.service;


import store.creator.StoreCreator;
import store.domain.Product;
import store.domain.Products;
import store.domain.Promotions;
import store.domain.PurchaseProduct;
import store.domain.PurchaseProducts;
import store.domain.PurchaseResult;
import store.domain.PurchaseResults;

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

    public PurchaseResults buy(Products products, PurchaseProducts purchaseProducts) {
        PurchaseResults purchaseResults = PurchaseResults.create();
        for (PurchaseProduct purchaseProduct : purchaseProducts.getPurchaseProducts()) {
            Product product = products.findProductByName(purchaseProduct.getName());
            int purchaseQuantity = purchaseProduct.getQuantity();
            product.validatePurchase(purchaseQuantity);
            product.decreaseStock(purchaseQuantity);
            PurchaseResult purchaseResult = PurchaseResult.of(product, purchaseQuantity);
            purchaseResults.addPurchaseResult(purchaseResult);
        }
        return purchaseResults;
    }

}
