package com.ironkitchen.ironkitchenmob;

/**
 * Created by user on 2/22/18.
 */

public class MealTabOjects {
    String mealType;
    int imageID;
    int price1Lbs;
    int price5Lbs;
    int total;

    public MealTabOjects(String mealType, int imageID, int price1Lbs, int price5Lbs)
    {
        this.mealType = mealType;
        this.imageID = imageID;
        this.price1Lbs = price1Lbs;
        this.price5Lbs = price5Lbs;
        this.total = 0;
    }

    public void setTotal(int item) {
        total += item;
    }

    public int getTotal() {
        return total;
    }
}
