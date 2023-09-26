package no.simpleapi.checkout;

public class ProductDefinition {
    String productId;
    String productName;
    float price;
    Discount rule;

    public ProductDefinition(String productId, String productName, float price, Discount rule) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.rule = rule;
    }
}
