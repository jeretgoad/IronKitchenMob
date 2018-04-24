package com.ironkitchen.ironkitchenmob.ik_data;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.ironkitchen.ironkitchenmob.R;


public class FakeDataSource extends Object implements IKdataSourceInterface{

    // home tab data
    private final int[] appBarSlideShowImages = {
            R.drawable.burritoes,
            R.drawable.col2,
            R.drawable.col3,
            R.drawable.for_home,
            R.drawable.keto_bowls_5,
            R.drawable.pickup,
            R.drawable.back_again,
            R.drawable.broc_chic,
            R.drawable.col_wid_sauce,
            R.drawable.frig
    };

    private final String[] homeItemTitles = {
            "",
            "",
            "Meal Prep",
            "Family Prep",
            "Lunch"
    };

    private final int[] homeItemImages = {
            R.drawable.ik_loc,
            R.drawable.frig_loc,
            R.drawable.broc_chic,
            R.drawable.cbr_trey,
            R.drawable.lunch_button,
    };

    private final int[] homeItemVideo = {
            0,
            R.raw.ik_intro,
            0,
            0,
            0
    };

    private final int[] homeItemButtonType = {
            2, 1, 0, 0, 0
    };

    // meal prep tab
    private final String[] foodPanel = {
            "Protein By The Pound",
            "Carbs By The Pound",
            "Vegetables By The Pound",
            "Signature Dishes"
    };

    // protein food items
    private final Pair<String, Integer> steak = new Pair<>("steak", R.drawable.steak);
    private final Pair<String, Integer> turkey = new Pair<>("Turkey", R.drawable.turkey);
    private final Pair<String, Integer> chicken_breast = new Pair<>("Chicken Breast", R.drawable.chic_breast);
    private final Pair<String, Integer> shredded_chicken = new Pair<>("Shredded Chicken", R.drawable.shred_chicken);
        // protein food item details
        private final Pair<String, Double> steak_detail_1 = new Pair<>("1 lbs", 12.00);
        private final Pair<String, Double> steak_detail_2 = new Pair<>("1 lbs", 12.00);
        private final Pair<String, Double> turkey_detail_1 = new Pair<>("1 lbs", 11.00);
        private final Pair<String, Double> turkey_detail_2 = new Pair<>("5 lbs", 45.00);
        private final Pair<String, Double> chicken_breast_detail_1 = new Pair<>("1 lbs Chipotle/dry", 10.00);
        private final Pair<String, Double> chicken_breast_detail_2 = new Pair<>("5 lbs Chipotle/dry", 40.00);
        private final Pair<String, Double> chicken_breast_detail_3 = new Pair<>("1 lbs Teriyaki/wet", 11.00);
        private final Pair<String, Double> chicken_breast_detail_4 = new Pair<>("5 lbs Teriyaki/wet",45.00);
        private final Pair<String, Double> shredded_chicken_detail_1 = new Pair<>("1 lbs", 10.00);
        private final Pair<String, Double> shredded_chicken_detail_2 = new Pair<>("5 lbs", 40.00);

    //carb food items
    private final Pair<String, Integer> red_potatoes = new Pair<>("Red Potatoes", R.drawable.red_pot);
    private final Pair<String, Integer> jasmine_rice = new Pair<>("Jasmine Rice", R.drawable.jasmine_rice);
    private final Pair<String, Integer> sweet_potatoes = new Pair<>("Sweet Potatoes", R.drawable.sweet_potatoes);
        // carb food item details
        private final Pair<String, Double> red_potatoes_detail_1 = new Pair<>("1 lbs", 7.00);
        private final Pair<String, Double> red_potatoes_detail_2 = new Pair<>("5 lbs", 30.00);
        private final Pair<String, Double> red_potatoes_detail_3 = new Pair<>("1 lbs Cajun", 7.99);
        private final Pair<String, Double> red_potatoes_detail_4 = new Pair<>("5 lbs Cajun",35.00);
        private final Pair<String, Double> jasmine_rice_breast_detail_1 = new Pair<>("1 lbs", 5.00);
        private final Pair<String, Double> jasmine_rice_breast_detail_2 = new Pair<>("5 lbs", 20.00);
        private final Pair<String, Double> sweet_potatoes_detail_1 = new Pair<>("1 lbs",7.00);
        private final Pair<String, Double> sweet_potatoes_detail_2 = new Pair<>("5 lbs", 30.00);
        private final Pair<String, Double> sweet_potatoes_detail_3 = new Pair<>("1 lbs B. Sugar Cinnamon", 7.99);
        private final Pair<String, Double> sweet_potatoes_detail_4 = new Pair<>("1 lbs Cajun",7.99);

    // vegetable food items
    private final Pair<String, Integer> vegetable_medley = new Pair<>("Vegetable Medley", R.drawable.veg_medley);
    private final Pair<String, Integer> zucchini_squash_mix = new Pair<>("Zucchini / Squash Mix", R.drawable.zuc_squash_mix);
    private final Pair<String, Integer> broccoli = new Pair<>("Broccoli", R.drawable.broccoli);
        // vegetable food item details
        private final Pair<String, Double> vegetable_medley_detail_1 = new Pair<>("1 lbs", 8.00);
        private final Pair<String, Double> vegetable_medley_detail_2 = new Pair<>("5 lbs",35.00);
        private final Pair<String, Double> zucchini_squash_mix_detail_1 = new Pair<>("1 lbs", 8.00);
        private final Pair<String, Double> zucchini_squash_mix_detail_2 = new Pair<>("5 lbs",35.00);
        private final Pair<String, Double> broccoli_detail_1 = new Pair<>("1 lbs", 8.00);
        private final Pair<String, Double> broccoli_detail_2 = new Pair<>("5 lbs",35.00);


    // signature food items
    private final Pair<String, Integer> taco_bowl = new Pair<>("Taco Bowl", R.drawable.taco_bowl);
    private final Pair<String, Integer> buffalo_chicken_rice = new Pair<>("Buffalo Chicken Rice", R.drawable.buff_chic_rice);
    private final Pair<String, Integer> chicken_peppers = new Pair<>("Chicken Peppers", R.drawable.chicken_peppers);
        // signature food item details
        private final Pair<String, Double> taco_bowl_detail_1 = new Pair<>("Chicken",7.00);
        private final Pair<String, Double> taco_bowl_detail_2 = new Pair<>("Turkey",7.00);
        private final Pair<String, Double> buffalo_chicken_rice_detail_1 = new Pair<>("", 8.00);
        private final Pair<String, Double> chicken_peppers_detail_1 = new Pair<>("", 8.00);


    private ArrayList<Pair<String, Integer>> getFoodGroup(String group)
    {
        ArrayList<Pair<String, Integer>> foodGroupArray = new ArrayList<>();
        if(group.equalsIgnoreCase(foodPanel[0])){
            foodGroupArray.add(steak);
            foodGroupArray.add(turkey);
            foodGroupArray.add(chicken_breast);
            foodGroupArray.add(shredded_chicken);
        }
        else if(group.equalsIgnoreCase(foodPanel[1])){
            foodGroupArray.add(red_potatoes);
            foodGroupArray.add(jasmine_rice);
            foodGroupArray.add(sweet_potatoes);
        }
        else if(group.equalsIgnoreCase(foodPanel[2])){
            foodGroupArray.add(vegetable_medley);
            foodGroupArray.add(zucchini_squash_mix);
            foodGroupArray.add(broccoli);
        }
        else if(group.equalsIgnoreCase(foodPanel[3])){
            foodGroupArray.add(taco_bowl);
            foodGroupArray.add(buffalo_chicken_rice);
            foodGroupArray.add(chicken_peppers);
        }
        return foodGroupArray;
    }

    private ArrayList<Pair<String, Double>> getFoodDetails(String food){
        ArrayList<Pair<String, Double>> foodDetails = new ArrayList<>();
        if(food.equalsIgnoreCase(steak.first)){
            foodDetails.add(steak_detail_1);
            foodDetails.add(steak_detail_2);
        }
        return foodDetails;
    }


    @Override
    public List<Integer> getSlideShow() {
        return null;
    }

    @Override
    public List<MobTabObjects> getListOfData() {
        return null;
    }

    @Override
    public HashMap<String, HashMap> getHashMapData() {
        return null;
    }

    @Override
    public void addToHashMap(String key, int sizeOfArray) {

    }

    @Override
    public Object createNewItem(int classID) {
        return null;
    }
}
