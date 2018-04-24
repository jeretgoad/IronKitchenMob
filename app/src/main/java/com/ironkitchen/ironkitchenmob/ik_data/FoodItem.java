package com.ironkitchen.ironkitchenmob.ik_data;

import java.util.ArrayList;

public class FoodItem {
    private String name;
    private double total;
    private int image;

    public FoodItem(String name, int image){
        this.name = name;
        this.image = image;
        total = 0.00;
    }


    public void setTotal(double total){
        this.total = total;

    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }

    public double getTotal(){
        return total;
    }
}
