package com.ironkitchen.ironkitchenmob.ik_data;

public class FoodItemDetails {
    private String description;
    private double price;
    private int quantity;

    public FoodItemDetails(String description, double price){
        this.description = description;
        this.price = price;
        this.quantity = 0;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }
}
