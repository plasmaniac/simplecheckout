package no.simpleapi.checkout;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CheckoutCalculator {

    private List<String> products;
    IProductStore store;

    public CheckoutCalculator(IProductStore store, String input) {
        this.store=store;
        this.products = toList(input);
    }

    public boolean onlyKnownProducts(){
        List<String> unknownProducts = products
                .stream()
                .filter(c -> store.getProductDetails(c)==null)
                .collect(Collectors.toList());
        return unknownProducts.size()==0;
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

    public float calculatePrice(){
        float price = 0;
        Map<String, Integer> shoppingCart = new HashMap<>();
        for(String key: products){
            if(shoppingCart.get(key)==null)
                shoppingCart.put(key, 1);
            else
                shoppingCart.put(key, shoppingCart.get(key)+1);
        }
        Set<String> keys = shoppingCart.keySet();
        for (String key : keys){
            price += calcProductPrice(key, shoppingCart.get(key));
        }
        return price;
    }

    private float calcProductPrice(String key, Integer count) {
        float price = 0;
        ProductDefinition productDetails = store.getProductDetails(key);
        Discount discount = productDetails.rule;
        if(discount !=null){ // this product has a discount
            int rounds = count / discount.threshold; // how many rounds of discount
            price += rounds * discount.price;
            price += (count % discount.threshold) * productDetails.price;// then the ones not eligible for discount
        } else {
            price += count * productDetails.price; // simple case: number of items * itemprice
        }
        return price;
    }

}
