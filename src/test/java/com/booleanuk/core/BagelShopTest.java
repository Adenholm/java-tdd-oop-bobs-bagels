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

    @Test
    public void testAddingUntilFull(){
        Basket basket = new Basket();
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertEquals(0, basket.add("BGLO"));
        Assertions.assertEquals(5, basket.getItems().size());
    }

    @Test
    public void testChangeBasketStdCapacity(){
        Basket basket = new Basket();
        Assertions.assertEquals(5, basket.getCapacity());
        Basket.setStdCapacity(3);
        Assertions.assertEquals(3, Basket.getStdCapacity());
        Basket basket2 = new Basket();
        Assertions.assertEquals(3, basket2.getCapacity());
    }

    @Test
    public void testTotalPrice(){
        Basket basket = new Basket();
        Assertions.assertEquals(0, basket.getTotalCost());
        basket.add("BGLO");
        Assertions.assertEquals(0.49f, basket.getTotalCost());
        basket.add("BGLO");
        Assertions.assertEquals(0.98f, basket.getTotalCost());
        basket.add("COFB");
        Assertions.assertEquals(1.97f, basket.getTotalCost());
    }

    @Test
    public void testTotalPriceWithFillings(){
        Basket basket = new Basket();
        Assertions.assertEquals(0, basket.getTotalCost());
        basket.add("BGLO");
        Assertions.assertEquals(0.49f, basket.getTotalCost());
        Bagel bagel = (Bagel) Stock.getItem("BGLS");
        Assertions.assertTrue(bagel.addFilling(Stock.getItem("FILE")));
        basket.add(bagel);
        Assertions.assertEquals(1.1f, basket.getTotalCost());
        bagel.addFilling(Stock.getItem("FILE"));
        Assertions.assertEquals(1.22f, basket.getTotalCost());
    }

    @Test
    public void testAddingFilling(){
        Bagel bagel = (Bagel) Stock.getItem("BGLS");
        Assertions.assertTrue(bagel.addFilling(Stock.getItem("FILE")));
        Assertions.assertEquals(1, bagel.getFillings().size());
    }

    @Test
    public void testAddingInvalidFilling(){
        Bagel bagel = (Bagel) Stock.getItem("BGLS");
        Assertions.assertFalse(bagel.addFilling(null));
    }

    @Test
    public void testAddingInvalidItemsToBasket(){
        Basket basket = new Basket();
        Assertions.assertEquals(-1, basket.add("BGLH"));
        Assertions.assertTrue(basket.getItems().isEmpty());
        Assertions.assertEquals(-1, basket.add((Item) null));
        Assertions.assertTrue(basket.getItems().isEmpty());
    }
}