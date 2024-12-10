package store.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private final List<Product> products;

    private Products() {
        this.products = new ArrayList<>();
    }

    public static Products create() {
        return new Products();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
