package com.ironkitchen.ironkitchenmob;

import java.util.ArrayList;

/**
 * Created by user on 2/22/18.
 */

public class MealTabOjects {
    String mealType;
    ArrayList<String> seasonings;
    ArrayList<Double> priceOpt;
    int imageID;
    double total;

    public MealTabOjects(String mealType, int imageID)
    {
        this.mealType = mealType;
        this.imageID = imageID;
        this.total = 0.00;
        this.seasonings = new ArrayList<>();
        this.priceOpt = new ArrayList<>();

    }

    public void setOptionalPrices(double pound1){
        this.priceOpt.add(pound1);
    }

    public void setSeasoning(String seasoning)
    {
        seasonings.add(seasoning);
    }

    public void setTotal(int item) {
        total += item;
    }

    public double getTotal() {
        return total;
    }
}
