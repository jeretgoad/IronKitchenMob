package com.ironkitchen.ironkitchenmob.ik_data.ik_view_items;

import android.graphics.drawable.Animatable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.ironkitchen.ironkitchenmob.ik_view.ik_viewholders.MealPanalViewHolder;
import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.ExpandableItem;
import com.xwray.groupie.Item;
import com.ironkitchen.ironkitchenmob.R;

public class MealPanalItem extends Item<MealPanalViewHolder> implements ExpandableItem{

    private ExpandableGroup expandableGroup;
    private String panalTitle;

    public MealPanalItem(String panalTitle) {
        this.panalTitle = panalTitle;
    }

    public String getPanalTitle(){
        return panalTitle;
    }

    private @DrawableRes int getExpandableButtonIcon(){
        @DrawableRes  int expandableIcon = expandableGroup.isExpanded() ? R.drawable.ic_arrow_drop_up_black_24dp : R.drawable.ic_arrow_drop_down_black_24dp;
        return expandableIcon;
    }


    @Override
    public int getLayout() {
        return R.layout.meal_food_panal;
    }

    @Override
    public MealPanalViewHolder createViewHolder(View panalView) {
        return new MealPanalViewHolder(panalView);
    }


    @Override
    public void bind(final MealPanalViewHolder viewHolder, int position) {
        viewHolder.textPanal.setText(panalTitle);
        viewHolder.expandableIcon.setImageResource(expandableGroup.isExpanded() ? R.drawable.ic_arrow_drop_up_black_24dp : R.drawable.ic_arrow_drop_down_black_24dp);
        viewHolder.expandableIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableGroup.onToggleExpanded();
                bindIcon(viewHolder);
            }
        });
    }

    private void bindIcon(MealPanalViewHolder viewHolder){
        viewHolder.expandableIcon.setVisibility(View.VISIBLE);
        viewHolder.expandableIcon.setImageResource(expandableGroup.isExpanded() ? R.drawable.ic_arrow_drop_up_black_24dp : R.drawable.ic_arrow_drop_down_black_24dp);
        Animatable drawable = (Animatable) viewHolder.expandableIcon.getDrawable();
        drawable.start();
    }

    @Override
    public void setExpandableGroup(@NonNull ExpandableGroup onToggleListener) {
        this.expandableGroup = onToggleListener;

    }
}
