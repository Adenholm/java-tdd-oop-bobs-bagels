package com.booleanuk.extension;

public class PurchaseInfo {
    private String sku;
    private int count;
    private float price;
    private float discount;

    public PurchaseInfo(String sku, int count, float price, float discount) {
        this.sku = sku;
        this.count = count;
        this.price = price;
        this.discount = discount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        Item item = Stock.getItem(sku);
        StringBuilder str = new StringBuilder();
        str.append(String.format("%-18s%-4s%-7s", item.getVariant() + " " + item.getName(), getCount(), "£" + getPrice()));
        if(getDiscount() > 0){
            str.append("\n" + String.format("%-19s%-7s"," ","(-£" + round(getDiscount()) + ")"));
        }
        return  str.toString();
    }

    private double round(float f){
        return Math.round(f * Math.pow(10, 2)) / Math.pow(10, 2);
    }
}
