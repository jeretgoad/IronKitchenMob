package com.ironkitchen.ironkitchenmob.ik_view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ironkitchen.ironkitchenmob.R;
import com.ironkitchen.ironkitchenmob.ik_data.ik_view_items.MealPanalItem;
import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.Group;
import com.xwray.groupie.GroupAdapter;


public class meal_prep extends Fragment {
    private View mealView;
    private RecyclerView mealRV;
    private MealAdapters mealAdapters;
    private RecyclerView.Adapter outerRVAdapter;
    private GridLayoutManager layoutManager;
    private GroupAdapter mealGroupAdapter;
    private int mealCarouselColor, mealBtwPadding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mealView = inflater.inflate(R.layout.fragment_meal_prep, container, false);
        mealRV  = (RecyclerView) mealView.findViewById(R.id.mealRecView);

        mealCarouselColor = ContextCompat.getColor(getContext(), R.color.colorCarouselBg);
        mealBtwPadding = getResources().getDimensionPixelSize(R.dimen.padding_carousel);

        mealGroupAdapter = new GroupAdapter();

        populateAdapter();


        return mealView;
    }

    private void populateAdapter(){
        MealPanalItem expandableHeaderItem1 = new MealPanalItem("protein");
        ExpandableGroup expandableGroup = new ExpandableGroup((Group) expandableHeaderItem1);
        populateExpandableGroup(expandableGroup, expandableHeaderItem1.getPanalTitle());
    }

    private ExpandableGroup populateExpandableGroup(ExpandableGroup expandableGroup, String panalTitle){

        return expandableGroup;
    }
}
