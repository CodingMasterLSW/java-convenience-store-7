package store.controller;

import store.domain.Products;
import store.domain.Promotions;
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
    }

}
