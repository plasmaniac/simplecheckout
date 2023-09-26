package no.simpleapi.checkout;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductStore implements IProductStore {

    Map<String, ProductDefinition> products = new HashMap<>();

    public InMemoryProductStore() {
        ProductDefinition

    }

    @Override
    public ProductDefinition getProductDetails(String productId) {
        return null;
    }
}
