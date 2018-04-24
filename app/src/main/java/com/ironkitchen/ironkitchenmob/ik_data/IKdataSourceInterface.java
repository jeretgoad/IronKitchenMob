package com.ironkitchen.ironkitchenmob.ik_data;

import java.util.HashMap;
import java.util.List;

public interface IKdataSourceInterface {
    List<Integer> getSlideShow();

    List<MobTabObjects> getListOfMobTabData();

    List<FoodPanel> getListOfFoodPanelData();

    List<FoodItem> getListOfFoodItem(String key);

    List<FoodItemDetails> getListOfFoodItemDetailsData(FoodItem key);

}
