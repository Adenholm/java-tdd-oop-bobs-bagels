package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Stock {
    static private List<Item> stock = Arrays.asList(
            new Item("BGLO", 0.49f, "Bagel", "Onion"),
            new Item("BGLP", 0.39f, "Bagel", "Plain"),
            new Item("BGLE", 0.49f, "Bagel", "Everything"),
            new Item("BGLS", 0.49f, "Bagel", "Sesame"),
            new Item("COFB", 0.99f, "Coffee", "Black"),
            new Item("COFW", 1.19f, "Coffee", "White"),
            new Item("COFC", 1.29f, "Coffee", "Cappuccino"),
            new Item("COFL", 1.29f, "Coffee", "Latte"),
            new Item("FILB", 0.12f, "Filling", "Bacon"),
            new Item("FILE", 0.12f, "Filling", "Egg"),
            new Item("FILC", 0.12f, "Filling", "Cheese"),
            new Item("FILX", 0.12f, "Filling", "Cream Cheese"),
            new Item("FILS", 0.12f, "Filling", "Smoked Salmon"),
            new Item("FILH", 0.12f, "Filling", "Ham"));


    public static List<Item> getStock() {
        return stock;
    }

    public static void setStock(List<Item> stock) {
        Stock.stock = stock;
    }

    public static boolean isInStock(String sku) {
        for (Item item: stock){
            if (item.getSku().equals(sku)){
                return true;
            }
        }
        return false;
    }

    public static Item getItem(String sku) {
        for (Item item: stock){
            if (item.getSku().equals(sku)){
                return item;
            }
        }
        return null;
    }
}