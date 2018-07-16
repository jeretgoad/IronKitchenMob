package com.ironkitchen.ironkitchenmob.ik_view;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.ironkitchen.ironkitchenmob.R;
import com.xwray.groupie.Item;

public class MealFoodCarouselItem extends Item<MealFoodHeaderViewHolder>{
    private String foodText;
    @DrawableRes private int foodImage;

    public MealFoodCarouselItem(String foodText, @DrawableRes int foodImage){
        this.foodText = foodText;
        this.foodImage = foodImage;
    }
    @Override
    public void bind(@NonNull MealFoodHeaderViewHolder viewHolder, int position) {
        viewHolder.foodText.setText(foodText);
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

    @Override
    public int getLayout() {
        return R.layout.carousel__meal_food_choose;
    }
}
