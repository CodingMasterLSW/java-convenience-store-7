package store.creator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import store.domain.Product;
import store.domain.Products;
import store.domain.Promotion;
import store.domain.Promotions;
import store.domain.PurchaseProduct;
import store.domain.PurchaseProducts;
import store.domain.Stock;
import store.utils.FileParser;
import store.utils.InputParser;

public class StoreCreator {

    private static final String PROMOTION_FILE_DIRECTORY = "src/main/resources/promotions.md";
    private static final String PRODUCT_FILE_DIRECTORY = "src/main/resources/products.md";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd";

    private StoreCreator() {
    }

    public static StoreCreator create() {
        return new StoreCreator();
    }

    public Promotions createPromotions() {
        List<String> lines = FileParser.readFile(PROMOTION_FILE_DIRECTORY);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        Promotions promotions = Promotions.create();

        for (String line : lines) {
            List<String> promotionInfo = FileParser.parseDelimiter(line);
            Promotion promotion = createPromotion(promotionInfo, formatter);
            promotions.addPromotion(promotion);
        }
        return promotions;
    }

    public Products createProducts(Promotions promotions) {
        List<String> lines = FileParser.readFile(PRODUCT_FILE_DIRECTORY);
        Products products = Products.create();

        for (String line : lines) {
            List<String> productInfo = FileParser.parseDelimiter(line);
            Product product = createProduct(promotions, productInfo);
            products.addProduct(product);
        }
        return products;
    }

    public PurchaseProducts createPurchaseProducts(String userInput) {
        List<String> splitPurchaseProducts = InputParser.parseByDelimiter(userInput);
        PurchaseProducts purchaseProducts = PurchaseProducts.create();

        for (String splitPurchaseProduct : splitPurchaseProducts) {
            List<String> tmpProduct = InputParser.parseAndSubUserInput(splitPurchaseProduct);
            PurchaseProduct purchaseProduct = createPurchaseProduct(tmpProduct);
            purchaseProducts.addPurchaseProduct(purchaseProduct);
        }
        return purchaseProducts;
    }

    private PurchaseProduct createPurchaseProduct(List<String> tmpProduct) {
        String name = tmpProduct.get(0);
        int quantity = Integer.parseInt(tmpProduct.get(1));
        return PurchaseProduct.of(name, quantity);
    }

    private Product createProduct(Promotions promotions, List<String> productInfo) {
        String name = productInfo.get(0);
        int price = Integer.parseInt(productInfo.get(1));
        int quantity = Integer.parseInt(productInfo.get(2));
        Stock stock = Stock.create();
        Promotion promotion = promotions.findPromotionByName(productInfo.get(3));
        Product product = Product.of(name, price, stock, promotion);
        product.addStock(quantity);
        return product;
    }

    private Promotion createPromotion(List<String> promotionInfo, DateTimeFormatter formatter) {
        String name = promotionInfo.get(0);
        int buy = Integer.parseInt(promotionInfo.get(1));
        int get = Integer.parseInt(promotionInfo.get(2));
        LocalDate startDate = LocalDate.parse(promotionInfo.get(3), formatter);
        LocalDate endDate = LocalDate.parse(promotionInfo.get(4), formatter);
        return Promotion.of(name, buy, get, startDate, endDate);
    }

}