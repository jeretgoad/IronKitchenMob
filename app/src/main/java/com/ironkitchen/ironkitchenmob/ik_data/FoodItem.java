package com.ironkitchen.ironkitchenmob.ik_data;

import java.util.ArrayList;

public class FoodItem {
    private String name;
    private int image;
    private ArrayList<FoodItemDetails> foodItemDetails;


    public FoodItem(String name, int image){
        this.name = name;
        this.image = image;
        this.foodItemDetails = new ArrayList<>();
    }


    public void addFoodItem(FoodItemDetails foodItem){
        foodItemDetails.add(foodItem);
    }

    public ArrayList<FoodItemDetails> getFoodItems(){
        return foodItemDetails;
    }

    public int getFoodSize(){
        return foodItemDetails.size();
    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }


}
