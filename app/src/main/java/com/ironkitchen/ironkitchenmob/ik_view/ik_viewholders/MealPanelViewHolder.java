package com.ironkitchen.ironkitchenmob.ik_view.ik_viewholders;
import android.media.Image;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ironkitchen.ironkitchenmob.R;
import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.ExpandableItem;
import com.xwray.groupie.ViewHolder;

public class MealPanelViewHolder extends ViewHolder{
    public final TextView textPanel;
    public final ImageButton expandableIcon;
    public final View rootPanel;

    public MealPanelViewHolder(@NonNull View rootView) {
        super(rootView);
        rootPanel = rootView.findViewById(R.id.mealPanel);
        textPanel = rootView.findViewById(R.id.textPanel);
        expandableIcon = rootView.findViewById(R.id.expandableIcon);
    }
}
