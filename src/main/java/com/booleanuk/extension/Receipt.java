package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Receipt {
    Basket basket;
    String timestamp;


    public Receipt(Basket basket) {
        this.basket = basket;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = now.format(formatter);
    }

    public void printReceipt(){
        System.out.println(generateReceipt());
    }

    public String generateReceipt(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("    ~~~ Bob's Bagels ~~~\n \n    " + timestamp + "\n \n" + "----------------------------\n\n");
        for(PurchaseInfo item: basket.getPurchaseInfo()){
            receipt.append(item.toString()).append("\n");
        }
        receipt.append("\n----------------------------\n");
        float total = basket.getDiscountedTotal();
        receipt.append(String.format("%-22s%-7s\n","Total","£" + total));
        receipt.append("\n\n You saved a total of £").append(round(basket.getTotalCost() - total)).append("\n\t   on this shop")
                .append("\n\n\t    Thank you\n\t  for you order!");
        return receipt.toString();
    }

    private double round(float f){
            return Math.round(f * Math.pow(10, 2)) / Math.pow(10, 2);
    }
}
