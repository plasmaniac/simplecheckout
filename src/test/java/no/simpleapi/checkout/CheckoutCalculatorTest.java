package no.simpleapi.checkout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutCalculatorTest {

    @Test
    public void testParseProductList(){
        String testList = "[\"100\",\"101\",\"102\"]";
        CheckoutCalculator calc= new CheckoutCalculator(testList);
        assertTrue(calc.getProducts().size()==3);
    }

}
