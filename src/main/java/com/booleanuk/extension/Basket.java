package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int add(String sku, int count) {
        if (items.size() + count > capacity)
            return 0;
        if(!Stock.isInStock(sku))
            return -1;
        for (int i = 0; i < count; i++) {
            items.add(Stock.getItem(sku));
        }
        return 1;
    }

    public int add(Item item) {
        if (items.size() >= capacity)
            return 0;
        if(item == null || !Stock.isInStock(item.getSku()))
            return -1;
        items.add(item);
        return 1;
    }

    public boolean remove(String sku) {
        for(Item item: items){
            if(item.getSku().equals(sku)) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public double getDiscountedTotal(){
        double discount = 0;
        Map<String, Integer> count = countItems();
        // Check discounts for bagel
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String sku = entry.getKey();
            Integer n = entry.getValue();
            if(sku.substring(0, 3).equals("BGL")){
                discount += getBagelDiscount(sku, n);
                count.put(sku, count.get(sku) - (n - n%6));
            }
        }
        // Check discount for Bagel & coffe combo
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String sku = entry.getKey();
            Integer n = entry.getValue();
            if(sku.substring(0, 3).equals("COF")){
                for (int i = 0; i < n; i++) {
                    discount += findBagelCoffeCombo(sku, count);
                }
            }
        }
        return getTotalCost() - discount;
    }

    private double getBagelDiscount(String sku, int count){
        double discount = 0;
        while (count >= 12) {
            discount += 12 * Stock.getItem(sku).getPrice() - 3.99f;
            count -= 12;
        }
        while (count >= 6) {
            discount += 6 * Stock.getItem(sku).getPrice() - 2.49f;
            count -= 6;
        }
        return discount;
    }

    private float findBagelCoffeCombo(String coffeSku, Map<String, Integer> count){
        float disc = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String sku = entry.getKey();
            Integer n = entry.getValue();
            if(sku.substring(0, 3).equals("BGL") && n >= 1){
                disc = Stock.getItem(sku).getPrice() + Stock.getItem(coffeSku).getPrice() - 1.25f;
                count.put(sku, count.get(sku) - 1);
            }
        }
        return disc;
    }

    private Map<String, Integer> countItems(){
        Map<String, Integer> count = new HashMap<>();
        for(Item item: items){
            if (count.containsKey(item.getSku()))
                count.put(item.getSku(), count.get(item.getSku()) + 1);
            else
                count.put(item.getSku(), 1);
        }
        return count;
    }


}
