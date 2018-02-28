package com.ironkitchen.ironkitchenmob;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 2/22/18.
 */


// Adapter for RecyclerView inside meal_food_choose_selection.xml

class InnerSelectionsRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MealTabOjects> theseSelections;
    private  int selectionRowIndex = -1;

    public InnerSelectionsRVAdapter(){

    }

    public void setMealSelectionsObjects(ArrayList<MealTabOjects> currSelections)
    {
        if(this.theseSelections != currSelections)
        {
            this.theseSelections = currSelections;
            notifyDataSetChanged();
        }
    }

    public void setSelectionsIndex(int index)
    {
        this.selectionRowIndex = index;
    }

    public class ThisMealSelections extends RecyclerView.ViewHolder{

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

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
            quantity1Pound = (EditText) itemView.findViewById(R.id.quantityBox);
            pound5B = (Button) itemView.findViewById(R.id.pound5Button);
            pound5PriceText = (TextView) itemView.findViewById(R.id.pound5Price);
            quantity1Pound = (EditText) itemView.findViewById(R.id.quantityBox);
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
    private static ArrayList<ArrayList<MealTabOjects>> mMealObjects;
    private static String[] stringPanal;
    private static RecyclerView innerRV;

    public static class PanalViewHolder extends RecyclerView.ViewHolder {
        public final TextView textPanal;
        private InnerRVAdapter innerAdapter;

        public PanalViewHolder(View view) {
            super(view);
            Context context = itemView.getContext();
            textPanal = (TextView) view.findViewById(R.id.textPanal);
            innerRV = (RecyclerView) view.findViewById(R.id.mealPrepChoiceRecView);
            innerRV.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            innerAdapter = new InnerRVAdapter();
            innerRV.setAdapter(innerAdapter);
        }
    }

    public OuterRVAdapter(Context context, ArrayList<ArrayList<MealTabOjects>> mealOjects, String[] panalTitle) {
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
        holder.textPanal.setText(stringPanal[position]);
        holder.innerAdapter.setMealObjects(mMealObjects.get(position));
        holder.innerAdapter.setInnerRCIndex(position);
    }

    @Override
    public int getItemCount() {
        return mMealObjects.size();
    }
}

class MealAdapters {
    private ArrayList<MealTabOjects> protein, carbs, vegtables, personalMeals;
    private String[] panalTitles;
    private ArrayList<ArrayList<MealTabOjects>> mealSections;
    private Context context;

    public MealAdapters(Context context){
        this.context = context;

    }

    public ArrayList<ArrayList<MealTabOjects>> getPanals(){
        ArrayList<ArrayList<MealTabOjects>> thisList = new ArrayList<>();

        return thisList;
    }

    public ArrayList<MealTabOjects> getMealTabObjectsLit(int panal){
        ArrayList<MealTabOjects> panalList = new ArrayList<>();
        if(panal == 0){
            MealTabOjects steak = new MealTabOjects("Steak", R.drawable.steak);

            panalList.add(steak);
            MealTabOjects turkey = new MealTabOjects("Turkey", R.drawable.turkey);
            steak.addMealTabObject("1 lbs", 11.00);
            steak.addMealTabObject("5 lbs", 45.00);
            panalList.add(turkey);
            MealTabOjects cb = new MealTabOjects("Chicken Breast", R.drawable.chic_breast);
            cb.addMealTabObject("1 lbs Chipotle/dry", 10.00);
            cb.addMealTabObject("5 lbs Chipotle/dry", 40.00);
            cb.addMealTabObject("1 lbs Teriyaki/wet", 11.00);
            cb.addMealTabObject("5 lbs Teriyaki/wet",45.00);
            panalList.add(cb);
            MealTabOjects shredChic = new MealTabOjects("Shredded Chicken", R.drawable.shred_chicken);
            shredChic.addMealTabObject("1 lbs", 10.00);
            shredChic.addMealTabObject("5 lbs", 40.00);
            panalList.add(shredChic);
            return panalList;
        }
        else if(panal == 1){
            MealTabOjects redPot = new MealTabOjects("Red Potatoes", R.drawable.red_pot);
            redPot.addMealTabObject("1 lbs", 7.00);
            redPot.addMealTabObject("5 lbs", 30.00);
            redPot.addMealTabObject("1 lbs Cajun", 7.99);
            redPot.addMealTabObject("5 lbs Cajun",35.00);
            panalList.add(redPot);
            MealTabOjects jasRice = new MealTabOjects("Jasmine Rice", R.drawable.jasmine_rice);
            jasRice.addMealTabObject("1 lbs", 5.00);
            jasRice.addMealTabObject("5 lbs", 20.00);
            panalList.add(jasRice);
            MealTabOjects sweetPot = new MealTabOjects("Sweet Potatoes", R.drawable.sweet_potatoes);
            sweetPot.addMealTabObject("1 lbs",7.00);
            sweetPot.addMealTabObject("5 lbs", 30.00);
            sweetPot.addMealTabObject("1 lbs B. Suger Cinnimon", 7.99);
            sweetPot.addMealTabObject("1 lbs Cajun",7.99);
            panalList.add(sweetPot);
            return panalList;
        }
        else if(panal == 2)
        {
            MealTabOjects vegMed = new MealTabOjects("Vegetable Medley", R.drawable.veg_medley);
            vegMed.addMealTabObject("1 lbs", 8.00);
            vegMed.addMealTabObject("5 lbs",35.00);
            panalList.add(vegMed);
            MealTabOjects zucSquash = new MealTabOjects("Zucchini / Squash Mix", R.drawable.zuc_squash_mix);
            zucSquash.addMealTabObject("1 lbs",8.00);
            zucSquash.addMealTabObject("5 lbs",35.00);
            panalList.add(zucSquash);
            MealTabOjects broccoli = new MealTabOjects("Broccoli", R.drawable.broccoli);
            broccoli.addMealTabObject("1 lbs", 8.00);
            broccoli.addMealTabObject("5 lbs", 35.00);
            panalList.add(broccoli);
            return panalList;
        }
        else {
            MealTabOjects tacoBowl = new MealTabOjects("Taco Bowl", R.drawable.taco_bowl);
            tacoBowl.addMealTabObject("Chicken",7.00);
            tacoBowl.addMealTabObject("Turkey",7.00);
            panalList.add(tacoBowl);
            MealTabOjects bufChicRice = new MealTabOjects("Buffalo Chicken Rice", R.drawable.buff_chic_rice);
            bufChicRice.setPrice(8.00);
            panalList.add(bufChicRice);
            MealTabOjects chicPeppers = new MealTabOjects("Chicken Peppers", R.drawable.chicken_peppers);
            chicPeppers.setPrice(8.00);
            panalList.add(chicPeppers);
            return panalList;
        }

    }
}


