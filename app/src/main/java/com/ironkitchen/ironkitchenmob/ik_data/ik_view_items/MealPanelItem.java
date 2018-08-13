package com.ironkitchen.ironkitchenmob.ik_data.ik_view_items;

import android.graphics.drawable.Animatable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.ironkitchen.ironkitchenmob.ik_view.ik_viewholders.MealPanelViewHolder;
import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.ExpandableItem;
import com.xwray.groupie.Item;
import com.ironkitchen.ironkitchenmob.R;

public class MealPanelItem extends Item<MealPanelViewHolder> implements ExpandableItem{

    private ExpandableGroup expandableGroup;
    private String panelTitle;

    public MealPanelItem(String panalTitle) {
        this.panelTitle = panalTitle;
    }

    public String getPanelTitle(){
        return panelTitle;
    }

    private @DrawableRes int getExpandableButtonIcon(){
        @DrawableRes  int expandableIcon = expandableGroup.isExpanded() ? R.drawable.ic_arrow_drop_up_black_24dp : R.drawable.ic_arrow_drop_down_black_24dp;
        return expandableIcon;
    }


    @Override
    public int getLayout() {
        return R.layout.meal_food_panel;
    }

    @Override
    public MealPanelViewHolder createViewHolder(View panelView) {
        return new MealPanelViewHolder(panelView);
    }


    @Override
    public void bind(final MealPanelViewHolder viewHolder, int position) {
        viewHolder.textPanel.setText(panelTitle);
        viewHolder.expandableIcon.setImageResource(expandableGroup.isExpanded() ? R.drawable.ic_arrow_drop_up_black_24dp : R.drawable.ic_arrow_drop_down_black_24dp);
        viewHolder.expandableIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableGroup.onToggleExpanded();
                bindIcon(viewHolder);
            }
        });
    }

    private void bindIcon(MealPanelViewHolder viewHolder){
        viewHolder.expandableIcon.setVisibility(View.VISIBLE);
        viewHolder.expandableIcon.setImageResource(expandableGroup.isExpanded() ? R.drawable.collapse_anim: R.drawable.expand_anim);
        Animatable drawable = (Animatable) viewHolder.expandableIcon.getDrawable();
        drawable.start();
    }

    @Override
    public void setExpandableGroup(@NonNull ExpandableGroup onToggleListener) {
        this.expandableGroup = onToggleListener;

    }
}
