package com.ironkitchen.ironkitchenmob.ik_data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_item_table")
public class FoodItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private double price;

    private int pounds;

    private String foodChoice;

    public FoodItem(String title, double price, int pounds, String foodChoice) {
        this.title = title;
        this.price = price;
        this.pounds = pounds;
        this.foodChoice = foodChoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public double getPounds() { return pounds; }

    public String getFoodChoice() {
        return foodChoice;
    }
}
