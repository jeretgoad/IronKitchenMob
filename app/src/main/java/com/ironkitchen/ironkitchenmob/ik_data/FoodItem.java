package com.ironkitchen.ironkitchenmob.ik_data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_item_table")
public class FoodItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private double price;

    private String description;

    private String foodGroup;

    public FoodItem(String title, double price, String description, String foodGroup) {
        this.title = title;
        this.price = price;
        this.foodGroup = foodGroup;
        this.description = description;
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
    public void setTitle(String title) {this.title = title;}

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {this.price = price;}

    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {this.description = description;}

    public String getFoodGroup() {
        return foodGroup;
    }
    public void setFoodGroup(String foodGroup) {this.foodGroup = foodGroup;}

}
