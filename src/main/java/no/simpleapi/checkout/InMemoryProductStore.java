package no.simpleapi.checkout;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductStore implements IProductStore {

    Map<String, ProductDefinition> products = new HashMap<>();

    public InMemoryProductStore() {
        products.put("0001", new ProductDefinition("0001","Rolex Watch", 1000, new Discount(3, 2000)));
        products.put("0002", new ProductDefinition("0002","Michael Kors Purse", 80, new Discount(2, 120)));
        products.put("0003", new ProductDefinition("0003","Rolex Watch", 400, null));
        products.put("0004", new ProductDefinition("0004","Rolex Watch", 30, null));
    }

    @Override
    public ProductDefinition getProductDetails(String productId) {
        return products.get(productId);
    }
}
