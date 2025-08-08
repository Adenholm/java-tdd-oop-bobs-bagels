package com.booleanuk.core;

public abstract class Item {
    private String sku;
    private float price;
    private String Name;
    private String variant;

    public String getVariant() {
        return variant;
    }

    public String getName() {
        return Name;
    }

    public float getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public Item(String sku, float price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        Name = name;
        this.variant = variant;
    }
}
