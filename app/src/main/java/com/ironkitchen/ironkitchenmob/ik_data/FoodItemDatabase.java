package com.ironkitchen.ironkitchenmob.ik_data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {FoodItem.class}, version = 1)
public abstract class FoodItemDatabase extends RoomDatabase {

    private static FoodItemDatabase instance;

    public abstract FoodItemDao foodItemDao();

    public static synchronized FoodItemDatabase getInstance(Context context){
        if (instance == null){
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), FoodItemDatabase.class, "food_item_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

   private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
       @Override
       public void onCreate(@NonNull SupportSQLiteDatabase db) {
           super.onCreate(db);
           new PopulateDbAsyncTask(instance).execute();
       }
   };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private FoodItemDao foodItemDao;

        private PopulateDbAsyncTask(FoodItemDatabase foodDb) {
            foodItemDao = foodDb.foodItemDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            foodItemDao.insert(new FoodItem("Chipotle (Dry)", 9.00,  1, "Chicken Breast"));
            foodItemDao.insert(new FoodItem("Chipotle (Dry)", 36.00,  5, "Chicken Breast"));
            foodItemDao.insert(new FoodItem("Buffalo (Wet)", 9.90,  1, "Chicken Breast"));
            foodItemDao.insert(new FoodItem("Buffalo (Wet)", 40.50,  5, "Chicken Breast"));

            return null;
        }
    }
}
