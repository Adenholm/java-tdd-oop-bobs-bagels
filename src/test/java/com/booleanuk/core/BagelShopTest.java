package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelShopTest {
    @Test
    public void testAddingBagelToBasket(){
        Basket basket = new Basket();
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertFalse(basket.getItems().isEmpty());
    }

    @Test
    public void testRemovingBagel(){
        Basket basket = new Basket();
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertFalse(basket.remove("BGRF"));
        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertTrue(basket.getItems().isEmpty());
    }
}