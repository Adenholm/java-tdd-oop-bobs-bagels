package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelShopTest {
    @Test
    public void testAddingBagelToBasket(){
        Basket basket = new Basket(5);
        Assertions.assertTrue(basket.add("BGLO");
        Assertions.assertFalse(basket.getItems.isEmpty());
    }
}