package store.service;


import store.creator.StoreCreator;

public class StoreService {

    private final StoreCreator storeCreator;

    public StoreService(StoreCreator storeCreator) {
        this.storeCreator = storeCreator;
    }

}
