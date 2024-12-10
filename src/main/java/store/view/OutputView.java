package store.view;

import store.domain.Product;
import store.domain.Products;
import store.domain.PurchaseResult;
import store.domain.PurchaseResults;

public class OutputView {

    private static final String HELLO_MESSAGE = "안녕하세요. W편의점입니다.";
    private static final String CURRENT_CONTAIN_PRODUCT_MESSAGE = "현재 보유하고 있는 상품입니다.";
    private static final String CURRENT_PRODUCT = "- %s %,d원 %,d개 %s";
    private static final String CURRENT_PRODUCT_NOT_STOCK = "- %s %,d원 %s";
    private static final String STORE_MESSAGE = "==============W 편의점================";
    private static final String RECEIPT_SCHEMA = "상품명        수량     금액";
    private static final String RECEIPT_INFO = "%s       %,d    %,d";

    private static final String BLANK = "";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printHelloMessage() {
        printMessage(HELLO_MESSAGE);
        printMessage(CURRENT_CONTAIN_PRODUCT_MESSAGE);
    }

    public void showCurrentProduct(Products products) {
        printMessage(BLANK);
        for (Product product : products.getProducts()) {
            if (product.getPromotion() == null) {
                if (product.getStock().getNormalStock() == 0) {
                    System.out.printf(CURRENT_PRODUCT_NOT_STOCK, product.getName(),
                            product.getPrice(), "재고 없음", "");
                    printMessage(BLANK);
                    continue;
                }
                System.out.printf(CURRENT_PRODUCT, product.getName(), product.getPrice(),
                        product.getStock().getNormalStock(), "");
                printMessage(BLANK);
                continue;
            }
            if (product.getStock().getPromotionStock() == 0) {
                System.out.printf(CURRENT_PRODUCT_NOT_STOCK, product.getName(), product.getPrice(),
                        "재고 없음", product.getPromotion().getName());
                printMessage(BLANK);
                continue;
            }
            System.out.printf(CURRENT_PRODUCT, product.getName(), product.getPrice(),
                    product.getStock().getPromotionStock(), product.getPromotion().getName());
            printMessage(BLANK);
        }
    }

    public void printReceipt(PurchaseResults purchaseResults) {
        printMessage(STORE_MESSAGE);
        printMessage(RECEIPT_SCHEMA);
        for (PurchaseResult purchaseResult : purchaseResults.getPurchaseResults()) {
            System.out.printf(RECEIPT_INFO, purchaseResult.getProductName(),
                    purchaseResult.getQuantity(), purchaseResult.getTotalPrice());
            printMessage(BLANK);
        }
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
