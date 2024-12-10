package store.domain;

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
