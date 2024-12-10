package store.domain;

public class Stock {

    private int promotionStock;
    private int normalStock;

    private Stock() {
        this.promotionStock = 0;
        this.normalStock = 0;
    }

    public static Stock create() {
        return new Stock();
    }

    public void addNormalStock(int quantity) {
        this.normalStock += quantity;
    }

    public void addPromotionStock(int quantity) {
        this.promotionStock += quantity;
    }

    public int getPromotionStock() {
        return promotionStock;
    }

    public int getNormalStock() {
        return normalStock;
    }
}
