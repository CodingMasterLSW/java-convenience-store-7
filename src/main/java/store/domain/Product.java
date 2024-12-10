package store.domain;

import static store.exception.ErrorMessage.OVER_STOCK_PURCHASE;

public class Product {

    private final String name;
    private final int price;
    private final Stock stock;
    private final Promotion promotion;

    private Product(String name, int price, Stock stock, Promotion promotion) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.promotion = promotion;
    }

    public static Product of(String name, int price, Stock stock, Promotion promotion) {
        return new Product(name, price, stock, promotion);
    }

    public void addStock(int quantity) {
        if (promotion == null) {
            stock.addNormalStock(quantity);
            return;
        }
        stock.addPromotionStock(quantity);
    }

    public void validatePurchase(int quantity) {
        if (!stock.isEnoughStock(quantity)) {
            throw new IllegalArgumentException(OVER_STOCK_PURCHASE.getMessage());
        }
    }

    public void decreaseStock(int quantity) {
        if (promotion == null) {
            stock.decreaseNormalStock(quantity);
            return;
        }
        stock.decreasePromotionStock(quantity);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Stock getStock() {
        return stock;
    }

    public Promotion getPromotion() {
        return promotion;
    }
}
