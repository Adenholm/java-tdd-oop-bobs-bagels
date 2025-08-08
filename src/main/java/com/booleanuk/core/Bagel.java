package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item{
    private final List<Item> fillings = new ArrayList<>();

    public Bagel(String sku, float price, String variant) {
        super(sku, price, "Bagel", variant);
    }

    @Override
    public float getPrice(){
        float total = 0f;
        for(Item f: fillings){
            total += f.getPrice();
        }
        return super.getPrice() + total;
    }

    public List<Item> getFillings() {
        return fillings;
    }

    public boolean addFilling(Item filling){
        if(!filling.getVariant().equals("Filling"))
            return false;
        fillings.add(filling);
        return true;
    }
}
