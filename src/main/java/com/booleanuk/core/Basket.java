package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();
    private int capacity;
    static int stdCapacity = 5;

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

    public List<Item> getItems() {
        return items;
    }


}
