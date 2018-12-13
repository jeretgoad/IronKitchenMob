package com.ironkitchen.ironkitchenmob.ik_data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = FoodItem.class, version = 1)
public abstract class FoodItemDatabase extends RoomDatabase {

    private static FoodItemDatabase instance;

    public static synchronized FoodItemDatabase getInstance(Context context){
        if (instance == null){
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), FoodItemDatabase.class, "food_item_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract FoodItemDao foodItemDao();
}
