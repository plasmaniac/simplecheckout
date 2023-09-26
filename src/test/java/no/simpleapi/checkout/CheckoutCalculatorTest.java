package no.simpleapi.checkout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutCalculatorTest {

    @Test
    public void testParseProductList(){
        String testList = "[\"100\",\"101\",\"102\"]";
        CheckoutCalculator calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        assertTrue(calc.getProducts().size()==3);
    }
    @Test
    public void testDiscounts(){
        String testList = "[\"0001\",\"0001\",\"0001\"]";
        CheckoutCalculator calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        float calculated = calc.calculatePrice();
        assertTrue(calculated ==2000);

        testList = "[\"0001\",\"0001\",\"0001\",\"0004\"]";
        calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        calculated = calc.calculatePrice();
        assertTrue(calculated ==2030);

        testList = "[\"0001\",\"0001\",\"0004\"]";
        calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        calculated = calc.calculatePrice();
        assertTrue(calculated ==2030);

        testList = "[\"0001\",\"0003\",\"0002\"]";
        calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        calculated = calc.calculatePrice();
        assertTrue(calculated ==1480);

        testList = "[]";
        calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        calculated = calc.calculatePrice();
        assertTrue(calculated ==0);
    }

    @Test
    public void testShoppingCartWithUnknownProducts(){
        String testList = "[\"0001\",\"0001\",\"0001\"]";
        CheckoutCalculator calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        assertTrue(calc.onlyKnownProducts());

        testList = "[\"0001\",\"0001\",\"3333\"]";
        calc= new CheckoutCalculator(new InMemoryProductStore(), testList);
        assertFalse(calc.onlyKnownProducts());

    }

}
