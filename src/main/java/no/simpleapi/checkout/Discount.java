package no.simpleapi.checkout;

public class Discount {
    int threshold;
    float price;

    public Discount(int threshold, float price) {
        this.threshold = threshold;
        this.price = price;
    }
}
