package com.ironkitchen.ironkitchenmob.ik_data;

import java.util.ArrayList;

/**
 * Created by user on 2/22/18.
 */

public class MealTabOjects {
    String mealType;
    ArrayList<MealTabOjects> selections;
    int imageID;
    double price, total;
    int quantity;

    public MealTabOjects(String mealType, int imageID)
    {
        this.mealType = mealType;
        this.imageID = imageID;
        this.total = 0.00;
        this.selections = new ArrayList<>();
        this.quantity = 0;
    }

    public MealTabOjects() {
        this.quantity = 0;
        this.total = 0.00;
    }

    public void addMealTabObject(String season, double price)
    {
        MealTabOjects thisMeal = new MealTabOjects();
        thisMeal.setSeasoning(season);
        thisMeal.setPrice(price);
        this.selections.add(thisMeal);
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setSeasoning(String seasoning){ this.mealType = seasoning; }

    public void setQuantity(int quantity) { this.quantity = quantity;}

    public void addToTotal(double item) {
        this.total += item;
    }

    public void subtractFromTotal(double item) {
        this.total -= item;
    }

    public double getPrice() { return this.price; }

    public String getSeasoning() { return this.mealType; }

    public int getQuantity() { return this.quantity; }

    public double getTotal() {
        return total;
    }

    public ArrayList<MealTabOjects> getMealSelections() {
        return this.selections;
    }

    public double getMealSelectionsTotal()
    {
        this.total = 0.00;
        for(int i =0; i < this.selections.size(); i++)
        {
            this.total += this.selections.get(i).getTotal();
        }
        return this.total;
    }
}
