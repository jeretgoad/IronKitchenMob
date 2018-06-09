package com.ironkitchen.ironkitchenmob.ik_view;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ironkitchen.ironkitchenmob.R;
import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.ExpandableItem;
import com.xwray.groupie.ViewHolder;

public class MealPanalViewHolder extends ViewHolder{
    public final TextView textPanal;
    public final ImageButton expandableIcon;

    public MealPanalViewHolder(@NonNull View rootView) {
        super(rootView);
        textPanal = (TextView) rootView.findViewById(R.id.textPanal);
        expandableIcon = (ImageButton) rootView.findViewById(R.id.expandableButton);
    }
}
