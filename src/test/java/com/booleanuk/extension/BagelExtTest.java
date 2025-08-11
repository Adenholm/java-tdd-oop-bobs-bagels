package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelExtTest {
    @Test
    public void testGettingDiscount(){
        Basket basket = new Basket();
        basket.setCapacity(25);
        basket.add("BGLO", 2);
        basket.add("BGLP", 12);
        basket.add("BGLE", 6);
        basket.add("COFB", 3);
        Assertions.assertEquals(9.97f, basket.getDiscountedTotal(), 0.001);
    }

    @Test
    public void testGettingDiscount2(){
        Basket basket = new Basket();
        basket.setCapacity(25);
        basket.add("BGLP", 16);
        Assertions.assertEquals(5.55f, basket.getDiscountedTotal(), 0.001);
    }
}
