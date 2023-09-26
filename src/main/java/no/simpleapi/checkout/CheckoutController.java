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
        float price = 0;
        CheckoutResponse checkoutResponse = new CheckoutResponse(price);
        return checkoutResponse;
    }

    public static class CheckoutResponse {
        double price;

        public double getPrice() {
            return price;
        }
        public CheckoutResponse(double price) {
            this.price = price;
        }
    }
}
