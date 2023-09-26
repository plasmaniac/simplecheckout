package no.simpleapi.checkout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CheckoutCalculator {

    private List<String> products;

    public CheckoutCalculator(String input) {
        this.products = toList(input);
    }

    private List<String> toList(String input) {
        if(!input.startsWith("[") || !input.endsWith("]"))
            throw new IllegalArgumentException(String.format("Wrong format: %s",input));
        String[] strings = new Gson().fromJson(input, String[].class);
        return Arrays.asList(strings);
    }

    public List<String> getProducts() {
        return products;
    }

}
