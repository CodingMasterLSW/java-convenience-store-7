package store.domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public Product findProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
