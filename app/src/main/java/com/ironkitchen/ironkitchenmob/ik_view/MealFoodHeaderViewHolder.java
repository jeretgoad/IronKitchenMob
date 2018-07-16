package com.ironkitchen.ironkitchenmob.ik_view;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ironkitchen.ironkitchenmob.R;

import com.xwray.groupie.ViewHolder;

public class MealFoodHeaderViewHolder extends ViewHolder{

    public final ImageView foodImage;
    public final TextView foodText;
    public MealFoodHeaderViewHolder(@NonNull View rootView) {
        super(rootView);
        foodImage = (ImageView) rootView.findViewById(R.id.mealChoiceFoodImage);
        foodText = (TextView) rootView.findViewById(R.id.mealChoiceImageTitle);
    }
}
