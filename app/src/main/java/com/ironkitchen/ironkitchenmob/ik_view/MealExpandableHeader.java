package com.ironkitchen.ironkitchenmob.ik_view;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.ironkitchen.ironkitchenmob.R;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

/**
 * Created by jeretgoad on 5/17/18.
 */

public class MealExpandableHeader extends Item<MealExpandableHeader.MealExpandableItemViewHolder{
    private String panalTitle;

    public MealExpandableHeader(String panalTitle){
        this.panalTitle = panalTitle;
    }

    @Override
    public void bind(@NonNull MealExpandableItemViewHolder viewHolder, int position) {
        viewHolder.textPanal.setText(panalTitle);
    }

    @Override
    public int getLayout() {
        return R.layout.meal_food_panal;
    }

    public class MealExpandableItemViewHolder extends ViewHolder{
        TextView textPanal;

        MealExpandableItemViewHolder(View view){
            super(view);
            textPanal = view.findViewById(R.id.textPanal);
        }
    }
}
