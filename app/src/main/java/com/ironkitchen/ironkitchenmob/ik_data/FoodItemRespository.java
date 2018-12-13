package com.ironkitchen.ironkitchenmob.ik_data;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class FoodItemRespository {
    private FoodItemDao foodItemDao;
    private LiveData<List<FoodItem>> allFoodItems;

    public FoodItemRespository(Application application){
        FoodItemDatabase database = FoodItemDatabase.getInstance(application);
        foodItemDao = database.foodItemDao();
        allFoodItems = foodItemDao.getAllFoodItems();
    }

    public void insert(FoodItem foodItem) {
        new InsertFoodItemAsyncTask(foodItemDao).execute(foodItem);
    }

    public void update(FoodItem foodItem) {
        new UpdateFoodItemAsyncTask(foodItemDao).execute(foodItem);

    }

    public void delete(FoodItem foodItem) {
        new DeleteFoodItemAsyncTask(foodItemDao).execute(foodItem);

    }

    public void deleteAllFoodItems() {
        new DeleteAllFoodItemAsyncTask(foodItemDao).execute();

    }

    public LiveData<List<FoodItem>> getAllFoodItems() {
        return allFoodItems;
    }

    private static class InsertFoodItemAsyncTask extends AsyncTask<FoodItem, Void, Void> {
        private FoodItemDao foodItemDao;

        private InsertFoodItemAsyncTask(FoodItemDao foodItemDao) {
            this.foodItemDao = foodItemDao;
        }

        @Override
        protected Void doInBackground(FoodItem... foodItems){
            foodItemDao.insert(foodItems[0]);
            return null;
        }
    }

    private static class UpdateFoodItemAsyncTask extends AsyncTask<FoodItem, Void, Void> {
        private FoodItemDao foodItemDao;

        private UpdateFoodItemAsyncTask(FoodItemDao foodItemDao) {
            this.foodItemDao = foodItemDao;
        }

        @Override
        protected Void doInBackground(FoodItem... foodItems){
            foodItemDao.update(foodItems[0]);
            return null;
        }
    }

    private static class DeleteFoodItemAsyncTask extends AsyncTask<FoodItem, Void, Void> {
        private FoodItemDao foodItemDao;

        private DeleteFoodItemAsyncTask(FoodItemDao foodItemDao) {
            this.foodItemDao = foodItemDao;
        }

        @Override
        protected Void doInBackground(FoodItem... foodItems){
            foodItemDao.delete(foodItems[0]);
            return null;
        }
    }

    private static class DeleteAllFoodItemAsyncTask extends AsyncTask<FoodItem, Void, Void> {
        private FoodItemDao foodItemDao;

        private DeleteAllFoodItemAsyncTask(FoodItemDao foodItemDao) {
            this.foodItemDao = foodItemDao;
        }

        @Override
        protected Void doInBackground(FoodItem... foodItems){
            foodItemDao.deleteAllFoodItems();
            return null;
        }
    }
}
