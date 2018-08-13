package com.ironkitchen.ironkitchenmob.ik_data.ik_view_items;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.ColorInt;
import android.view.View;

import com.bumptech.glide.Glide;
import com.ironkitchen.ironkitchenmob.R;
import com.ironkitchen.ironkitchenmob.ik_data.FoodItemDetails;
import com.ironkitchen.ironkitchenmob.ik_view.ik_viewholders.MealCarouselFoodItemViewHolder;
import com.xwray.groupie.Item;

import java.util.ArrayList;

public class MealCarouselFoodItem extends Item<MealCarouselFoodItemViewHolder>{
    private String foodText;
    @DrawableRes private int foodImage;
    @ColorInt private int colorInt;
    ArrayList<FoodItemDetails> foodItemDetails;

    public MealCarouselFoodItem(String foodText, @DrawableRes int foodImage){
        this.foodText = foodText;
        this.foodImage = foodImage;
        this.foodItemDetails = new ArrayList<>();
    }

    public void addFoodItemDetail(FoodItemDetails foodItemDetail){
        foodItemDetails.add(foodItemDetail);
    }

    public String getFoodText(){
        return foodText;
    }

    public ArrayList<FoodItemDetails> getFoodItemDetails(){
        return foodItemDetails;
    }

    @Override
    public int getLayout() {
        return R.layout.carousel__meal_food_choose;
    }

    @Override
    public MealCarouselFoodItemViewHolder createViewHolder(View itemView){
        return new MealCarouselFoodItemViewHolder(itemView);
    }

    @Override
    public void bind(@NonNull MealCarouselFoodItemViewHolder viewHolder, int position) {
        viewHolder.foodText.setText(foodText);
        viewHolder.getRoot().setBackgroundColor(colorInt);
        if(foodText.length() < 11)
        {
            viewHolder.foodText.setTextSize(25);
        }
        else if(foodText.length()  >= 11 && foodText.length()  < 15)
        {
            viewHolder.foodText.setTextSize(24);
        }
        else if(foodText.length()  >= 15 && foodText.length()  < 20)
        {
            viewHolder.foodText.setTextSize(22);
        }
        else if(foodText.length()  >= 20 && foodText.length()  <22)
        {
            viewHolder.foodText.setTextSize(20);
        }
        else
        {
            viewHolder.foodText.setTextSize(18);
        }
        Glide.with(viewHolder.getRoot().getContext()).load(foodImage).into(viewHolder.foodImage);
    }

}
