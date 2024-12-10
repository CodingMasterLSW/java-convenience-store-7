package store.controller;

import java.util.function.Supplier;
import store.domain.Products;
import store.domain.Promotions;
import store.domain.PurchaseProduct;
import store.domain.PurchaseProducts;
import store.domain.PurchaseResult;
import store.domain.PurchaseResults;
import store.service.StoreService;
import store.view.InputView;
import store.view.OutputView;

public class StoreController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StoreService storeService;

    public StoreController(InputView inputView, OutputView outputView, StoreService storeService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.storeService = storeService;
    }

    public void start() {
        Promotions promotions = storeService.createPromotions();
        Products products = storeService.createProducts(promotions);
        outputView.printHelloMessage();
        outputView.showCurrentProduct(products);


        retryOnInvalidInput(() -> {
            String userInput = inputView.purchaseInput();
            PurchaseProducts purchaseProducts = storeService.createPurchaseProducts(userInput);
            PurchaseResults purchaseResults = storeService.buy(products, purchaseProducts);
            outputView.printReceipt(purchaseResults);
            return null;
        });
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
