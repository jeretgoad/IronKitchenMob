package com.ironkitchen.ironkitchenmob.ik_data;

import java.util.HashMap;
import java.util.List;

public interface IKdataSourceInterface {
    List<Integer> getSlideShow();

    List<MobTabObjects> getListOfMobTabData();

    List<FoodPanel> getListOfFoodPanelData();

    List<FoodItem> getListOfFoodItem(String key);

    List<FoodItemDetails> getListOfFoodItemDetailsData(FoodItem key);

    MobTabObjects createNewMobTabObjects(int index);

    FoodPanel createNewFoodPanel(int index);

    FoodItem createNewFoodItem(String name, int imageRes);

    FoodItemDetails createNewFoodItemDetails(String label, double price);
}
