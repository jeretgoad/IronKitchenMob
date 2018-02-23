package com.ironkitchen.ironkitchenmob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2/22/18.
 */

// Adapter for RecyclerView in meal_food_panal.xml

class InnerRVAdapter extends RecyclerView.Adapter<InnerRVAdapter.FoodViewHolder> {
    private A
}

// Adapter for RecyclerView in fragment_meal_prep.xml

class OuterRVAdapter extends RecyclerView.Adapter<OuterRVAdapter.PanalViewHolder> {

    private final Context outContext;
    private static ArrayList<MealTabOjects> mMealObjects;
    private static String stringPanal;

    public static class PanalViewHolder extends RecyclerView.ViewHolder {
        public final TextView textPanal;

        public PanalViewHolder(View view) {
            super(view);
            Context context;
            textPanal = view.findViewById(R.id.textPanal);

        }
    }

    public OuterRVAdapter(Context context, ArrayList<MealTabOjects> mealOjects, String panalTitle) {
        outContext = context;
        mMealObjects = mealOjects;
        stringPanal = panalTitle;
    }

    @Override
    public PanalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(outContext).inflate(R.layout.meal_food_panal, parent, false);
        return new PanalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PanalViewHolder holder, int position) {
        holder.textPanal.setText(stringPanal);
    }

    @Override
    public int getItemCount() {
        return mMealObjects.size();
    }
}


public class MealAdapters{


}

