package com.ironkitchen.ironkitchenmob.ik_data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FoodItemDao {

    @Insert
    void insert(FoodItem foodItem);

    @Update
    void update(FoodItem fooditem);

    @Delete
    void delete(FoodItem foodItem);

    @Query("DELETE FROM food_item_table")
    void deleteAllFoodItems();

    @Query("SELECT * FROM food_item_table ORDER BY title DESC")
    LiveData<List<FoodItem>> getAllFoodItems();
}
