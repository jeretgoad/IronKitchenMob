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
import com.ironkitchen.ironkitchenmob.ik_data.FakeDataSource;
import com.ironkitchen.ironkitchenmob.ik_data.IKdataSourceInterface;
import com.ironkitchen.ironkitchenmob.ik_data.ik_view_items.MealCarouselFoodItem;
import com.ironkitchen.ironkitchenmob.ik_data.ik_view_items.MealCarouselItem;
import com.ironkitchen.ironkitchenmob.ik_data.ik_view_items.MealPanelItem;
import com.ironkitchen.ironkitchenmob.ik_view.decorations.MealCarouselItemDecoration;
import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Section;
import java.util.List;


public class meal_prep extends Fragment {
    private View mealView;
    private RecyclerView mealRV;
    private RecyclerView.Adapter outerRVAdapter;
    private GridLayoutManager layoutManager;
    private GroupAdapter mealGroupAdapter;
    private int mealCarouselColor, mealBtwPadding;
    private IKdataSourceInterface dsi;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mealView = inflater.inflate(R.layout.fragment_meal_prep, container, false);
        mealRV  = (RecyclerView) mealView.findViewById(R.id.mealRecView);
        dsi = new FakeDataSource();
        mealCarouselColor = ContextCompat.getColor(getContext(), R.color.colorCarouselBg);
        mealBtwPadding = getResources().getDimensionPixelSize(R.dimen.padding_carousel);

        mealGroupAdapter = new GroupAdapter();

        populateAdapter();


        return mealView;
    }

    private void populateAdapter(){
        List<MealPanelItem> panelItems = dsi.getListOfFoodPanelData();
        for(int i = 0; i < panelItems.size(); i++){
            ExpandableGroup expandableGroup = new ExpandableGroup(panelItems.get(i));
            populateExpandableGroup(expandableGroup, panelItems.get(i).getPanelTitle());
            mealGroupAdapter.add(expandableGroup);
        }
    }

    private void populateExpandableGroup(ExpandableGroup expandableGroup, String panelTitle){
        List<MealCarouselFoodItem> foodItems = dsi.getListOfFoodItem(panelTitle);
        Section carouselSection = new Section();

        // retrieve food item details for each food item
        for (int i = 0; i < foodItems.size(); i++){
            MealCarouselFoodItem foodItem = foodItems.get(i);
            dsi.getListOfFoodItemDetailsData(foodItem);
        }
        MealCarouselItem carouselItem = populateCarousel(foodItems);
        carouselSection.add(carouselItem);
        expandableGroup.add(carouselSection);
    }

    private MealCarouselItem populateCarousel(List<MealCarouselFoodItem> foodItems){
        MealCarouselItemDecoration carouselDecoration = new MealCarouselItemDecoration(mealCarouselColor, mealBtwPadding);
        GroupAdapter carouselAdapter = new GroupAdapter();
        for(int i = 0; i < foodItems.size(); i++){
            carouselAdapter.add(foodItems.get(i));
        }
        MealCarouselItem carouselItem = new MealCarouselItem(carouselDecoration);
        carouselItem.setAdapter(carouselAdapter);
        return carouselItem;
    }
}
