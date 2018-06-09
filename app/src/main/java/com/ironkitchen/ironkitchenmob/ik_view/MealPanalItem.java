package com.ironkitchen.ironkitchenmob.ik_view;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.ExpandableItem;
import com.xwray.groupie.Item;
import com.ironkitchen.ironkitchenmob.R;

public class MealPanalItem extends Item<MealPanalViewHolder> implements ExpandableItem{

    private ExpandableGroup expandableGroup;
    private String panalTitle;
    @DrawableRes private int expandableButtonIcon
    private View.OnClickListener onPanalClickListener;

    public MealPanalItem(String panalTitle, @DrawableRes int expandableButtonIcon,View.OnClickListener onPanalClickListener) {
        this.panalTitle = panalTitle;
        this.expandableButtonIcon = expandableButtonIcon;
        this.onPanalClickListener = onPanalClickListener;
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
    public void bind(@NonNull MealPanalViewHolder viewHolder, int position) {
        viewHolder.textPanal.setText(panalTitle);
        viewHolder.expandableIcon.setImageResource(getExpandableButtonIcon());
        viewHolder.expandableIcon.setOnClickListener(onPanalClickListener);
    }

    @Override
    public void setExpandableGroup(@NonNull ExpandableGroup onToggleListener) {
        this.expandableGroup = onToggleListener;

    }
}
