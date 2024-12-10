package store.config;

import store.controller.StoreController;
import store.creator.StoreCreator;
import store.service.StoreService;
import store.view.InputView;
import store.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static StoreController createController() {
        return new StoreController(InputView.create(), OutputView.create(), createService());
    }

    public static StoreService createService() {
        return new StoreService(StoreCreator.create());
    }

}
