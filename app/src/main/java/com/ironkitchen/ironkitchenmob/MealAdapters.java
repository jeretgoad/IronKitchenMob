package com.ironkitchen.ironkitchenmob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by user on 2/22/18.
 */

// Adapter for RecyclerView in meal_food_panal.xml

class InnerRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MealTabOjects> mealObjects;
    private int mRowIndex = -1;

    public InnerRVAdapter() {

    }

    public void setMealObjects(ArrayList<MealTabOjects> mealObjects) {
        if(this.mealObjects != mealObjects){
            this.mealObjects = mealObjects;
            notifyDataSetChanged();
        }
    }

    public void setInnerRCIndex(int index){
        mRowIndex = index;
    }

    public class ThisPanalViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodImageText, pound1PriceText, pound5PriceText, total;
        private Button pound1B, pound5B;
        private EditText quantity1Pound, quantity5Pound;

        public ThisPanalViewHolder(View itemView){
            super(itemView);
            foodImage = (ImageView) itemView.findViewById(R.id.mealChoiceItem);
            foodImageText = (TextView) itemView.findViewById(R.id.mealChoiseImageTitle);
            pound1B = (Button) itemView.findViewById(R.id.pound1Button);
            pound1PriceText = (TextView) itemView.findViewById(R.id.pound1Price);
            quantity1Pound = (EditText) itemView.findViewById(R.id.quantityBoxLeft);
            pound5B = (Button) itemView.findViewById(R.id.pound5Button);
            pound5PriceText = (TextView) itemView.findViewById(R.id.pound5Price);
            quantity1Pound = (EditText) itemView.findViewById(R.id.quantityBoxLeft);
            total = (TextView) itemView.findViewById(R.id.totalPrice);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.meal_food_choose, parent, false);
        ThisPanalViewHolder holder = new ThisPanalViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder rawHolder, int position) {
        ThisPanalViewHolder holder = (ThisPanalViewHolder) rawHolder;
        Glide.with(holder.itemView.getContext()).load(mealObjects.get(position).imageID).into(holder.foodImage);
        holder.foodImageText.setText(mealObjects.get(position).mealType);
        holder.pound1PriceText.setText(mealObjects.get(position).price1Lbs);
        holder.pound5PriceText.setText(mealObjects.get(position).price5Lbs);
        holder.total.setText(mealObjects.get(position).getTotal());
    }

    @Override
    public int getItemCount() {
        return mealObjects.size();
    }
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
            Context context = itemView.getContext();
            textPanal = (TextView) view.findViewById(R.id.textPanal);

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


