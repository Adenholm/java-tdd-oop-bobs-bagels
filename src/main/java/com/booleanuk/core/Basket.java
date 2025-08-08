package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();
    private int capacity;
    private static int stdCapacity = 5;

    public Basket() {
        this.capacity = stdCapacity;
    }

    public int add(String sku) {
        if (items.size() >= capacity)
            return 0;
        if(!Stock.isInStock(sku))
            return -1;
        items.add(Stock.getItem(sku));
        return 1;
    }

    public int add(Item item) {
        if (items.size() >= capacity)
            return 0;
        if(!Stock.isInStock(item.getSku()))
            return -1;
        items.add(item);
        return 1;
    }

    public boolean remove(String sku) {
        return items.remove(Stock.getItem(sku));
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCapacity() {
        return capacity;
    }

    public static int getStdCapacity() {
        return stdCapacity;
    }

    public static void setStdCapacity(int stdCapacity) {
        Basket.stdCapacity = stdCapacity;
    }

    public float getTotalCost(){
        float total = 0f;
        for (Item item: items){
            total += item.getPrice();
        }
        return total;
    }
}
