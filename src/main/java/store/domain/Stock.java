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

    public void decreasePromotionStock(int quantity) {
        this.promotionStock -= quantity;
    }

    public void decreaseNormalStock(int quantity) {
        this.normalStock -= quantity;
    }

    public int getPromotionStock() {
        return promotionStock;
    }

    public int getNormalStock() {
        return normalStock;
    }

    public boolean isEnoughStock(int quantity) {
        if (promotionStock+normalStock >= quantity) {
            return true;
        }
        return false;
    }
}
