package no.simpleapi.checkout;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CheckoutController {

    @PostMapping
    @RequestMapping("/checkout")
    public CheckoutResponse checkout(@RequestBody String input) {
        CheckoutCalculator checkoutCalculator = new CheckoutCalculator(new InMemoryProductStore(), input);
        if(!checkoutCalculator.onlyKnownProducts())
            return new CheckoutResponse(0, "Invalid shopping cart"); //error, lets
        float price = checkoutCalculator.calculatePrice();
        CheckoutResponse checkoutResponse = new CheckoutResponse(price);
        return checkoutResponse;
    }

    public static class CheckoutResponse {
        double price;

        String error; //non-null when error

        public String getError() {
            return error;
        }

        public double getPrice() {
            return price;
        }
        public CheckoutResponse(double price) {
            this.price = price;
        }

        public CheckoutResponse(double price, String error) {
            this.price = price;
            this.error = error;
        }
    }
}
