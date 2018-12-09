package com.ironkitchen.ironkitchenmob.ik_view.ik_viewholders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.ironkitchen.ironkitchenmob.R;
import com.xwray.groupie.ViewHolder;

public class MealCarouselViewHolder extends ViewHolder{

    public final RecyclerView carouselRV;

    public MealCarouselViewHolder(@NonNull View rootView) {
        super(rootView);
        carouselRV = (RecyclerView) rootView.findViewById(R.id.carousel_recycler_view);
    }
}
