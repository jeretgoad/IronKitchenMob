package com.ironkitchen.ironkitchenmob.ik_data;

import com.ironkitchen.ironkitchenmob.ik_data.ik_view_items.MealCarouselFoodItem;
import com.ironkitchen.ironkitchenmob.ik_data.ik_view_items.MealPanalItem;

import java.util.HashMap;
import java.util.List;

public interface IKdataSourceInterface {
    List<Integer> getSlideShow();

    List<MobTabObjects> getListOfMobTabData();

    List<MealPanalItem> getListOfFoodPanelData();

    List<MealCarouselFoodItem> getListOfFoodItem(String key);

    void getListOfFoodItemDetailsData(MealCarouselFoodItem key);

    MobTabObjects createNewMobTabObjects(int index);

    MealPanalItem createNewFoodPanel(int index);

    MealCarouselFoodItem createNewFoodItem(String name, int imageRes);

    FoodItemDetails createNewFoodItemDetails(String label, double price);
}
