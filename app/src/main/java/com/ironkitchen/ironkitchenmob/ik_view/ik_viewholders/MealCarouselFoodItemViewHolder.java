package com.ironkitchen.ironkitchenmob.ik_view.ik_viewholders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ironkitchen.ironkitchenmob.R;

import com.xwray.groupie.ViewHolder;

public class MealCarouselFoodItemViewHolder extends ViewHolder{

    public final ImageView foodImage;
    public final TextView foodText;
    public MealCarouselFoodItemViewHolder(@NonNull View rootView) {
        super(rootView);
        foodImage = (ImageView) rootView.findViewById(R.id.mealChoiceFoodImage);
        foodText = (TextView) rootView.findViewById(R.id.mealChoiceImageTitle);
    }
}